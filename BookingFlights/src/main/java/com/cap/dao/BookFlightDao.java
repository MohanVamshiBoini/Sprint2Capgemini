package com.cap.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.dto.BookingDetails;
import com.cap.dto.Flight;
@Repository
public interface BookFlightDao extends JpaRepository<BookingDetails, Integer>  {
	

}
