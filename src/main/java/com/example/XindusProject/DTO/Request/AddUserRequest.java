package com.example.XindusProject.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddUserRequest {

        String name;

        String emailId;

        String mobileNumber;

        String password;

        String roles;
}
