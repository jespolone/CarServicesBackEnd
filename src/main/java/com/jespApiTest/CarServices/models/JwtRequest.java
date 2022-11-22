package com.jespApiTest.CarServices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {

    private String username;

    @ToString.Exclude
    private String password;
}

