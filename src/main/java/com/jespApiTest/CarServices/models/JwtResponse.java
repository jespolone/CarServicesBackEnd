package com.jespApiTest.CarServices.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String jwttoken;
    private User user;
}

