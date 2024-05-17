package aims.test.disc;

import aims.cart.Cart;
import aims.media.*;

import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        List<Media> itemsInOrdered = anOrder.getItemsOrdered();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        anOrder.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star War", "Science Fiction", 24.95f, 87, "Geoger Lucas");
        anOrder.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Aladin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);
        Book book1 = new Book(4, "The Lion", "Animation", 19.95F);
        anOrder.addMedia(book1);
        Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

        Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
        for(Media m: itemsInOrdered){
            System.out.println(m.toString());
        }
        System.out.println();

        itemsInOrdered.sort(COMPARE_BY_COST_TITLE);
        for(Media m: itemsInOrdered){
            System.out.println(m.toString());
        }
        System.out.println();

        itemsInOrdered.sort(COMPARE_BY_TITLE_COST);
        for(Media m: itemsInOrdered){
            System.out.println(m.toString());
        }
        System.out.println();
    }
}