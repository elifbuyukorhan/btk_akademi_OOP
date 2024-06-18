public class Light extends Appliance {
    // Brightness level is between 0-5.
    private int brightness;

    public Light(boolean state, String room, int brightness) {
        super(state, room); 

        if(brightness==0) {
            this.state = false;
        } else if (0 < brightness && brightness < 6) {
            this.state = true;
        } else {
            this.state = false;
            throw new IllegalArgumentException("Brightness value must be between 0 and 5 (inclusive).");
        }

        this.brightness = brightness;
    }

    public int getBrightnessLevel() {
        return this.brightness;
    }

    void setBrightnessLevel(int value) {
        this.brightness = value;
        System.out.println("The brightness level has been set to " + this.brightness + " .");
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println("The light has been turned off.");
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println("The light has been turned on.");  
    }

    @Override
    public String toString() {
        return "Light";
    }
}
