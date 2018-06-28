package com.cvita.controllers;

import com.cvita.models.HardSkill;
import com.cvita.services.HardSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardskill")
public class HardskillController {

    @Autowired
    HardSkillService hardSkillService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveSkill(@RequestBody HardSkill hardSkill){
        return hardSkillService.saveSkill(hardSkill);
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
}
