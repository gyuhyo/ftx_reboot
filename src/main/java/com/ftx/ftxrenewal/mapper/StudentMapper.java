package com.ftx.ftxrenewal.mapper;

import com.ftx.ftxrenewal.dto.Login;
import com.ftx.ftxrenewal.dto.Student;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface StudentMapper {

    public long register_login_info(Login login);
    public void register_student_info(Student student);

}
