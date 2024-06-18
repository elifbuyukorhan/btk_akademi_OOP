public class SecuritySystem extends Appliance {
    
    private String password;
    private int numberOfAlarms;
    private int numberOfCameras; 

    public SecuritySystem(boolean state, String room, int numberOfAlarms, int numberofCamera) {
        super(state, room);
        this.numberOfAlarms = numberOfAlarms;
        this.numberOfCameras = numberofCamera;
        System.out.println("Security system has been activated.");
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public boolean verifyPassword(String input) {
        if(this.password.equals(input)) {
            System.out.println("Password verified.");
            return true;
        } else {
            System.out.println("Password verification failed.");
            return false;
        }
    }

    public void checkAlarms() {
        System.out.println("The state of the alarms are checking...");
    }

    public void checkCameras()  {
        System.out.println("The cameras are checking...");
    }

    public void setAlarmNumber(int value) {
        this.numberOfAlarms = value;
    }

    public int getAlarmNumber() {
        return this.numberOfAlarms;
    }

    public void setCameraNumber(int value) {
        this.numberOfCameras = value;
    }

    public int getCameraNumber() {
        return this.numberOfCameras;
    }

    @Override
    public void turnOff() {
        this.state = false;
        System.out.println("The security system has been turned off.");
    }

    @Override
    public void turnOn() {
        this.state = true;
        System.out.println("The security system has been turned on.");  
    }

    @Override
    public String toString() {
        return "Security System";
    }
}
