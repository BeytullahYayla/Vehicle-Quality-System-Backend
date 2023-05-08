package com.example.user.core.responses;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {

    private String jwtToken;
}
