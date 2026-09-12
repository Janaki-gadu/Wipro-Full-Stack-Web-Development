package com.wipro.springboot;

import org.springframework.stereotype.Component;

@Component
public class HardDisk {
    public String getCapacity() {
        return "1 TB";
    }
}
