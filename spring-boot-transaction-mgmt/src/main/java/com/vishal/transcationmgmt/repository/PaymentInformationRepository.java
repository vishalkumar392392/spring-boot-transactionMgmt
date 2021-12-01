package com.vishal.transcationmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishal.transcationmgmt.entity.PaymentInfo;

@Repository
public interface PaymentInformationRepository extends JpaRepository<PaymentInfo, String> {

}
