package com.example.productservice.exceptionHandlers;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something Went Wrong!");
        exceptionDto.setResolution("Arithmetic Exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException()
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something Went Wrong");
        exceptionDto.setResolution("Array Index Out of Bound Exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        Long id = productNotFoundException.getId();
        exceptionDto.setMessage("Invalid Product Id: "+ id +" Passed!");
        exceptionDto.setResolution("Product Not found Exception");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> handleGeneralException()
//    {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage("Something went wrong");
//        exceptionDto.setResolution("Exception");
//        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
//        return response;
//    }
}
