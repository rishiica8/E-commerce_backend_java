package com.example.backendProject.advice;

import com.example.backendProject.dtos.ErrorDTO;
import com.example.backendProject.exception.CategoryNotFoundException;
import com.example.backendProject.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(){
      ErrorDTO errorDTO=new ErrorDTO();
      errorDTO.setErrorCode("400");
      errorDTO.setErrorMsg("Bad Request");
      return ResponseEntity.badRequest().body(errorDTO);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(){
        ErrorDTO errorDTO=new ErrorDTO();
        errorDTO.setErrorCode("404");
        errorDTO.setErrorMsg("Product Not Found");
        return ResponseEntity.badRequest().body(errorDTO);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleCategoryNotFoundException(){
        ErrorDTO errorDTO=new ErrorDTO();
        errorDTO.setErrorCode("404");
        errorDTO.setErrorMsg("Category Not Found");
        return ResponseEntity.badRequest().body(errorDTO);

    }
}
