// Main.java
package smartgrid;
import smartgrid.devices.Device;
import smartgrid.devices.SmartMeter;
import smartgrid.devices.SmartAppliance;

public class Main {
    public static void main(String[] args) {
        Device smartMeter = new SmartMeter();
        Device smartAppliance = new SmartAppliance();

        operateDevice(smartMeter);
        operateDevice(smartAppliance);
    }

    static void operateDevice(Device device) {
        device.turnOn();
        System.out.println("Is device on? " + device.isOn());
        device.turnOff();
        System.out.println("Is device on? " + device.isOn());
        System.out.println();
    }
}
