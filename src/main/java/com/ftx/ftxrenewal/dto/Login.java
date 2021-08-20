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
public class Login {
   private Long login_idx;
   private String login_id;
   private String login_pswd;
   private String login_name;
   private LocalDateTime reg_date = LocalDateTime.now();
   private String reg_ip;
}
