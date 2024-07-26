class Goat
{
    shout()
    {
        console.log('I am goat');
    }
}
class Duck
{
    shout()
    {
        console.log('I am duck');
    }
}
let obj = new Goat();
obj.shout();
obj = new Duck();
obj.shout();
obj = {
    shout()
    {
        console.log('I am something');
    }
}
obj.shout();