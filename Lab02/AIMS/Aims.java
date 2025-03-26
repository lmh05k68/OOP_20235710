package Aims_project;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        anOrder.printCart();
        //test delete
        anOrder.removeDigitalVideoDisc(dvd2);
        DigitalVideoDisc[] dvdList = {dvd2, dvd3};
        //test add
        anOrder.addDigitalVideoDisc(dvdList);
        
        //test check in4
        dvd1.printInfo();
        dvd2.printInfo();
        dvd3.printInfo();
	}
}