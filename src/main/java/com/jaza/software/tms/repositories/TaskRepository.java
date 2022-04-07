package com.jaza.software.tms.repositories;

import com.jaza.software.tms.entities.TaskEntity;
import com.jaza.software.tms.models.Priority;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
  List<TaskEntity> findByPriority(Priority priority);
  List<TaskEntity> findByLabelsAndDeadLine(String label,Integer deadLine);
  List<TaskEntity> findByDeadLineBetween(Integer deadLineStart,Integer deadLineEnd);
}
