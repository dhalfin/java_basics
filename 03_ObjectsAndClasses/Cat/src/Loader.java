
public class Loader {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("catCount = " + Cat.getCount());
        Cat sam = new Cat();
        System.out.println("catCount = " + Cat.getCount());
        Cat lucky = getKitten();
        Cat copy = sam.copy();
        System.out.println("catCount = " + Cat.getCount());
        Cat clone = sam.clone();
        Cat smokey = new Cat();
        Cat sassy = new Cat();
        Cat oreo = new Cat();
        System.out.println(sam.getWeight());
        sam.meow();
        System.out.println(sam.getWeight());
        System.out.println(lucky.getWeight());
        lucky.feed(356.3);
        System.out.println(lucky.getWeight());
        smokey.feed(7945.986);
        smokey.meowUntilDead();
        System.out.println(smokey.getWeight());
        System.out.println(smokey.getStatus());
        sassy.drink(564.45);
        System.out.println(sassy.getStatus());
        System.out.println(oreo.getWeight());
        //sam.feed(9999999.9);
        System.out.println("catCount = " + Cat.getCount());
        sam.feed(150.00);
        sam.pee();
        sam.pee();
        //sam.meow();

        System.out.println("Eaten food equal to " + sam.getEatenFood());
    }

    private static Cat getKitten()
    {
        //double weight = 100 + 100 * Math.random();
        double weight = 1100;
        return new Cat(weight, 50.0, 1200.0);
    }


}