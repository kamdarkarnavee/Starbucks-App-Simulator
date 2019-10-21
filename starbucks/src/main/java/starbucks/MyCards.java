

package starbucks ;

/** My Cards Screen */
public class MyCards extends Screen
{
    private ITouchEventHandler chain;
    private MyCardsPay mp;
    private double balance;

    public MyCards()
    {
       mp = new MyCardsPay();
       balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    void setBalance(double balance){
        this.balance = balance;
    }

    public String display(){
        return String.format("$%.2f\n", getBalance());
    }
   
}
