package com.jespApiTest.CarServices.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivateUserRequestModel {

    private String username;

    private int activationCode;
}
