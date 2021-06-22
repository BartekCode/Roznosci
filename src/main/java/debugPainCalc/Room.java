package debugPainCalc;

import java.util.Arrays;

public class Room {
    private int width;
    private int height;
    private int length;
    private ConstructionElement[] constructionElements; //tablica

    public Room(int width, int height, int length, ConstructionElement[] constructionElements) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.constructionElements = constructionElements;
    }

    int getWallArea() {
        return 2 * (width * height + length * height);
    }


    int getConstructionElementsArea(){//zwraca całkowitą powierzchnię okien i drzwi w danym pomieszczeniu.
        return Arrays.stream(constructionElements) //zamiana tablicy na stream mapowanie i suma
                .mapToInt(ConstructionElement::getArea)
                .sum();
    }
    int getPaintArea(){//zwraca pole powierzchni do pomalowania, które jest różnicą całkowitej powierzchni ścian i powierzchni okien i drzwi.
        int WallArea = getWallArea();
        int cutArea = getConstructionElementsArea();
    return WallArea-cutArea;
    }
}
