package com.example.springsecurity.repository;

import com.example.springsecurity.model.entity.CoachEntity;
import com.example.springsecurity.model.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, UUID> {

    Optional<CoachEntity> findByPeopleId(UUID id);
}
