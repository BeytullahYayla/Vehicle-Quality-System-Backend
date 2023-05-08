package com.example.terminal.core.utils.results;

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
