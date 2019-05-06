package FunctionLayer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Invoice {
    
    private final Customer customer;
    private final Construction order;

    public Invoice(Customer customer, Construction order) {
        this.customer = customer;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Construction getOrder() {
        return order;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.customer);
        hash = 53 * hash + Objects.hashCode(this.order);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Invoice other = (Invoice) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        return true;
    }
    
    public Document makeInvoice(Customer customer, Construction order) {
        FileOutputStream out = null;
        Document invoice = new Document(PageSize.A4, 36, 36, 90, 36);
        try {
            LocalDate date = LocalDate.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            //File file = new File(customer.getName().toLowerCase()+date.format(dateFormatter)+".pdf");
            PdfWriter.getInstance(invoice, new FileOutputStream(customer.getName().toLowerCase()+date.format(dateFormatter)+".pdf"));
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            invoice.open();
            //invoice.newPage();
            invoice.addTitle("Fog faktura");
            for ( Material m : order.getMaterials() ) {
                invoice.add( new Paragraph(m.getName()+" : "+m.getQty(), font) );
            }
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                invoice.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return invoice;
    }
    
}
