package com.cvita.controllers;

import com.cvita.models.HardSkill;
import com.cvita.services.HardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/hardskill")
public class HardSkillController {

    @Autowired
    HardSkillService hardSkillService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveSkill(@RequestBody HardSkill hardSkill){
         hardSkillService.saveSkill(hardSkill);
    }

    @PostMapping(value = "/saveAll", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveSkill(@RequestBody Set<String> names){
         hardSkillService.addAllByNames(names);
    }

    @GetMapping("/{id}")
    public HardSkill getSkillById(@PathVariable String id){
        return hardSkillService.getSkillById(id);
    }

    @GetMapping("/all")
    public List<HardSkill> saveSkill(){
        return hardSkillService.getAllSkills();
    }

    @DeleteMapping("/del/{id}")
    public void deleteById(@PathVariable String id){
        hardSkillService.removeSkillById(id);
    }

    @GetMapping("/search/{search}")
    public List<HardSkill> getAllByNameMatches(@PathVariable String search){
        return hardSkillService.getAllByNameMatches(search);
    }
}
