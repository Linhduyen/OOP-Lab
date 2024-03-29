public class AIMS {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("meomeomeo", "huhu", "gaugau", 39, 92.1f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("chocho", "meo", "hehe", 87, 22.5f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("chichi", "cucuc", 12.9f);
        anOrder.addDigitalVideoDisc(dvd3);

        
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.printf("Total cost is: %.2f ", anOrder.totalCost());
    }
}
