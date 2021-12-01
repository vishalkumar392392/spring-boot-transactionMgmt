package com.vishal.transcationmgmt.service;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vishal.transcationmgmt.dto.FlightBookingAcknowledgement;
import com.vishal.transcationmgmt.dto.FlightBookingRequest;
import com.vishal.transcationmgmt.entity.PassengerInfo;
import com.vishal.transcationmgmt.entity.PaymentInfo;
import com.vishal.transcationmgmt.repository.PassengerInfoRepository;
import com.vishal.transcationmgmt.repository.PaymentInformationRepository;
import com.vishal.transcationmgmt.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepo;

	@Autowired
	private PaymentInformationRepository paymentInfoRepo;

	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request)
			throws IllegalAccessException, InvocationTargetException {

		PassengerInfo passengerInfo = passengerInfoRepo.save(request.getPasserngerInfo());

		PaymentUtils.validateCreditLimit(request.getPaymentInfo().getAccountNo(), passengerInfo.getFare());

		PaymentInfo paymentinfo = new PaymentInfo();
		BeanUtils.copyProperties(paymentinfo, request.getPaymentInfo());
		paymentinfo.setPassengerId(passengerInfo.getPId());
		paymentinfo.setAmount(passengerInfo.getFare());
		paymentInfoRepo.save(paymentinfo);

		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString(),
				passengerInfo);
	}
}
