package com.example.taskapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.taskapp.service.OtpService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/sendOtp")
    public String sendOtp(@RequestParam String email) {
        return otpService.sendOtp(email);
    }

    @PostMapping("/verifyOtp")
    public boolean verifyOtp(@RequestParam String email, @RequestParam String otp) {
        return otpService.verifyOtp(email, otp);
    }
}