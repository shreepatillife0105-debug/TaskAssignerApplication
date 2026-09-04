package com.company.TaskAssignerApplication.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.TaskAssignerApplication.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByAssignedToId(Long internId);
	
	Optional<Task> findByTitleAndAssignedToId(String title, Long internId);
	
    @Query("SELECT t FROM Task t WHERE DATE(t.assignedAt) = :date")
    List<Task> findByAssignedDate(@Param("date") LocalDate date);

    @Query("SELECT t FROM Task t WHERE DATE(t.assignedAt) BETWEEN :startDate AND :endDate")
    List<Task> findByAssignedDateBetween(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);
	
}
