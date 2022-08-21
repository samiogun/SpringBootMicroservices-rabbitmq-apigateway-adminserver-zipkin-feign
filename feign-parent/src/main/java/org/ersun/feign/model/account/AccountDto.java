package org.ersun.feign.model.account;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthDate;


}


