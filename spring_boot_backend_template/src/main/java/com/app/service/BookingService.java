package com.app.service;



import com.app.customException.CabNotAvailableException;
import com.app.dto.CabLocationUpdateRequest;
import com.app.pojo.*;
import com.app.repository.BookingRepository;
import com.app.repository.CabRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CabRepository cabRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookCab(Long cabId, Long userId) {    	
    	   // Fetch cab and check availability
        Cab cab = cabRepository.findById(cabId)
                .orElseThrow(() -> new RuntimeException("Cab not found"));

        if (!cab.getStatus().equals("AVAILABLE")) {
            throw new CabNotAvailableException("Cab is already booked");
        }

        // Reserve the cab by setting its status to BOOKED
        cab.setStatus("BOOKED");
        cabRepository.save(cab);

        // Create a new booking
        Booking booking = new Booking();
        booking.setCabId(cabId);
        booking.setUserId(userId);
        booking.setBookingStatus("CONFIRMED");
        booking.setStartTime(LocalDateTime.now());

        return bookingRepository.save(booking);
    }
    
    // Check available cabs by location
    public List<Cab> getAvailableCabsByLocation(String location) {
        return cabRepository.findAvailableCabsByLocation(location);
    }
    
    
    // Cancel booking method
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new CabNotAvailableException("Booking not found."));

        if (!"CONFIRMED".equals(booking.getBookingStatus())) {
            throw new IllegalStateException("Only confirmed bookings can be cancelled.");
        }

        booking.setBookingStatus("CANCELLED");
        return bookingRepository.save(booking);
    }
    
    
 // Get user booking history
    public List<Booking> getUserBookingHistory(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    
    // Update cab location
    public Cab updateCabLocation(CabLocationUpdateRequest request) {
        Cab cab = cabRepository.findById(request.getCabId())
                .orElseThrow(() -> new RuntimeException("Cab not found."));
        
        cab.setLocation(request.getNewLocation());
        return cabRepository.save(cab);
    }
}
