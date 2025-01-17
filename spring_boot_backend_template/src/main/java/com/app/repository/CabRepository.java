package com.app.repository;



import com.app.pojo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @Query("SELECT c FROM Cab c WHERE c.id = :id")
//    Optional<Cab> findById(Long cabId);
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM Cab c WHERE c.id = :cabId")
    Optional<Cab> findById(@Param("cabId") Long cabId);
    
    
 // Find available cabs by location
    @Query("SELECT c FROM Cab c WHERE c.location = :location")
    List<Cab> findAvailableCabsByLocation(String location);
}

