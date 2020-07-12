/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_payroll_linkedto_interface;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Technolet
 */
//                Interface                   //    
interface Ipayment {

    public double ipayment();
}

//           Payroll Application              //    
//                         //
//     Employee Class      //
//                         //
abstract class Employee implements Ipayment {

    String firstName;
    String lastName;
    String socialsecurityNumber;
    double earned;
}

//                         //
// Salaried Employee Class //
//                         //
class Salaried_Employee extends Employee implements Ipayment {

    double weeklySalary;

    public Salaried_Employee(String fn, String Ln, String ssn, double ws) {
        this.firstName = fn;
        this.lastName = Ln;
        this.socialsecurityNumber = ssn;
        this.weeklySalary = ws;
    }

    @Override
    public double ipayment() {
        earned = weeklySalary;
        return earned;
    }

    @Override
    public String toString() {
        return "Salaried Employee: " + firstName + " " + lastName + "\n Social Security Number:  " + socialsecurityNumber + "\n Weekly Salary: " + weeklySalary;
    }
}
//                         //
//   Hourly Employee Class //
//                         //

class Hourly_Employee extends Employee implements Ipayment {

    double hourlywage;
    int hours_worked;

    public Hourly_Employee(String fn, String Ln, String ssn, double hw, int hwk) {
        this.firstName = fn;
        this.lastName = Ln;
        this.socialsecurityNumber = ssn;
        this.hourlywage = hw;
        this.hours_worked = hwk;
    }

    @Override
    public double ipayment() {
        if (hours_worked <= 40) {
            earned = hourlywage * hours_worked;
        } else if (hours_worked > 40) {
            earned = 40 * hourlywage + (hours_worked - 40) * hourlywage * 1.5;
        }
        return earned;
    }

    @Override
    public String toString() {
        return "Hourly Employee " + firstName + " " + lastName + "\n Social Security Number  " + socialsecurityNumber + "\n Hourly Wage " + hourlywage + "Hours Worked " + hours_worked;
    }
}
//                         //
//Commission Employee Class//
//                         //

class Commission_Employee extends Employee implements Ipayment {

    double gross_sales;
    double commission_rates;

    public Commission_Employee(String fn, String Ln, String ssn, double cr, double gs) {
        this.firstName = fn;
        this.lastName = Ln;
        this.socialsecurityNumber = ssn;
        this.commission_rates = cr;
        this.gross_sales = gs;
    }

    @Override
    public double ipayment() {
        earned = commission_rates * gross_sales;
        return earned;
    }

    @Override
    public String toString() {
        return "Commission Employee " + firstName + " " + lastName + "\n Social Security Number  is " + socialsecurityNumber + "\n Gross Sales " + gross_sales + " \n Commission Rates " + commission_rates;
    }
}
//                                //
//Base + Commission Employee Class//
//                                //

class BasePlus_Commission_Employee extends Commission_Employee implements Ipayment {

    double base_salary;

    public BasePlus_Commission_Employee(String fn, String Ln, String ssn, double cr, double gs, double bs) {
        super(fn, Ln, ssn, cr, gs);
        this.base_salary = bs;
    }

    public double newbase() {
        double percent = base_salary * 0.1;
        double newbasesalary = base_salary + percent;
        return newbasesalary;
    }

    @Override
    public double ipayment() {
        earned = (commission_rates * gross_sales) + newbase();
        return earned;
    }

    @Override
    public String toString() {
        return "Commission Employee " + firstName + " " + lastName + "\n Social Security Number  is " + socialsecurityNumber + "\n Gross Sales " + gross_sales + "  Commission Rates " + commission_rates + " Base Salary " + base_salary;
    }
}
//       Inventory System Application         //    
//                               //
//       CLASS INVENTORY         //    
//                               //

class inventory implements Ipayment {

    double amount;
    ArrayList<Item> IItem = new ArrayList();

    ArrayList<Order> Order = new ArrayList();

    @Override
    public double ipayment() {
        return amount;
    }

    public void setamount(double prices, int quan) {
        this.amount = prices * quan;
    }

    public void addInventory(Item I) {
        IItem.add(I);
    }

    public ArrayList getInventory() {
        return IItem;
    }

    public void addOrders(Order O) {
        Order.add(O);
    }

    public ArrayList getOrders() {
        return Order;
    }

    public int getsize() {
        int size = IItem.size();
        return size;
    }

    @Override
    public String toString() {
        return "Inventory Item \n ---------\n" + IItem + "\nOrders" + "-------\n " + Order;
    }
}
//                               //
//         CLASS ORDER           //    
//                               //

class Order {

    String customerName;
    double orderTotal = 0;
    ArrayList<Item> OrderedItems = new ArrayList();

    public void setname(String n) {
        this.customerName = n;
    }

    public void addItem(Item i) {

        OrderedItems.add(i);
        orderTotal = orderTotal + (i.price * i.quantity);
    }

    public void removeItem(Item i) {
        OrderedItems.remove(i);
        orderTotal = orderTotal - (i.price * i.quantity);
    }

    public String toString() {
        return "Customer Name: " + this.customerName + "\n  Order Total: " + this.orderTotal + "\n  Order Items: " + this.OrderedItems;
    }
}
//                               //
//          CLASS ITEM           //    
//                               //

class Item {

    String name;
    double price;
    int quantity;
    String type;

    public Item() {

    }

    public Item(String tpe, String Name, double Prc, int Qty) {
        this.name = Name;
        this.price = Prc;
        this.quantity = Qty;
        this.type = tpe;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setType(String t) {
        this.type = t;
    }

    public String getType() {
        return type;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public String getname() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "| Name: " + getname() + "| Price: " + getPrice() + "| Quantity: " + getQuantity();
    }
}
//                               //
//   ITEM CHILD CLASS CLOTHES    //    
//                               //

class clothes extends Item {

    public clothes(String Name, double Prc, int Qty) {
        setName(Name);
        setQuantity(Qty);
        setPrice(Prc);
        setType("Clothes");
    }
}
//                               //
//  ITEM CHILD CLASS COSMETICS   //    
//                               //

class cosmetics extends Item {

    public cosmetics(String Name, double Prc, int Qty) {
        setName(Name);
        setQuantity(Qty);
        setPrice(Prc);
        setType("Cosmetics");
    }
}
//                               //
//  ITEM CHILD CLASS ELECTRONICS //    
//                               //

class electronics extends Item {

    public electronics(String Name, double Prc, int Qty) {
        setName(Name);
        setQuantity(Qty);
        setPrice(Prc);
        setType("Electronics");
    }
}

public class Inventory_payroll_linkedto_interface {

    static Scanner input = new Scanner(System.in);
    static Order orders = new Order();
    static ArrayList<Double> ipayment = new ArrayList<>();
    static double finalpayment = 0;
    static double add;
//                               //
//      Inventory working        //    
//                               //

    public static void menu() {
        System.out.println("|-----------------------------|");
        System.out.println("Welcome to Mini Inventory System");
        System.out.println("|-----------------------------|");
        System.out.println("Choose an Option");
        System.out.println("_____________________________");
        System.out.println("1.Add Inventory");
        System.out.println("2.Place Order");
        System.out.println("3.Show Inventory");
        System.out.println("4.Show Order");
        System.out.println("5.Show All Details");
        System.out.println("6.Exit System");
    }
    static inventory obj2 = new inventory();

    public static void choice1() {
        System.out.println("|-----------------------------|");
        System.out.println("Select Category");
        System.out.println("_____________________________");
        System.out.println("1.CLOTHES");
        System.out.println("2.COSMETICS");
        System.out.println("3.ELECTRONICS");
        int category = input.nextInt();

        if (category == 1) {
            System.out.println("-----CLOTHES-----");
            System.out.print("Enter Name: ");
            String name = input.next();
            System.out.print("Enter Quantity: ");
            int quantity = input.nextInt();
            System.out.print("Enter Price: ");
            double price = input.nextDouble();
            clothes obj = new clothes(name, price, quantity);
            obj2.addInventory(obj);
            System.out.println("Added..");
            obj2.setamount(price, quantity);
            add = obj2.ipayment();
            ipayment.add(add);
            System.out.println(add);

        } else if (category == 2) {
            System.out.println("-----COSMETICS-----");
            System.out.print("Enter Name: ");
            String name = input.next();
            System.out.print("Enter Quantity: ");
            int quantity = input.nextInt();
            System.out.print("Enter Price: ");
            double price = input.nextDouble();
            cosmetics obj = new cosmetics(name, price, quantity);
            obj2.addInventory(obj);
            obj2.setamount(price, quantity);
            add = obj2.ipayment();
            System.out.println("Added..");
            ipayment.add(add);
        } else if (category == 3) {
            System.out.println("-----ELECTRONICS-----");
            System.out.print("Enter Name: ");
            String name = input.next();
            System.out.print("Enter Quantity: ");
            int quantity = input.nextInt();
            System.out.print("Enter Price: ");
            double price = input.nextDouble();
            electronics obj = new electronics(name, price, quantity);
            obj2.setamount(price, quantity);
            obj2.addInventory(obj);
            System.out.println("Added..");
            add = obj2.ipayment();
            ipayment.add(add);
        }
        System.out.println("Choose an Option");
        System.out.println("_____________________________");
        System.out.println("1.Add More Inventory");
        System.out.println("2.Return to menu");
        int ch = input.nextInt();
        if (ch == 1) {
            choice1();
        }

    }

    public static void choice3() {
        System.out.println("Inventory Items");
        System.out.println("_____________________________");
        int list = obj2.getsize();
        for (int a = 0; a < list; a++) {
            System.out.println(obj2.getInventory().get(a));
        }
    }
    static int b;
    static int t = 0;
    static int bp;

    public static void choice2() {

        System.out.println("What you want to Order?");
        System.out.println("_____________________________");
        int list = obj2.getsize();
        for (int a = 0; a < list; a++) {
            System.out.println(obj2.getInventory().get(a));
        }
        System.out.print("Please select Item \n>:");
        String name = input.next();

        for (Item i : obj2.IItem) {
            if (i.name.equals(name)) {
                System.out.print("Quantity: ");
                int quanReq = input.nextInt();
                if (quanReq > i.quantity) {
                    System.out.println("Error: item is not available in required quantity");
                } else {

                    orders.addItem(new Item(i.type, i.name, i.price, quanReq));
                    i.setQuantity(i.quantity - quanReq);

                    System.out.println("Added Order ");
                }

            }
        }
        System.out.println(" ");
        System.out.println("Want to buy more items?");
        System.out.println("1. Yes \n2.Remove item \n3. No just place my order ");
        bp = input.nextInt();
        System.out.println(" ");
        if (bp == 1) {
            choice2();
        } else if (bp == 2) {
            System.out.print("Enter name of item you want to remove: ");
            name = input.next();
            for (Item i : obj2.IItem) {
                if (i.name.equals(name)) {
                    System.out.print("Quantity: ");
                    int quanReq = input.nextInt();
                    orders.removeItem(new Item(i.type, i.name, i.price, quanReq));
                    obj2.addOrders(orders);
                    i.setQuantity(i.quantity + quanReq);

                }
            }

        } else if (bp == 3) {
            System.out.println("Enter Your Name");
            String cusname = input.next();
            orders.setname(cusname);
            System.out.println("Your Order is Placed");
            System.out.println("Your Order Details are: ");
            System.out.println(orders.toString());

        }

    }

    public static void choice4() {
        System.out.println("Orders");
        System.out.println("_____________________________");
        for (Order k : obj2.Order) {
            System.out.println("Orders\n" + k + " ");
        }
    }

    public static void choice5() {
        System.out.println("|-------------------------|");
        System.out.println("All Details Are:");
        System.out.println("|-------------------------|");
        System.out.println("_____________________________");
        System.out.println("Inventory Items");
        System.out.println("_____________________________");
        int list = obj2.getsize();
        for (int a = 0; a < list; a++) {
            System.out.println(obj2.getInventory().get(a));
        }
        System.out.println("_____________________________");
        System.out.println("Orders");
        System.out.println("_____________________________");
        for (Order k : obj2.Order) {
            System.out.println("Order\n" + k + " ");
            System.out.println("_____________________________");
        }
    }

    public static void InventarySys() {
        int choice;
        do {
            menu();
            choice = input.nextInt();
            if (choice == 1) {
                choice1();

            } else if (choice == 2) {
                choice2();
                obj2.addOrders(orders);
            } else if (choice == 3) {
                choice3();
            } else if (choice == 4) {
                choice4();
            } else if (choice == 5) {
                choice5();
            }

        } while (choice != 6);
        System.out.println("Thanks for Using Inventory System Designed by Ayesha Ghani");
    }
//                               //
//      Inventory working        //    
//                               //

    public static void PayrollApp() {
        ArrayList Employees = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("1.Wanna Check Out List?");
        System.out.println("Or");
        System.out.println("2.Check Earning");
        int t = input.nextInt();
        if (t == 1) {
            for (int a = 0; a < Employees.size(); a++) {
                System.out.println("Employee " + a + " is a " + Employees.get(a));
            }
        } else {
            System.out.println("Hows many Employees you wanna enter");
            int check = input.nextInt();

            int E_category;
            for (int i = 1; i <= check; i++) {
                System.out.println("Which Employee Are you");
                System.out.println("1.Salaried Employee");
                System.out.println("2.Hourly Employee");
                System.out.println("3.Commision Employee");
                System.out.println("4.Commission + Base Salary Employee");
                E_category = input.nextInt();

                if (E_category == 1) {
                    Employees.add("SalariedEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Weekly Salary");
                    double weeklysalary = input.nextDouble();

                    Salaried_Employee obj = new Salaried_Employee(firstname, lastname, ssnnumber, weeklysalary);

                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.ipayment());
                    ipayment.add(obj.ipayment());

                } else if (E_category == 2) {
                    Employees.add("HourlyEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Hourly Wage");
                    double hourlywage = input.nextDouble();
                    System.out.println("How Many hours you worked?");
                    int hourswork = input.nextInt();

                    Hourly_Employee obj = new Hourly_Employee(firstname, lastname, ssnnumber, hourlywage, hourswork);
                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.ipayment());
                    ipayment.add(obj.ipayment());
                } else if (E_category == 3) {
                    Employees.add("CommissionEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Sales");
                    double sales = input.nextDouble();
                    System.out.println("Enter your Comission Rates");
                    double cm = input.nextDouble();

                    Commission_Employee obj = new Commission_Employee(firstname, lastname, ssnnumber, cm, sales);
                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.ipayment());
                    ipayment.add(obj.ipayment());
                } else if (E_category == 4) {
                    Employees.add("Base+CommissionEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Sales");
                    double sales = input.nextDouble();
                    System.out.println("Enter your Comission Rates");
                    double cm = input.nextDouble();
                    System.out.println("Enter your Base Salary");
                    double bs = input.nextDouble();

                    BasePlus_Commission_Employee obj = new BasePlus_Commission_Employee(firstname, lastname, ssnnumber, cm, sales, bs);
                    System.out.println(obj.toString());
                    System.out.println("New base salary with 10% increase is: " + obj.newbase());
                    System.out.println("Earned: " + obj.ipayment());
                    ipayment.add(obj.ipayment());
                } else {
                    System.out.println("Entered Invalid Number");
                    System.out.println("Enter  Again");
                    E_category = input.nextInt();
                }

            }
        }

        System.out.println("Wanna Check Out List? Enter Yes or No");
        String s = input.next();
        if (s == "Yes" || s != "No") {
            for (int a = 0; a < Employees.size(); a++) {
                System.out.println("Employee " + a + " is a " + Employees.get(a));
            }

        } else {
            System.out.println("Fine! As you Wish");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int select;
        do {
            System.out.println("Select Mode");
            System.out.println("1.Inventory System Application");
            System.out.println("2.Payroll Application");
            System.out.println("3.Payment Data of Both Applications ");
            System.out.println("4.Exit System? ");
            select = input.nextInt();
            if (select == 1) {
                InventarySys();
            } else if (select == 2) {
                PayrollApp();
            } else if (select == 3) {

                for (int h = 0; h < ipayment.size(); h++) {
                    finalpayment += ipayment.get(h);

                }
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Organization Paid '" + finalpayment + "' to Suppliers and Employees ");
                System.out.println("-----------------------------------------------------------------");
            }
        } while (select != 4);
        System.out.println("Thank You For Using");
    }

}
