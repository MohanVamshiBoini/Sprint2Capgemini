package com.cap.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.cap.dto.BookingDetails;
import com.cap.dto.Flight;


public interface BookFlightService {
	public List<Flight> displayFlights();
	public  List<Flight> bookingFlights(String from_loc,String to_loc,Date date1);
	public void addBookingDetails(BookingDetails booking);
	public void updateBookingDetails(BookingDetails booking);
	public List<BookingDetails> displayBookingList();
	public Optional<BookingDetails> displayOneBookingList(Integer bookingId);
	public String updateSeats(Flight flight, BookingDetails book);
}
