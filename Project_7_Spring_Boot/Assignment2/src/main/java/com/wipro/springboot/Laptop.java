package com.wipro.springboot;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private final HardDisk hardDisk;
    private final Battery battery;

    public Laptop(HardDisk hardDisk, Battery battery) {
        this.hardDisk = hardDisk;
        this.battery = battery;
    }

    public String getName() { return "Wipro Laptop"; }
    public HardDisk getHardDisk() { return hardDisk; }
    public Battery getBattery() { return battery; }
}
