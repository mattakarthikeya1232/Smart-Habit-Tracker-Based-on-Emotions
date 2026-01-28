package com.example.taskapp.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {

    private Map<String, String> otpStorage = new ConcurrentHashMap<>();

    public String sendOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        otpStorage.put(email, otp);
        System.out.println("OTP for " + email + " is: " + otp); // (in real project send via mail)
        return "OTP sent successfully to " + email;
    }

    public boolean verifyOtp(String email, String otp) {
        String stored = otpStorage.get(email);
        return stored != null && stored.equals(otp);
    }
}
