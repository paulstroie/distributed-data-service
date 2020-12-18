package org.ps.distributed.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class HealthController {

    private HealthChecker healthChecker;
    private float maxHeapUsage;
    private long minDiskFreeSpace;

    @Value("${server.nodeId}")
    private String nodeId;

    @Autowired
    public HealthController(HealthChecker healthChecker,
                            @Value("${healthcheck.maxHeapUsage}") float maxHeapUsage,
                            @Value("${healthcheck.minDiskFreeSpace}") long minDiskFreeSpace) {
        this.maxHeapUsage = maxHeapUsage;
        this.minDiskFreeSpace = minDiskFreeSpace;
        this.healthChecker = healthChecker;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("healthy", healthChecker.isHealthy(maxHeapUsage, minDiskFreeSpace));
        metrics.put("nodeId", nodeId);

        return metrics;
    }
}

