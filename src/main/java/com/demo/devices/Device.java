package com.demo.devices;

import com.demo.mediator.DeviceMediator;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Device {
    protected final String name;
    protected final String location;
    protected DeviceMediator mediator;
    private static final Logger LOGGER = Logger.getLogger(Device.class.getName());

    public Device(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setMediator(DeviceMediator mediator) {
        this.mediator = mediator;
    }

    protected void log(String message) {
        LOGGER.log(Level.INFO, "[{0}] {1}", new Object[]{this.toString(), message});
    }

    public abstract void action();

    @Override
    public String toString() {
        return String.format("%s (%s)", name, location);
    }
}
