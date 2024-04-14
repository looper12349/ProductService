package com.example.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;


public class ProductNotFoundException extends RuntimeException{

    private Long id;
    public ProductNotFoundException(Long id, String message){
        super(message);
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }


}
