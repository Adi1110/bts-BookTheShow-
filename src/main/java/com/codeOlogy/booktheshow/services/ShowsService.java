package com.codeOlogy.booktheshow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeOlogy.booktheshow.entity.Seat;
import com.codeOlogy.booktheshow.entity.Shows;
import com.codeOlogy.booktheshow.exceptionHandler.SeatNotFoundException;
import com.codeOlogy.booktheshow.exceptionHandler.ShowNotFoundException;
import com.codeOlogy.booktheshow.repository.ShowsRepository;

@Service
public class ShowsService {

    @Autowired
    private ShowsRepository showsRepository; // you have a repository for accessing show data

    public Shows getShowDetails(Long showId, List<String> listOfSeats)
            throws ShowNotFoundException, SeatNotFoundException {
        // Your logic to retrieve show details based on showId and list of seats
        Shows show = showsRepository.findById(showId).orElse(null); // Retrieve the show details from the repository
        if (show == null) {
            throw new ShowNotFoundException("Show not found for ID: " + showId); // Handle the case where show is not
                                                                                 // found
        }

        // For simplicity, let's assume each seat has a status (e.g., available, booked,
        // reserved)
        List<Seat> seats = show.getListOfSeats(); // Get the list of seats associated with the show
        List<Seat> selectedSeats = new ArrayList<>();
        for (String seatNumber : listOfSeats) {
            Seat seat = findSeat(seats, seatNumber); // Find the seat object corresponding to the seat number
            if (seat == null) {
                throw new SeatNotFoundException("Seat not found: " + seatNumber); // Handle the case where seat is not
                                                                                  // found
            }
            selectedSeats.add(seat);
            // Process the seat based on its status using the enum
            switch (seat.getSeatStatus()) {
                case AVAILABLE:
                    // Add your logic for available seats
                    break;
                case BOOKED:
                    // Add your logic for booked seats
                    break;
                case HOLD:
                    // Add your logic for held seats
                    break;
                default:
                    // Handle other cases if needed
                    break;
            }
        }

        Shows showDetails = new Shows();
        showDetails.setId(show.getId());
        showDetails.setListOfSeats(selectedSeats); // Set the list of Seat objects
        // Add other show details as needed
        return showDetails;
    }

    // Helper method to find a seat by seat number
    private Seat findSeat(List<Seat> seats, String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null; // Return null if seat is not found
    }
}
