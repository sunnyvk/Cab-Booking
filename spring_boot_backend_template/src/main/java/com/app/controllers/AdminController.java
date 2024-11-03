package com.app.controllers;

//import com.example.cabbooking.entity.Booking;
//import com.example.cabbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.pojo.Booking;
import com.app.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint to view active bookings
    @GetMapping("/active-bookings")
    public List<Booking> getActiveBookings() {
        return adminService.getActiveBookings();
    }
}

