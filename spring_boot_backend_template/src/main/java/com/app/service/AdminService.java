package com.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Booking;
import com.app.repository.BookingRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private BookingRepository bookingRepository;

    // Get all active bookings
    public List<Booking> getActiveBookings() {
        return bookingRepository.findActiveBookings();
    }
}

