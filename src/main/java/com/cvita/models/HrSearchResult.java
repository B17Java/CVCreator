package com.cvita.models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "hr_search_result")
public class HrSearchResult {

    @DBRef
    private Map<User, List<String>> usersAndPercentMatching;
    private List<String> searchSkills;
    private LocalDateTime searchDateTime;

    public HrSearchResult() {
        this.searchSkills = new ArrayList<>();
        this.searchDateTime = LocalDateTime.now();
        this.usersAndPercentMatching = new HashMap<>();
    }
}
