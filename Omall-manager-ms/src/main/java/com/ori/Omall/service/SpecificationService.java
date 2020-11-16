package com.ori.Omall.service;

import com.ori.Omall.pojo.TbSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Orion on 2020/11/13 15:36
 */

public interface SpecificationService {

    List<TbSpecification> getAllSpecification();
    TbSpecification getSpecificationById(long id);
    void addSpecification (TbSpecification tbSpecification);
    void updateSpecification(TbSpecification tbSpecification);
    void deleteSpecification(long id);
}
