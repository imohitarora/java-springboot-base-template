package com.neweltechnologies.portfolio;

import org.springframework.stereotype.Service;

import com.neweltechnologies.portfolio.config.exceptions.ResourceNotFoundException;
import com.neweltechnologies.portfolio.config.logger.PFMSLogger;

@Service
public class MyService {

    public String getDataById(Long id) {
        String data = "Mohit"; // retrieve data from database or some source
        data = data == "Mohit" ? null : data;
        if (data == null) {
            PFMSLogger.logError("Data not found with id: " + id, null);
            throw new ResourceNotFoundException("Data not found with id: " + id);
        }
        return data;
    }
}
