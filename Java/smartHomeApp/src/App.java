import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Appliance[] appliances = new Appliance[50];
        boolean isFinish = false;
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        while(!isFinish) {

            System.out.println("Please enter the appliance name to add to the smart home system: ");
            String applianceName = scanner.nextLine();

            System.out.println("Please enter the location of the appliance: (room)");
            String room = scanner.nextLine();

            switch(applianceName) {
                case "Light":
                    Light light = new Light(false, room, 0);
                    appliances[count] = light;
                    count++;
                    break;

                case "Thermostat":
                    Thermostat thermostat = new Thermostat(false, room, 20);
                    appliances[count] = thermostat;
                    count++;
                    break;

                case "Security System":
                    SecuritySystem securitySystem = new SecuritySystem(false, room, 1, 1);
                    appliances[count] = securitySystem;
                    count++;
                    break;
                default:
                    System.out.println("Please enter a valid appliance!");
                    continue;
            }
            System.out.println("Have you finished adjustments? (yes/no)");
            String q = scanner.nextLine();
            if (q.equals("yes")) {isFinish = true;} 
        } 

        System.out.println("There are " + count + " appliances in the smart home.");
        System.out.println("Appliances List: ");

        for(Appliance appliance : appliances) {
            if(appliance != null) {
                System.out.println(appliance);
            }
        }

        while (true) {
            System.out.println("Which one do you want to change?");
            String applianceString = scanner.nextLine();

            Appliance foundAppliance = null;
            for (Appliance appliance : appliances) {
                if (appliance != null && appliance.toString().equals(applianceString)) {
                    foundAppliance = appliance;
                    break;
                }
            }

            if (foundAppliance != null) {
                System.out.println("Found: " + foundAppliance);
                // Nesne türüne göre işlem yapın
                if (foundAppliance instanceof Light) {
                    Light light = (Light) foundAppliance;
                    System.out.println("Current brightness: " + light.getBrightnessLevel());
                    System.out.println("Enter new brightness:");
                    int newBrightness = scanner.nextInt();
                    scanner.nextLine(); // buffer temizleme
                    light.setBrightnessLevel(newBrightness);
                } else if (foundAppliance instanceof Thermostat) {
                    Thermostat thermostat = (Thermostat) foundAppliance;
                    System.out.println("Current temperature: " + thermostat.getTemperature());
                    System.out.println("Enter new temperature:");
                    int newTemperature = scanner.nextInt();
                    scanner.nextLine(); // buffer temizleme
                    thermostat.setTemperature(newTemperature);
                } else if (foundAppliance instanceof SecuritySystem) {
                    SecuritySystem securitySystem = (SecuritySystem) foundAppliance;
                    System.out.println("Current alarm number: " + securitySystem.getAlarmNumber());
                    System.out.println("Current camera number: " + securitySystem.getCameraNumber());
                    System.out.println("Please set a password for this appliance: ");
                    String pwd = scanner.nextLine();
                    scanner.nextLine(); // buffer temizleme
                    securitySystem.setPassword(pwd);
                    System.out.println("Enter new alarm number:");
                    int newAlarmNumber = scanner.nextInt(); 
                    scanner.nextLine(); // buffer temizleme
                    securitySystem.setAlarmNumber(newAlarmNumber);
                    System.out.println("Enter new camera number:");
                    int newCameraNumber = scanner.nextInt();
                    scanner.nextLine(); // buffer temizleme
                    securitySystem.setCameraNumber(newCameraNumber); 
                }
            } else {
                System.out.println("No such appliance found.");
            }

            System.out.println("Do you want to make another change? (yes/no)");
            String q = scanner.nextLine();
            if (q.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        scanner.close();
    }
}