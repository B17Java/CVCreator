package com.cvita.repositories;

import com.cvita.models.HardSkill;
import com.cvita.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface HardSkillRepository extends MongoRepository<HardSkill, String> {
    boolean existsByName(String name);

    List<HardSkill> findHardSkillsByNameContaining(String name);


}