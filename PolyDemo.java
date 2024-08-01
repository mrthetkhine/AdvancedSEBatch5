abstract class Animal
{
    abstract void shout();
}
class Duck 
{
    void shout()
    {
        System.out.println("I am duck");
    }
}
class Goat extends Animal
{
    void shout()
    {
        System.out.println("I am goat");
    }
}
public class PolyDemo
{
    public static void main(String[]args)
    {
        Animal g = new Duck();
        g.shout();
        g = new Goat();
        g.shout();
    }
}