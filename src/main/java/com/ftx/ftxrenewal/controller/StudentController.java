package com.ftx.ftxrenewal.controller;

import com.ftx.ftxrenewal.dto.Student;
import com.ftx.ftxrenewal.entity.User;
import com.ftx.ftxrenewal.repository.UserRepository;
import com.ftx.ftxrenewal.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final UserRepository userRepository;

    /**
     * 회원가입 페이지
     */
    @GetMapping("/register")
    @PreAuthorize("permitAll()")
    public void register() {}

    /**
     * 회원가입 처리 페이지
     */
    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public String register_proc(@ModelAttribute("student") Student student,
                              HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        /* 클라이언트(접속자) 아이피 추가 */
        request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null) ip = request.getRemoteAddr();

        student.setReg_ip(ip);

        studentService.addStudentInfo(student);

        /* 메세지 박스 (alert) 출력을 위한 설정 */
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        out.println("<script>alert('회원가입이 완료되었습니다.');</script>");
        out.flush();

        /* 회원가입 완료 후 로그인 페이지로 이동 */
        return "redirect:/login";
    }

    /**
     * 아이디 중복 검사 체크
     */
    @GetMapping("/existStudent/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<String> existStudent(@PathVariable("id") String id) {

        Optional<User> result = userRepository.findById(id);

        JSONObject json = new JSONObject();

        if (result.isPresent()) {
            /* 아이디가 이미 존재하는 경우 */
            json.put("exists", true);
        } else {
            /* 아이디가 존재하지 않는 경우 */
            json.put("exists", false);
        }

        json.put("status", "200");

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
