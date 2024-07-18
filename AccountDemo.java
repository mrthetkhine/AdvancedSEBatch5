class Account{
    private int total;
    
    void credit(int amount)
    {
        if(amount >0)
        {
            this.total += amount;
        }
        
    }
    void debit(int amount)
    {
        if(this.total>= amount && amount >0)
        {
            this.total -= amount;
        }
        
    }
    /* 
    public void setTotal(int amount)
    {
        this.total = amount;
    }
    */
   
    public int getBalance()
    {
        return total;
    }
}
public class AccountDemo
{
    public static void main(String[]args)
    {
        Account account = new Account();
        account.credit(-100);
        account.debit(40);

        System.out.println("Balance "+account.getBalance());
    }
}