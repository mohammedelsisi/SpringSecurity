package org.model;

import lombok.Data;
import lombok.SneakyThrows;

import javax.validation.constraints.*;

@Data
public class User {
    private int id;
    @NotBlank
    @Size(min = 3,max = 48)
    private String userName;
    @NotBlank
    @Email(message = "Your email must be in format xxx@xx.com")
    private String email;
    @Pattern(regexp = "01\\d{9}",message = "Your phone must follow 01xxxxxxxxxx")
    private String phoneNumber;
    @Size(min = 6,max=48)
    private String password;
}
