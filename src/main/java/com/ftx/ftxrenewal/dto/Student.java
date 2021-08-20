package com.ftx.ftxrenewal.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class Student {
    private Long student_idx;
    private String student_id;
    private String student_pswd;
    private String student_name;
    private String student_birth;
    private String student_gender;
    private String student_hp;
    private String student_phone;
    private String student_email;
    private String student_post;
    private String student_addr;
    private String student_addr1;
    private String student_sch;
    private String student_dept;
    private String student_no;
    private String student_grade;
    private String student_class;
    private LocalDateTime mod_date = LocalDateTime.now();
    private LocalDateTime reg_date = LocalDateTime.now();
    private String reg_ip;
}
