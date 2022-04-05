package com.jaza.software.tms.repositories;

import com.jaza.software.tms.entities.LabelEntity;
import com.jaza.software.tms.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<LabelEntity,Long> {

}
