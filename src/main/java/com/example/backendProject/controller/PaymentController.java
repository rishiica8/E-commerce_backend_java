package com.example.backendProject.controller;

import com.example.backendProject.dtos.PaymentDTO;
import com.example.backendProject.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @PostMapping
  public String initiatePayment(@RequestBody PaymentDTO paymentDTO){
     return  paymentService.initiatePayment(paymentDTO.getEmail(), paymentDTO.getName(), paymentDTO.getPhoneNo(), paymentDTO.getOrderId(), paymentDTO.getAmount());
  }
}
