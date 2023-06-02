package com.example.defects.core.requests;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private String userName;
    private String password;
}
