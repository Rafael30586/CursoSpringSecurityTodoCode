package com.todocodeacademy.springSecurity.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequestDTO (@NotBlank String username, @NotBlank String password) {
}
