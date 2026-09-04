package com.company.TaskAssignerApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "interns")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Intern {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    
    public Intern(String name, String email) {
        this.name = name;
        this.email = email;
    }
	
}
