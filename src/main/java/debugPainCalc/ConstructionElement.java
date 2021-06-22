package debugPainCalc;

public class ConstructionElement {
    private int width;
    private int height;

    public ConstructionElement(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getArea() {
        return width * height;
    }
}
//Klasa ConstructionElement reprezentuje okna i drzwi.Przechowujemy w niej wysokość i szerokość danego elementu i udostępniamy metodę obliczającą pole powierzchni.