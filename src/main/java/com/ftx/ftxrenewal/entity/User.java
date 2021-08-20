package com.ftx.ftxrenewal.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Table(name = "login_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_idx")
    private Integer login_idx;

    @Column(name = "login_id")
    private String login_id;

    @Column(name = "login_pswd")
    private String login_pswd;

    @Column(name = "login_name")
    private String login_name;

    @Column(name = "reg_date")
    private LocalDateTime reg_date;

    @Column(name = "reg_ip")
    private String reg_ip;

    @Column(name = "lastlogin_date")
    private LocalDateTime lastlogin_date;

    @Column(name = "lastlogin_ip")
    private String lastlogin_ip;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserRole> roleSet = new HashSet<>();

    public void addUserRole(UserRole userRole) {
        roleSet.add(userRole);
    }
}
