package com.ElectronicsService.Electronic.Service.service;

import com.ElectronicsService.Electronic.Service.model.*;
import com.ElectronicsService.Electronic.Service.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repo;

    @Autowired
    private TechnicianRepository technicianRepo;

    public Booking createBooking(Booking booking) {
        booking.setStatus("Pending");
        return repo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repo.findAll();
    }

    public void assignTechnician(Long bookingId, Long techId) {
        Booking booking = repo.findById(bookingId).orElse(null);
        Technician tech = technicianRepo.findById(techId).orElse(null);

        if (booking != null && tech != null) {
            booking.setTechnician(tech);
            booking.setStatus("Assigned");
            repo.save(booking);
        }
    }

    public List<Booking> getAssignedBookings() {
        return repo.findByStatus("Assigned");
    }

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }



    public List<Booking> getAllBookingsByCustomer(User user) {
        return repo.findByCustomer(user);
    }


    public void updateStatus(Long id, String status) {
        Booking b = repo.findById(id).orElse(null);
        if (b != null) {
            b.setStatus(status);
            repo.save(b);
        }
    }
}
