package com.vishal.transcationmgmt.dto;

import com.vishal.transcationmgmt.entity.PassengerInfo;
import com.vishal.transcationmgmt.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passerngerInfo;
	
	private PaymentInfo paymentInfo;
}
