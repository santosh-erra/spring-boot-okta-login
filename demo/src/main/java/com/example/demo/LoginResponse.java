package com.example.demo;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expAt;
    private Collection<String> authList;




}
