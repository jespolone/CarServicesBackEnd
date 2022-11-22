package com.jespApiTest.CarServices.util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequestModel {
    @ToString.Exclude
    private String oldPassword;
    @ToString.Exclude
    private String newPassword;
}
