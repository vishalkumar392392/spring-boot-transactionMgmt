package com.vishal.transcationmgmt.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vishal.transcationmgmt.dto.FlightBookingAcknowledgement;
import com.vishal.transcationmgmt.dto.FlightBookingRequest;
import com.vishal.transcationmgmt.service.FlightBookingService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private FlightBookingService service;

	@PostMapping("/bookFlight")
	public FlightBookingAcknowledgement bookFlight(@RequestBody FlightBookingRequest request)
			throws IllegalAccessException, InvocationTargetException {
		return service.bookFlightTicket(request);
	}
}
