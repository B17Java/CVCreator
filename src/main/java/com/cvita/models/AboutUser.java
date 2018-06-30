package com.cvita.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Document(collection = "about_user")
public class AboutUser implements Serializable {

    private String name;
    private String phone;
    private String links;
    private String surname;
    private String birthday;
    private String objective;
    private String educations;
    private String workExperience;
    private String certifications;
    private String softSkills;

    @DBRef
    private Set<HardSkill> hardSkills;

    public AboutUser() {
        this.hardSkills = new HashSet<>();
    }
}