package org.ps.distributed.data.controller;

import org.ps.distributed.data.hz.HazelcastData;
import org.ps.distributed.data.hz.HzAllowedMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1")
public class DownloadController {

    @Autowired
    HazelcastData<String, String> hazelcastData;

    @GetMapping(value = "/download/{map}/{key}")
    public String createRide(@PathVariable HzAllowedMaps map, @PathVariable String key){
        return hazelcastData.getData(map, key);
    }
}
