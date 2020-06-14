
public class Cat implements Cloneable
{
    public static final int EYES_AMOUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    private Double originWeight;
    private Double weight;
    private Double minWeight;
    private Double maxWeight;
    private double eatenFood;
    private static int count;
    private String color;


    public Cat()
    {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(double weight)
    {
        this(weight, weight, 1000.0, 9000.0, 0.0);
    }

    private Cat(double weight, double originWeight, double minWeight, double maxWeight, double eatenFood)
    {
        this.weight = weight;
        this.originWeight = originWeight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.eatenFood = eatenFood;
        if(isAlive())
          count++;
    }

    Cat(double weight, double minWeight, double maxWeight)
    {
        this(weight, weight, minWeight, maxWeight, 0.0);
    }

    public Cat(Cat other)
    {
        this(other.weight, other.originWeight, other.minWeight, other.maxWeight, other.eatenFood);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected void setEatenFood (double eatenFood) {
        if(isAlive()) {
            this.eatenFood = eatenFood;
        }
    }

    protected void addEatenFood (double eatenFood) {
        setEatenFood(getEatenFood() + eatenFood);
    }

    public double getEatenFood() {
        return eatenFood;
    }

    public static int getCount() {
        return count;
    }

    public void meowUntilDead() {
       while (isAlive()) {
           meow();
       }
    }

    public void meow() {
        addWeight(-1.0);
        if(isAlive()) {
            System.out.println("Meow");
        }
    }


    public void feed(Double amount) {
        if(isAlive())
        {
            addEatenFood(amount);
            addWeight(amount);
        }
    }

    public void drink(Double amount) {
        addWeight(amount);
    }

    protected void setWeight(Double weight) {
        if(isAlive()) {
            this.weight = weight;
            if(!isAlive()) {
                count--;
            }
        }
    }

    private boolean isAlive()
    {
        return  getWeight() >= minWeight && getWeight() <= maxWeight;
    }

    protected void addWeight (Double weight)
    {
        setWeight(getWeight() + weight);
    }


    public Double getWeight()
    {
        return weight;
    }

    public Double getOriginWeight()
    {
        return originWeight;
    }

    public void pee()
    {
        if(isAlive())
        {
            double shrinkage = Math.random() * 20.0;
            addWeight(-shrinkage);
            System.out.println("Shrinkage equal to " + shrinkage);
        }
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public Cat copy()
    {
        return new Cat(this);
    }

    public static Cat copy(Cat other)
    {
        return new Cat(other);//other.copy();
    }
//------------------------------------------------------//
    @Override
    public Cat clone() throws CloneNotSupportedException
    {
        if(isAlive())
            count++;
        return (Cat) super.clone();
    }

    public static Cat clone(Cat other) throws CloneNotSupportedException
    {
        return other.clone();
    }
}