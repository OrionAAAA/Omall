package com.ori.Omall.service;

import com.ori.Omall.entity.PageResult;
import com.ori.Omall.pojo.TbSpecification;
import com.ori.Omall.pojogroup.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Orion on 2020/11/13 15:36
 */

public interface SpecificationService {

    List<TbSpecification> AllTbSpecification();

    Specification getSpecificationById(long id);

    void deleteSpecification(Long [] ids);

    void addSpecification(Specification specification);
    void updateSpecification(Specification specification);

    PageResult findPage(int page, int rows);

    public List<Map> selectOptionList();
}
