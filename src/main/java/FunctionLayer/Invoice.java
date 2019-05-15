package FunctionLayer;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Invoice {

    private final Customer customer;
    private final Construction order;
    private String fileName;

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
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    private void addHeader(PdfWriter writer) {

    }

    public Document makeInvoiceTemplate() throws MalformedURLException, IOException {
        PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String dest = customer.getName().toLowerCase() + date.format(dateFormatter) + ".pdf";
        setFileName(fileName);
        Document invoice = null;
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            pdfDoc.addNewPage(PageSize.A4);
            invoice = new Document(pdfDoc);
            ImageData data = ImageDataFactory.create("http://shop.johannesfog.dk/gfx/foglogok.png");//http://shop.johannesfog.dk/gfx/foglogok.png
            Image image = new Image(data);
            invoice.add(image);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return invoice;
    }

    public Document makeInvoice(Customer customer, Construction order) throws IOException {
        Document invoice = makeInvoiceTemplate();
        try {
            PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            Paragraph p1 = new Paragraph();
            Paragraph p2 = new Paragraph();
            Paragraph p3 = new Paragraph();
            Text name = new Text(customer.getName());
            Text email = new Text(customer.getEmail());
            Text address = new Text(customer.getAddress());
            Text phone = new Text(Integer.toString(customer.getPhoneNumber()));
            Text zip = new Text(Integer.toString(customer.getZipcode()));
            for (Material m : order.getMaterials()) {
                p2.add(m.getName() + " : " + m.getQty());
                p2.add("\n");
            }
            Text totalPrice = new Text(Double.toString(order.getTotalPrice()));
            p3.add(totalPrice);
            p1.add(name);
            p1.add("\n");
            p1.add(email);
            p1.add("\n");
            p1.add(address);
            p1.add("\n");
            p1.add(phone);
            p1.add("\n");
            p1.add(zip);
            invoice.add(p1).setFont(fontBold);
            invoice.add(p2).setFont(font);
            invoice.add(p3).setFont(font);
            invoice.close();
        } catch (IOException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoice;
    }

}
