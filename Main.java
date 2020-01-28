/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21_jan;

/**
 *
 * @author tuser
 */

class GC extends Customer{
    
   double  remmins;
  @Override
    public double RecordCall(double Calltype, double minutes){
        remmins += minutes;
        if(Calltype ==2){
        if (remmins <= 60){
           balance -= 2*minutes;
           
           }
        else {
            balance -= 0.2*minutes;
            
         }
        }
        
   return balance; 
}

}
class Customer{
    String name;     //string class ,,name is object of class string 
    protected double balance;
    
    public void setbal(double bal){
        balance = bal;
    }
    public String toString(){
        return "Name: "+name+" Balance is "+balance;
    }
    
    public double RecordCall(double Calltype, double minutes){
       if(Calltype == 1){
           balance -= 0.5*minutes;
       }
       else{
           balance -= 1*minutes;    
       }
        
      return balance;  
    }
    public void RecordPayment(double amountpaid)
    {
        balance -= amountpaid;
    }
}
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       Customer cus1 = new Customer();
       cus1.setbal(1000);
       System.out.println(cus1.RecordCall(1, 10));
       
      GC cus2 = new GC();
      cus2.setbal(2000);
      System.out.println(cus2.RecordCall(2,10)); // because inherited from parent class
        System.out.println(cus2.RecordCall(2,30)); 
          System.out.println(cus2.RecordCall(2,50)); 
      
       
    }
    
}
