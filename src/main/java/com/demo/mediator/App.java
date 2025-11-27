package com.demo.mediator;

import com.demo.devices.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App implements DeviceMediator {
    private final List<Device> devices;
    private static App instance;
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private App() {
        this.devices = new ArrayList<>();
        LOGGER.log(Level.INFO, "Smart Home App (Mediator) initialised.");
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        } else {
            LOGGER.log(Level.WARNING, "Attempted to create a second App instance. Returning existing one.");
        }
        return instance;
    }

    @Override
    public void addDevice(Device device) {
        devices.add(device);
        device.setMediator(this);
        LOGGER.log(Level.INFO, "Added device: {0}", device.toString());
    }

    @Override
    public void addDevice(List<Device> devices) {
        this.devices.addAll(devices);
        devices.forEach(device -> device.setMediator(this));
        LOGGER.log(Level.INFO, "Added {0} devices.", devices.size());
    }

    @Override
    public void detect(Device triggeringDevice) {
        devices.stream()
                .filter(d -> triggeringDevice.getLocation().equals(d.getLocation()))
                .forEach(device -> {
                    LOGGER.log(Level.INFO, "MEDIATOR: Instructing {0} to perform action().", device.toString());
                    device.action();
                });
    }

}