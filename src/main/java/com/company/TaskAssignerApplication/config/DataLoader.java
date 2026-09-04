package com.company.TaskAssignerApplication.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.company.TaskAssignerApplication.model.Intern;
import com.company.TaskAssignerApplication.repository.InternRepository;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final InternRepository internRepository;

    public DataLoader(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    @Override
    public void run(String... args) {
        if (internRepository.count() == 0) {
            internRepository.save(new Intern("Riya Maragurdi", "riyamargudri08@gmail.com"));
            internRepository.save(new Intern("Uday Desai", "udaydesai524@gmail.com"));
            internRepository.save(new Intern("Siddhi kumbhar", "siddhikumbhar7753@gmail.com"));
            internRepository.save(new Intern("Rushikesh Pawar", "rushipawar416408@gmail.com"));
            internRepository.save(new Intern("Abhiraj Jadhav", "abhirajjadhav777@gmail.com"));
            internRepository.save(new Intern("Mangesh Lohar", "mangeshlohar03@gmail.com"));
            internRepository.save(new Intern("Rushikesh Mane\r\n"
            		+ "", "mrushikeshkrishnat@gmail.com"));
            internRepository.save(new Intern("Shubham Dubal ", "shubhamdubal.dubal@gmail.com"));
            internRepository.save(new Intern("Vinayraj Desai", "vinayrajdesai4@gmail.com"));
            internRepository.save(new Intern("Shrutika Sanjay Mane", "shrutikamane429@gmail.com"));
            internRepository.save(new Intern("Shweta Chandrakant Patil\r\n"
            		+ "", "shwetapatil88608@gmail.com"));
            internRepository.save(new Intern("demo","jayshivraysociety2026@gmail.com"));
            System.out.println("11 interns loaded successfully!");
        }
    }

}
