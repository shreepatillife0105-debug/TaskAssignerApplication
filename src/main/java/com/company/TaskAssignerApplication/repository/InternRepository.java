package com.company.TaskAssignerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.TaskAssignerApplication.model.Intern;

public interface InternRepository extends JpaRepository<Intern, Long> {

}
