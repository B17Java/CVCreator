package com.cvita.repositories;

import com.cvita.models.AboutUser;
import com.cvita.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutUserRepository extends MongoRepository<AboutUser,String> {

}