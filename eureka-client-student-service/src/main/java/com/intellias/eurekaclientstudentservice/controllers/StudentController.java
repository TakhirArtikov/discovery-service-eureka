package com.intellias.eurekaclientstudentservice.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intellias.eurekaclientstudentservice.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    Environment environment;

    private static Map<String, List<Student>> schoolDB = new HashMap<>();

    static {
        schoolDB = new HashMap<>();

        List<Student> list = new ArrayList<>();
        Student std = new Student("John", "Class IV");
        list.add(std);
        std = new Student("Liza", "Class V");
        list.add(std);

        schoolDB.put("school1", list);

        list = new ArrayList<>();
        std = new Student("Anna", "Class III");
        list.add(std);
        std = new Student("Fred", "Class VI");
        list.add(std);

        schoolDB.put("school2", list);

    }

    @RequestMapping(value = "/student-details-for-school/{schoolName}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolName) {
        System.out.println("Getting Student details for " + schoolName);

        List<Student> studentList = schoolDB.get(schoolName);
        if (studentList == null) {
            studentList = new ArrayList<>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }



    @GetMapping("/port")
    public String backend(){
        System.out.println("StudentController::port...");

        String serverPort = environment.getProperty("local.server.port");

        System.out.println("Port : " + serverPort);

        return "Hello from Ribbon server!!! " + " Host : localhost " + " :: Port : " + serverPort;
    }
}