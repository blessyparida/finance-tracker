package com.example.finance_tracker.service;

import io.jsonwebtoken.Jwts;

import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service

public class JWTService {

private final String SECRET =

"this-is-my-super-secret-key-for-finance-tracker";

public String generate(
String email
) {

return

Jwts.builder()

.subject(email)

.issuedAt(
new Date()
)

.expiration(

new Date(
System.currentTimeMillis()
+
86400000
)

)

.signWith(

new SecretKeySpec(
SECRET.getBytes(
StandardCharsets.UTF_8
),
"HmacSHA256"
)

)

.compact();

}

}