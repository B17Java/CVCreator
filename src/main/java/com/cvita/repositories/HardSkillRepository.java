package com.cvita.repositories;

import com.cvita.models.HardSkill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRepository extends MongoRepository<HardSkill,String> {
    Boolean existsByName(String name);
}