package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.BookingRequest;
import com.app.dto.CabLocationUpdateRequest;
import com.app.pojo.Booking;
import com.app.pojo.Cab;
import com.app.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookcab")
    public Booking bookCab(@RequestBody BookingRequest request) {
        return bookingService.bookCab(request.getCabId(), request.getUserId());
    }
    
    // Endpoint to check available cabs by location
    @GetMapping("/available-cabs")
    public List<Cab> getAvailableCabs(@RequestParam String location) {
        return bookingService.getAvailableCabsByLocation(location);
    }
    
 // Cancel booking endpoint
    @DeleteMapping("/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    
 // Endpoint to get user booking history
    @GetMapping("/history/{userId}")
    public List<Booking> getUserBookingHistory(@PathVariable Long userId) {
        return bookingService.getUserBookingHistory(userId);
    }

    
 // Endpoint to update cab location
    @PutMapping("/update-location")
    public Cab updateCabLocation(@RequestBody CabLocationUpdateRequest request) {
        return bookingService.updateCabLocation(request);
    }

}

