package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.TaskUserMapping;

@Repository
public interface TaskUserMappingRepository extends JpaRepository<TaskUserMapping, Long> {

	List<TaskUserMapping> findAllByAssignedTo_Id(Long userId);

	Optional<TaskUserMapping> findByTask_Id(Long taskId);

}
