package com.cvita.services;

import com.cvita.models.HardSkill;

import java.util.List;
import java.util.Set;

public interface HardSkillService {
	void saveSkill(HardSkill hardSkill);
	HardSkill getSkillById(String id);
	List<HardSkill> getAllSkills();
	void removeSkillById(String id);
	void addAllByNames (Set<String> names);
    List<HardSkill> getAllByNameMatches(String search);
}
