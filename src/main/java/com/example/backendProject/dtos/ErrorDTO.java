package com.example.backendProject.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
    private String errorCode;
    private String errorMsg;
}
