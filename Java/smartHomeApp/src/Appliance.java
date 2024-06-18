public class Appliance implements Controllable {
    protected boolean state;
    protected String room; 

    public Appliance(boolean state, String room) {
        this.state = state;
        this.room = room;
    }

    public void setRoom(String value) {
        this.room = value;
    }

    public String getRoom() {
        return this.room;
    }

    @Override
    public boolean isOn() {
        if(this.state) {return true;} else {return false;}
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println("The appliance has been turned off.");
        
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println("The appliance has been turned on.");
        
    }    
    
}
