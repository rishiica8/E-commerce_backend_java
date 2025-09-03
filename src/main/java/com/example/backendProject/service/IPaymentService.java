package com.example.backendProject.service;

public interface IPaymentService {
    String initiatePayment(String email,String name,String phoneNo,String orderId,Long amount);
}
