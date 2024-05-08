package com.example.cosmetics.controller;

import com.example.cosmetics.config.service.JwtResponse;
import com.example.cosmetics.config.service.JwtService;
import com.example.cosmetics.dto.ProductDto;
import com.example.cosmetics.model.CosmeticsSize;
import com.example.cosmetics.service.ICartService;
import com.example.cosmetics.service.ICosmeticSizeService;
import com.example.cosmetics.service.impl.AccountService;
import com.example.cosmetics.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private ICosmeticSizeService cosmeticSizeService;
    @Autowired
    private ICartService cartService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentUser = accountService.findByUsername(account.getUsername());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo(@RequestHeader("Authorization")String token) {
        String newToken = token.substring(7);
        String userName = jwtService.getUsernameFromJwtToken(newToken);
        Account user = accountService.findByUsername(userName);
        user.setPassword("");
        return ResponseEntity.ok(user);
    }
    @GetMapping("/getInfoCart")
    public ResponseEntity<?> getInfoAndCart(@RequestHeader("Authorization")String token) {
        String newToken = token.substring(7);
        String userName = jwtService.getUsernameFromJwtToken(newToken);
        Account user = accountService.findByUsername(userName);
//        List<CosmeticsSize> courses = cosmeticSizeService.findAllCartByIdAccount(user.getId());
//        Integer size = courses.size();
//        String result = userName + "," + size;
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutSuccessful(){
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("ok dang xuat");
    }
}
