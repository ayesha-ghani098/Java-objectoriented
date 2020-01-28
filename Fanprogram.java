
package fanprogram;

class Fan{
    static int SLOW = 1;
    static int MEDIUM = 2;
    static int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    String color = "blue";
    
    
    public Fan()
   {
   //Initialize the variables
   speed = 0;
   on = false;
   radius = 0.0;
   color = "";
   }
    
    //Declare the method toString()
public String toString()
{
//Initialize the string variable
String onOrOff;

//Check the condition
if(isfanOn()){

//True, on the fan
onOrOff="on";
}

//Otherwise
else

//Off the fan
onOrOff="off";
 
//Check the condition
if(on)
{
//Checking Whether Fan is on/off
return"A "+this.getRadius()+" inch "+this.getColor()+" fan at a speed of "+this.getSpeed();
}

//Otherwise
else
{
//Checking Whether Fan is on/off
return"A "+this.radius+" inch "+this.getColor()+" fan; fan is "+onOrOff;
}
}
 
    
    public void setSpeed(int sp){
        speed = sp;
    }
    public void setOn(boolean st){
        on = st;
    }
    public void setRadius(double r){
        radius = r;
    }
    public void setColor(String c){
        color = c;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public boolean isfanOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    
}
public class Fanprogram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Create object for Fan class
Fan fan1 = new Fan();

//Call the methods using fan1 object
fan1.setSpeed(Fan.MEDIUM);
fan1.setRadius(6);
fan1.setColor("Ivory");
fan1.setOn(true);

//Print statement
System.out.println(fan1.toString());
    }
    
}
