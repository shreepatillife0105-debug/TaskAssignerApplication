package com.company.TaskAssignerApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.TaskAssignerApplication.model.Intern;
import com.company.TaskAssignerApplication.repository.InternRepository;

@RestController
@RequestMapping("/api/interns")
@CrossOrigin
public class InternController {
	
	@Autowired
    private InternRepository internRepository;

    @GetMapping
    public List<Intern> getAllInterns() {
        return internRepository.findAll();
    }

}
