package com.cap.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cap.dto.Flight;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {
	@Query("select f from Flight f where f.from_loc = ?1 and f.to_loc = ?2 and f.date1=?3")
	List<Flight> findByLocations(String from_loc,String to_loc,Date date1);

}