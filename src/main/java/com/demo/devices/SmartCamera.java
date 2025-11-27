package com.demo.devices;

public class SmartCamera extends Device {

    private boolean isRecording = false;

    public SmartCamera(String name, String location) {
        super(name, location);
        log("Initialised and ready.");
    }

    @Override
    public void action() {
        if (!isRecording) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    public void detectMotion() {
        log("MOTION DETECTED. Notifying mediator...");
        if (mediator != null) {
            mediator.detect(this);
        }
    }

    private void startRecording() {
        if (!isRecording) {
            isRecording = true;
            log("**STARTED RECORDING**");
        }
    }

    private void stopRecording() {
        if (isRecording) {
            isRecording = false;
            log("**STOPPED RECORDING**");
        }
    }
}
