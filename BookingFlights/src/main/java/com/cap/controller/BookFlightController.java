package com.cap.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.dto.BookingDetails;
import com.cap.dto.Flight;
import com.cap.service.BookFlightService;

@RestController
@RequestMapping("/Flights")
@CrossOrigin("http://localhost:4200")
public class BookFlightController {

	@Autowired
	BookFlightService flightService;

	@GetMapping("/flightlist")
	public List<Flight> displayFlights() {
		return flightService.displayFlights();
	}

	@GetMapping("/book/{from_loc}/{to_loc}/{date1}")
	public String bookFlight(@PathVariable String from_loc, @PathVariable String to_loc, @PathVariable Date date1) {
		List<Flight> flight1 = flightService.bookingFlights(from_loc, to_loc, date1);
		if (flight1 != null) {

			return "Available flights " + flight1;
		}
		return "no flights available";
	}

	@PostMapping(value = "/addBooking")
	public String addBookingDetails(@RequestBody() BookingDetails booking) {
		flightService.addBookingDetails(booking);
		return "Booking Details Stored";
	}

	@GetMapping("/bookinglist")
	public List<BookingDetails> displayList() {
		return flightService.displayBookingList();
	}

	@GetMapping("/get/{bookingId}")
	public BookingDetails displayOneList(@PathVariable Integer bookingId) {
		return flightService.displayOneBookingList(bookingId);
	}

	@PutMapping(value = "/update/{bookingId}")
	public String updateBookingDetails(@RequestBody() BookingDetails booking) {
		flightService.updateBookingDetails(booking);
		return "Booking Details updated with new Booking Id ";
	}

}
