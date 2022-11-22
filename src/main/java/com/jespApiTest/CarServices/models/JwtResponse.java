package com.jespApiTest.CarServices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String jwttoken;
}

