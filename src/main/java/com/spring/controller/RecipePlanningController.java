package com.spring.controller;

import com.spring.database.RecipePlanningDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/recipe-planning")
public class RecipePlanningController {

    @Autowired
    private RecipePlanningDatabase recipePlanningDatabase;

    //TODO
}
