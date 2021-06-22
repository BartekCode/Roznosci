package debugPainCalc;

public class PaintDetails {
    private int coverage;
    private int coats;

    public int getCoverage() {
        return coverage;
    }

    public int getCoats() {
        return coats;
    }

    public PaintDetails(int coverage, int coats) {
        this.coverage = coverage;
        this.coats = coats;
    }
}
//Klasa PaintDetails przechowuje informacje o farbie,
// czyli to jakie jest jej krycie (np. że litr farby wystarcza na 10mkw ściany) oraz ile warstw farby będzie nakładane.'