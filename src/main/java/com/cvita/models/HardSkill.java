package com.cvita.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document(collection = "hard_skills")
public class HardSkill implements Serializable {

    @Id
    private String id;
    private String name;

    public HardSkill() {
    }
    public HardSkill(String name) {
        this.name = name;
    }
}


