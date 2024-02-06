package com.neweltechnologies.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.neweltechnologies.portfolio.config.logger.PFMSLogger;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/data/{id}")
    public ResponseEntity<String> getData(@PathVariable Long id) {
        PFMSLogger.logInfo("Data retrieved successfully with id: " + id);
        String data = myService.getDataById(id);
        return ResponseEntity.ok(data);
    }

}
