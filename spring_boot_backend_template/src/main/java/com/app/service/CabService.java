package com.app.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.NewCabRequest;
import com.app.pojo.Cab;
import com.app.repository.CabRepository;

@Service
public class CabService {

    @Autowired
    private CabRepository cabRepository;

    // Method to add a new cab
    public Cab addNewCab(NewCabRequest request) {
        Cab cab = new Cab();
        cab.setLicensePlate(request.getLicensePlate());
        cab.setModel(request.getModel());
        cab.setLocation(request.getLocation());
        cab.setStatus(request.getStatus());
        
        return cabRepository.save(cab);
    }
}

