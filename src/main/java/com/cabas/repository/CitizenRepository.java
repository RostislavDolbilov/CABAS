package com.cabas.repository;

import com.cabas.entity.Area;
import com.cabas.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    @Query(value = "from Citizen c where c.city.area = :area")
    List<Citizen> findCitizensByAreaCode(@Param("area") Area area);
}
