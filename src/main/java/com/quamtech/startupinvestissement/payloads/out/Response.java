package com.quamtech.startupinvestissement.payloads.out;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Response {
    private String message;
    private Object data;
    
}
