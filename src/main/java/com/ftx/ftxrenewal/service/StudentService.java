package com.ftx.ftxrenewal.service;

import com.ftx.ftxrenewal.dto.Login;
import com.ftx.ftxrenewal.dto.Student;
import com.ftx.ftxrenewal.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Log4j2
public class StudentService {
    @Autowired
    private final StudentMapper studentMapper;

    public void addLoginInfo(Login login) {
        studentMapper.register_login_info(login);
    }

    public void addUserRole(HashMap<String, Object> userRole) {
        studentMapper.register_user_role_set(userRole);
    }

    @Transactional
    public void addStudentInfo(Student student) {
        /* 사용자가 입력한 정보에서 Login Info 테이블에 맞게 데이터를 추출하여 객체 생성 */
        Login login = new Login();
        login.setLogin_id(student.getStudent_id());
        login.setLogin_name(student.getStudent_name());
        login.setLogin_pswd(student.getStudent_pswd());
        login.setReg_ip(student.getReg_ip());

        /* Login_Info 테이블에 데이터를 먼저 삽입 (FK) */
        addLoginInfo(login);

        /* 학생 권한 설정 */
        HashMap<String, Object> userRole = new HashMap<>();
        userRole.put("user_login_idx", login.getLogin_idx());
        userRole.put("role_set", 0);

        /* 권한 등록 */
        addUserRole(userRole);

        /* 키 값을 가져와 student idx에 삽입 */
        student.setStudent_idx(login.getLogin_idx());

        /* student_info 데이터 등록 */
        studentMapper.register_student_info(student);
    }

}
