package com.ftx.ftxrenewal.controller;

import com.ftx.ftxrenewal.dto.Student;
import com.ftx.ftxrenewal.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
@Log4j2
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping("/register")
    @PreAuthorize("permitAll()")
    public void register() {}

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public void register_proc(@ModelAttribute("student") Student student) {
        log.info(student);
        studentService.addStudentInfo(student);
    }
}
