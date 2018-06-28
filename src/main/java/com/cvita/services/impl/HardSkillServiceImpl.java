package com.cvita.services.impl;

import com.cvita.models.HardSkill;
import com.cvita.repositories.HardSkillRepository;
import com.cvita.services.HardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardSkillServiceImpl implements HardSkillService {

    @Autowired
    private HardSkillRepository hardSkillRepository;

    @Override
    public List<HardSkill> getAllSkills() {
        return hardSkillRepository.findAll();
    }

    @Override
    public HardSkill getSkillById(String id) {
        return hardSkillRepository.findById(id).orElse(null);
    }

    @Override
    public boolean saveSkill(HardSkill hardSkill) {
        if (!hardSkillRepository.existsByName(hardSkill.getName())) {
            hardSkillRepository.save(hardSkill);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeSkillById(String id) {
        hardSkillRepository.deleteById(id);
    }
}
