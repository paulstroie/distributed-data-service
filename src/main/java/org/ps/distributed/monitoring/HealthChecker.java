package org.ps.distributed.monitoring;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HealthChecker {

    public boolean isHealthy(float maxHeapUsage, long minDiskFreeSpace) {
        long maxHeap = Runtime.getRuntime().maxMemory();
        Long totalMemory = Runtime.getRuntime().totalMemory();
        Long freeMemory = Runtime.getRuntime().freeMemory();
        float heapUsage = (float)(totalMemory - freeMemory) / (float)maxHeap;
        long freeSpace = (new File(".")).getFreeSpace();
        return heapUsage < maxHeapUsage && minDiskFreeSpace < freeSpace;
    }

}
