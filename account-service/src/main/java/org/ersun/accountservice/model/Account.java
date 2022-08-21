package org.ersun.accountservice.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table("accounts")
public class Account {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column("uname")
    private String username;

    @Setter
    @Column("first_name")
    private String firstname;

    @Setter
    @Column("last_name")
    private String lastname;

    @Setter
    @Column("email")
    private String email;

    @Setter
    @Column("birth_date")
    private Date birthDate;

    @Setter
    @Column("password")
    private String password;

    @Column("created_at")
    private Date createdAt;

    @Column("is_active")
    private Boolean isActive;

    public Account(String id) {
        this.id = id;
    }

}
