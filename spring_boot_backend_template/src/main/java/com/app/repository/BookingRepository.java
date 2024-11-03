package com.app.repository;

import com.app.pojo.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	   // Find bookings by user ID
    List<Booking> findByUserId(Long userId);
    
 // Find all confirmed bookings
    @Query("SELECT b FROM Booking b WHERE b.bookingStatus = 'CONFIRMED'")
    List<Booking> findActiveBookings();

	
}
