package com.autenticacion.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // 👈 Este es importante para que Spring pueda deserializar JSON correctamente
public class LoginRequest {
    private String username;
    private String password;
}
