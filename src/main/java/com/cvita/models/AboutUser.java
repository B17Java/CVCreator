package com.cvita.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Document(collection = "about_user")
public class AboutUser {
    @Id
    private String id;
    private String name;
    private String surname;
    private String birthday;
    private String phone;
    private String objective;
    private String educations;
    private String workExperience;
    private String certifications;
    private String links;
    private List<HardSkill> hardSkills;
    private List<SoftSkill> softSkills;

    public AboutUser() {
        this.hardSkills = new ArrayList<>();
    }
}