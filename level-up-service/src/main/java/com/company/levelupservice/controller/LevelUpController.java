package com.company.levelupservice.controller;

import com.company.levelupservice.circuitbreaker.LevelUpServiceCircuitBreaker;
import com.company.levelupservice.model.LevelViewModel;
import com.company.levelupservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/level-up")
public class LevelUpController {

    @Autowired
    private ServiceLayer serviceLayer;

    @Autowired
    private LevelUpServiceCircuitBreaker circuitBreaker;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LevelViewModel createLevelUp(@RequestBody LevelViewModel levelViewModel){
        return serviceLayer.addLevelUpEntry(levelViewModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<LevelViewModel> getAllLevelUp(){
        return serviceLayer.findAllLevelUpEntries();

    }

    @GetMapping(value = "/{level_up_id}")
    @ResponseStatus(HttpStatus.FOUND)
    public LevelViewModel getLevelUp(@PathVariable int level_up_id){
        return serviceLayer.findLevelUpEntry(level_up_id);
    }

    //not in spec: get level_up entry by customer_id
    @GetMapping(value = "/customer/{customer_id}")
    @ResponseStatus(HttpStatus.FOUND)
    public LevelViewModel getLevelUpByCustomer(@PathVariable int customer_id){
        return null;
    }


    @PutMapping(value = "/{level_up_id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLevelUp(@RequestBody LevelViewModel levelViewModel){serviceLayer.updateLevelUpEntry(levelViewModel);}

    @DeleteMapping(value = "/{level_up_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLevelUp(@PathVariable int level_up_id){serviceLayer.removeLevelUpEntry(level_up_id);}
}
