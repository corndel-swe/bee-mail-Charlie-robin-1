package com.demo;

import com.demo.devices.Device;
import com.demo.devices.SmartCamera;
import com.demo.devices.SmartLight;
import com.demo.mediator.App;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "\n---  CREATE CLASSES  ---");

        App smartApp = App.getInstance();

        List<Device> officeDevices = List.of(
                new SmartCamera("Main Camera", "Office"),
                new SmartLight("Ceiling Light", "Office"),
                new SmartLight("Media Cabinet Light", "Office")
        );

        smartApp.addDevice(officeDevices);

        SmartCamera livingRoomCam = new SmartCamera("Main Camera", "Living Room");
        SmartLight livingRoomLight = new SmartLight("Ceiling Light", "Living Room");
        SmartLight kitchenLight = new SmartLight("Spot Light", "Kitchen");

        smartApp.addDevice(livingRoomCam);
        smartApp.addDevice(livingRoomLight);
        smartApp.addDevice(kitchenLight);

        LOGGER.log(Level.INFO, "\n---  SIMULATING LIVING ROOM MOTION  ---");
        livingRoomCam.detectMotion();

        LOGGER.log(Level.INFO, "\n---  TOGGLE LIVING ROOM DEVICES OFF ---");
        livingRoomCam.detectMotion();
    }
}
