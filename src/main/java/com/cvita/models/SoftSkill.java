package com.cvita.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document(collection = "soft_skills")
public class SoftSkill implements Serializable {
    @Id
    private String id;
    private String name;

    public SoftSkill() {
    }
}


