package org.ps.distributed.data.controller;

import org.ps.distributed.data.hz.HazelcastData;
import org.ps.distributed.data.hz.HzAllowedMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
public class UploadController {


    @Autowired
    HazelcastData<String, String> hazelcastData;

    @PostMapping(value = "/upload/{map}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createRide(@PathVariable HzAllowedMaps map, @RequestBody Map<String, String> dataToFeed) {
        hazelcastData.distributeData(map, dataToFeed);
    }
}
