package FunctionLayer;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
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
    
    public Document makeInvoiceTemplate() throws MalformedURLException {
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Font fontBold = FontFactory.getFont(FontFactory.COURIER_BOLD, 16, BaseColor.BLACK);
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String dest = customer.getName().toLowerCase() + date.format(dateFormatter) + ".pdf";
        Document invoice = null;
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            invoice = new Document(pdfDoc);
            ImageData data = ImageDataFactory.create("src/main/webapp/img/logo.png");
            Image image = new Image(data);
            invoice.add(image);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return invoice;
    }

    public Document makeInvoice(Customer customer, Construction order, Document template) {
        try {
            PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            Paragraph p1 = new Paragraph();
            Paragraph p2 = new Paragraph();
            Text name = new Text(customer.getName());
            Text email = new Text(customer.getEmail());
            Text phone = new Text(customer.getPhoneNumber());
            Text address = new Text(customer.getAddress());
            Text zip = new Text(customer.getZipcode());
            p1.add(name);
            p1.add("\n");
            p1.add(email);
            p1.add("\n");
            p1.add(phone);
            p1.add("\n");
            p1.add(address);
            p1.add("\n");
            p1.add(zip);
            p1.setFont(fontBold);
            template.add(p1);
            for (Material m : order.getMaterials()) {
                p2.add(m.getName() + " : " +m.getQty());
                p2.add("\n");
            }
            template.add(p2).setFont(font);
            template.close();
        } catch (IOException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return template;
    }

}
