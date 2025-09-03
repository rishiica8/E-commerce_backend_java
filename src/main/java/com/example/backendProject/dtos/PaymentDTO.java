package com.example.backendProject.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
String  email;
String name;
String phoneNo;
String orderId;
Long amount;
}
