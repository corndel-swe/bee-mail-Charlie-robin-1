package com.demo.devices;

public class SmartLight extends Device {

    private boolean isOn = false;

    public SmartLight(String name, String location) {
        super(name, location);
        log("Initialised and off.");
    }

    @Override
    public void action() {
        if (!isOn) {
            turnOn();
        } else {
            turnOff();
        }
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            log("State changed: **TURNED ON**");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            log("State changed: **TURNED OFF**");
        }
    }
}
