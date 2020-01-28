/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangle;

/**
 *
 * @author tuser
 */
class Rectangle1{
    double w;
    double h;
    double rectangle;
    double area;
    double parameter;
    
    Rectangle1(){
        w =1;
        h =1;
        System.out.println(w*h);
    }
    Rectangle1(double w, double h){
        this.w =w;
        this.h = h;
    }
    @Override
    public String toString(){ //overloading parent method
        return "height is "+h+" width is "+w;
    }
    
    public double getArea(){
        return w*h;
    }
   public double getParameter(){
      parameter = 2*w+2*h;
      return parameter;
    }
    
}

public class Rectangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle1 obj = new Rectangle1(4,40);
        
         System.out.println(obj);
        System.out.println(obj.getArea());
        System.out.println(obj.getParameter());
        
        Rectangle1 obj2 = new Rectangle1(3.5,39.5);
        
        System.out.println(obj2);
        System.out.println(obj2.getArea());
        System.out.println(obj2.getParameter());
       
        
    }
    
    
}
