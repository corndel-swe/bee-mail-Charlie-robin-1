package com.demo.mediator;

import com.demo.devices.Device;

import java.util.List;

public interface DeviceMediator {
    void addDevice(Device device);

    void addDevice(List<Device> devices);

    void detect(Device device);
}
