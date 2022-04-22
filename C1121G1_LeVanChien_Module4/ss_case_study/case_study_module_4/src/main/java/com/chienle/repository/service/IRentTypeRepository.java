package com.chienle.repository.service;

import com.chienle.model.service_entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
