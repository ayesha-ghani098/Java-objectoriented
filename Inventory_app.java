/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_app;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Technolet
 */
//                               //
//       CLASS INVENTORY         //    
//                               //
class inventory {

    ArrayList<Item> IItem = new ArrayList();

    ArrayList<Order> Order = new ArrayList();

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

public class Inventory_app {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static Order orders = new Order();

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
            System.out.println("Added..");
        } else if (category == 3) {
            System.out.println("-----ELECTRONICS-----");
            System.out.print("Enter Name: ");
            String name = input.next();
            System.out.print("Enter Quantity: ");
            int quantity = input.nextInt();
            System.out.print("Enter Price: ");
            double price = input.nextDouble();
            electronics obj = new electronics(name, price, quantity);
            obj2.addInventory(obj);
            System.out.println("Added..");
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
            System.out.println("Orders\n" + k + " ");
            System.out.println("_____________________________");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

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
}
