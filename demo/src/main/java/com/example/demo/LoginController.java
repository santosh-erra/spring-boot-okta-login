package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizationSuccessHandler;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/test")
    public ResponseEntity<LoginResponse> checkAuthentication(@AuthenticationPrincipal OidcUser  oidcUser,
                                                             Model model,
                                                             @RegisteredOAuth2AuthorizedClient("okta")OAuth2AuthorizedClient client)
    {
        System.out.println("LoginController.checkAuthentication");
        System.out.println("oidcUser = " + oidcUser + ", model = " + model + ", client = " + client);
        LoginResponse loginResponse= LoginResponse.builder()
                .userId(oidcUser.getEmail())
                .accessToken(String.valueOf(client.getAccessToken()))
                .refreshToken(String.valueOf(client.getRefreshToken()))
                .expAt(client.getAccessToken().getExpiresAt().getEpochSecond())
                .authList(oidcUser.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .build();
        return  new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
