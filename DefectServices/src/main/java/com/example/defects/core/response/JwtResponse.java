package com.example.defects.core.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {

    private String jwtToken;
}
