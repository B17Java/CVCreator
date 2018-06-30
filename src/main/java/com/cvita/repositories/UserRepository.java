package com.cvita.repositories;

import com.cvita.models.HardSkill;
import com.cvita.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}