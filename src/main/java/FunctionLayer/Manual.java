package FunctionLayer;

public class Manual {

    private Invoice invoice;

    public Manual(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    @Override
    public String toString() {
        return "Byggevejledning til carport\n\n "
                + "Husk ved modtagelse, at kontrollere de leverede materialer i forhold til styklisten.\n"
                + "l. Grundplan\nGrundplan afsættes ved at hamre en stump lægte i jorden til markering af hvert hjørne ud fra målene på din carport.\n"
                + "2. Markering af sider\nHæft en muresnor på tværs af carporten og langs siderne for at markere, hvor siderne er placeret.\n"
                + "3. Diagonalmål\nTag diagonalmål. Det er vigtigt, at det er det samme mål på begge diagonaler, da de afsatte mål er i vinkel. Det er meget vigtigt, at vinklerne er korrekte.  "
                + "4. Stolpehuller\nBor stolpehuller i jorden. Brug et pælebor, som passer til stolpernes tykkelse, samt en pælespade. "
                + "Ydersiden af stolpen skal flugte med med snoren. Hullerne skal bores max 90 cm dybe. Alle stolper skal være 230 over jord. Kan evt. særes til efter montering af rem."
                + "Husk at tage højde for, hvis terrænet skråner. Husk at bundsikre så stolperne ikke sætter sig."
                + "5. Montering af stolper\n "
                + "6."
                
                + "\nGod arbejdslyst\n"
                + "Anbefalet værktøj: Vaterpas, Mursnor, Pælebor, Spade, Sav, Hammer, Vinkel, Træbor 12mm, Skiftenøgle, Boremaskine, Skruemaskine, Wienerstige, Skruetvinger.";
    }

}
