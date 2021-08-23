package com.ftx.ftxrenewal.mapper;

import com.ftx.ftxrenewal.dto.Login;
import com.ftx.ftxrenewal.dto.Student;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Mapper
public interface StudentMapper {

    void register_login_info(Login login);
    void register_student_info(Student student);
    void register_user_role_set(HashMap<String, Object> userRole);

}
