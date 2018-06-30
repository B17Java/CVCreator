package com.cvita.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
@AllArgsConstructor
@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    @DBRef
    private Set<Role> roles;

    //    @DBRef
    private  AboutUser aboutUser;

    private Map<LocalDateTime,List<String>> hrSearchResult;

    public User(){}

}
