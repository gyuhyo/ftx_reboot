package com.ftx.ftxrenewal.service;

import com.ftx.ftxrenewal.dto.Login;
import com.ftx.ftxrenewal.dto.Student;
import com.ftx.ftxrenewal.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {
    @Autowired
    private final StudentMapper studentMapper;

    public long addLoginInfo(Login login) {
        return studentMapper.register_login_info(login);
    }

    @Transactional
    public void addStudentInfo(Student student) {
        Login login = new Login();
        login.setLogin_id(student.getStudent_id());
        login.setLogin_name(student.getStudent_name());
        login.setLogin_pswd(student.getStudent_pswd());

        long result = addLoginInfo(login);
        log.info(result);
        student.setStudent_idx(result);
        studentMapper.register_student_info(student);
    }

}
