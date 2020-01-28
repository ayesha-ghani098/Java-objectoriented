/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleprogram;

class Circle{      //class
    double radius;   //attributes
    double area ;
    
   Circle(){     //constructor
       radius = 1.0;
   }
   
  Circle(double newrd){      //constructor
       
       radius = newrd;
   }
   public void getArea(){       //method
       area = radius*radius*3.142;
       System.out.println("Area of circle "+area);
   }
}
public class Circleprogram {

    
    public static void main(String[] args) {
       
        
        Circle circle1 = new Circle(10);  //constructor instance 
        circle1.getArea();          
      
    }
    
}
