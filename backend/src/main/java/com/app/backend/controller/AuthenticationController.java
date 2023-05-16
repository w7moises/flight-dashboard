package com.app.backend.controller;

import com.app.backend.dto.UserDto;
import com.app.backend.model.Role;
import com.app.backend.model.auth.AuthenticationRequest;
import com.app.backend.model.auth.AuthenticationResponse;
import com.app.backend.service.impl.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/auth")
public class AuthenticationController {

  private final AuthenticationServiceImpl service;

  public AuthenticationController(AuthenticationServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid UserDto request) {
    return ResponseEntity.ok(service.register(request, Role.ROLE_SUPERVISOR));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }

}
