package com.cvita.services;

import com.cvita.models.HardSkill;

import java.util.List;

public interface HardSkillService {
	boolean saveSkill(HardSkill hardSkill);
	HardSkill getSkillById(String id);
	List<HardSkill> getAllSkills();
	void removeSkillById(String id);
}
