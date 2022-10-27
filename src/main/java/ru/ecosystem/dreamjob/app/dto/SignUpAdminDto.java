package ru.ecosystem.dreamjob.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpAdminDto {

    private String username;

    private String password;

    private String secretHash;

    private String secretNumber;
}
