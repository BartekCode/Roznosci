package debugPainCalc;

public class PaintCalculator {
    static final int SQM_TO_SQMCM = 10_000;

    static int calculatePaintAmount(Room room, PaintDetails paintDetails){
        int areaToPaint = room.getPaintArea();
        int coverage = paintDetails.getCoverage()*SQM_TO_SQMCM; //m^2 na cm^2
        int multipleCoatsArea = areaToPaint*paintDetails.getCoats();
        double paintLiters = multipleCoatsArea / coverage;
        double painLitersRoundUp = Math.ceil(paintLiters);
        return (int)painLitersRoundUp;//rzutowanie na int
    }
}
//W klasie PaintCalculator zdefiniowałem metodę calculatePaintAmount(),
// która zwraca liczbę litrów farby potrzebną do pomalowania danego pomieszczenia wybraną farbą.