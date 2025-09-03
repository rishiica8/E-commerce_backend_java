package com.example.backendProject.service;

import com.example.backendProject.paymentgateways.RazorpayPaymentGateway;
import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService implements IPaymentService{
    @Autowired
    private RazorpayPaymentGateway razorpayPaymentGateway;
    @Override
    public String initiatePayment(String email,String name,String phoneNo,String orderId,Long amount){
    return razorpayPaymentGateway.getPaymentLink(email,name,phoneNo,orderId,amount);
    }
}
