package com.app.controllers;



//import com.example.cabbooking.dto.NewCabRequest;
//import com.example.cabbooking.entity.Cab;
//import com.example.cabbooking.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.NewCabRequest;
import com.app.pojo.Cab;
import com.app.service.CabService;

@RestController
@RequestMapping("/api/cabs")
public class CabController {

    @Autowired
    private CabService cabService;

    // Endpoint to add a new cab
    @PostMapping("/add")
    public Cab addNewCab(@RequestBody NewCabRequest request) {
        return cabService.addNewCab(request);
    }
}

