package com.ori.Omall.controller;

import com.ori.Omall.pojo.TbSpecification;
import com.ori.Omall.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Orion on 2020/11/16 9:18
 */

@RestController
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;


    @GetMapping("/loadSpecification")
    public List<TbSpecification> loadSpecification(){
        return specificationService.getAllSpecification();
    }
}
