package com.cvita.services.impl;

import com.cvita.models.HardSkill;
import com.cvita.repositories.HardSkillRepository;
import com.cvita.services.HardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public void saveSkill(HardSkill hardSkill) {
        if (!hardSkillRepository.existsByName(hardSkill.getName().trim())) {
            hardSkill.setName(hardSkill.getName().trim());
            hardSkillRepository.save(hardSkill);
        }
    }

    @Override
    public void removeSkillById(String id) {
        hardSkillRepository.deleteById(id);
    }

    @Override
    public void addAllByNames(Set<String> names) {
        for (String name : names) {
            saveSkill(new HardSkill(name));
        }
    }

    @Override
    public List<HardSkill> getAllByNameMatches(String search) {
        return hardSkillRepository.findHardSkillsByNameContaining(search.toUpperCase());
    }
}
