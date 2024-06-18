public class Thermostat extends Appliance {

    private float temperature;

    public Thermostat(boolean state, String room, float temperature) {
        super(state, room);
        this.temperature = temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        System.out.println("The temperature has been set to " + temperature + " .");
    }

    public float getTemperature() {
        return this.temperature;
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println("The thermostat has been turned off.");
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println("The thermostat has been turned on.");  
    }

    @Override
    public String toString() {
        return "Thermostat";
    }
    
}
