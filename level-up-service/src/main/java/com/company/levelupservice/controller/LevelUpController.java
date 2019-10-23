package com.company.levelupservice.controller;

import com.company.levelupservice.model.LevelViewModel;
import com.company.levelupservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;
import java.util.List;

@RestController
@RequestMapping(value = "/level-up")
public class LevelUpController {

    @Autowired
    private ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LevelViewModel createLevelUp(@RequestBody LevelViewModel levelViewModel){return null;}

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<LevelViewModel> getAllLevelUp(){return null;}

    @GetMapping(value = "/{level_up_id}")
    @ResponseStatus(HttpStatus.FOUND)
    public LevelViewModel getLevelUp(@PathVariable int level_up_id){return null;}

    @PutMapping(value = "/{level_up_id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLevelUp(@RequestBody LevelViewModel levelViewModel){}

    @DeleteMapping(value = "/{level_up_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLevelUp(@PathVariable int level_up_id){}
}
