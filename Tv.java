
package tv;

class Television{
    int channel;
    int volumelevel;
    boolean on;
    
  Television() {
    on = false;
}
  
  public void turnon() {
      on = true;
      System.out.println("TV turns on");
  }
  
  public void turnoff() {
      on = false;
  }
  public void setChannel(int newchannel){
      channel = newchannel;
      System.out.println("channel has set to channel no: "+channel);
  }
  public void setVolume(int newvolume){
      volumelevel = newvolume;
        System.out.println("volume has set to "+volumelevel);
  }
  public void ChannelUp(){
      int cu =channel+=1;
      System.out.println(cu);
  }
  public void ChannelDown() {
      int cd = channel-=1;
       System.out.println(cd);
  }
  public void VolumeUp() {
      int vu = volumelevel+=1;
       System.out.println(vu);
  }
  public void VolumeDown() {
      int vd = volumelevel-=1;
       System.out.println(vd);
  }
}
public class Tv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Television tv = new Television();
       
        tv.turnon();
        tv.setChannel(12);
        tv.setVolume(21);
        tv.ChannelUp();
        tv.ChannelDown();
        tv.VolumeUp();
        tv.VolumeDown();
        
    }
    
}
