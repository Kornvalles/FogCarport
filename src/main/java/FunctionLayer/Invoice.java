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
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

/**
 *
 * @author mikkel
 */
public class Invoice {

    private final Customer customer;
    private final Construction order;

    /**
     *
     * @param customer
     * @param order
     */
    public Invoice(Customer customer, Construction order) {
        this.customer = customer;
        this.order = order;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @return
     */
    public Construction getOrder() {
        return order;
    }

    /**
     * 
     * @param dest
     * @return
     * @throws MalformedURLException
     * @throws IOException 
     */
    private static Document makeInvoiceTemplate(OutputStream dest) throws MalformedURLException, IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage(PageSize.A4);
        Document invoice = new Document(pdfDoc);
        ImageData data = ImageDataFactory.create("http://shop.johannesfog.dk/gfx/foglogok.png");//http://shop.johannesfog.dk/gfx/foglogok.png
        Image image = new Image(data).scale(0.5f, 0.5f);
        image.setFixedPosition(PageSize.A4.getRight() - (image.getImageWidth() * 0.5f), PageSize.A4.getHeight() - (image.getImageHeight() * 0.5f));
        invoice.add(image);
        return invoice;
    }

    /**
     *
     * @param customer
     * @param order
     * @param dest
     * @return
     * @throws IOException
     */
    public static Document makeInvoice(Customer customer, Construction order, OutputStream dest) throws IOException {
        Document invoice = makeInvoiceTemplate(dest);
        Manual manual = new Manual();
        PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont fontClear = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        Paragraph p1 = new Paragraph();
        Paragraph p2 = new Paragraph();
        Paragraph p3 = new Paragraph();
        Paragraph p4 = new Paragraph(manual.toString());
        Text name = new Text(customer.getName());
        Text email = new Text(customer.getEmail());
        Text address = new Text(customer.getAddress());
        Text phone = new Text(Integer.toString(customer.getPhoneNumber()));
        Text zip = new Text(Integer.toString(customer.getZipcode()));
        Table materials = new Table(5).useAllAvailableWidth();
        materials.startNewRow().addCell("Materialeliste");
        materials.startNewRow();
        for (Material m : order.getMaterials()) {
            materials.addCell(m.getName());
            materials.addCell(Integer.toString(m.getId()));
            materials.addCell(Integer.toString(m.getQty()));
            materials.addCell(m.getUnit());
            materials.addCell(m.getDescription());
        }
        materials.setAutoLayout();
        p2.add(materials);
        Text totalPriceWithoutVAT = new Text(String.format("%.2f",order.getTotalPrice()*0.5));
        Text VAT = new Text(String.format("%.2f",order.getTotalPrice()*0.25)).setOpacity(0.6f);
        Text totalPrice = new Text(String.format("%.2f",order.getTotalPrice())+" kr. inkl. moms");

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
        invoice.add(p1).setFont(font);
        invoice.add(p2).setFont(font);
        invoice.add(p3).setFont(font);
        invoice.add(p4).setFont(font);
        invoice.close();
        return invoice;
    }

}
