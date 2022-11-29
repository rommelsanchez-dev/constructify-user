package com.dice.constructify.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String status;
    private LocalDateTime create_dttm;
    private LocalDateTime update_dttm;
}
