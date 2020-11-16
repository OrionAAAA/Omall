package com.ori.Omall.service.imlp;

import com.ori.Omall.mapper.TbSpecificationMapper;
import com.ori.Omall.pojo.TbSpecification;
import com.ori.Omall.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Orion on 2020/11/16 8:40
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    TbSpecificationMapper tbSpecificationMapper;

    @Override
    public List<TbSpecification> getAllSpecification() {
        return tbSpecificationMapper.selectByExample(null);
    }

    @Override
    public TbSpecification getSpecificationById(long id) {
        return tbSpecificationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addSpecification(TbSpecification tbSpecification) {
        tbSpecificationMapper.insert(tbSpecification);
    }

    @Override
    public void updateSpecification(TbSpecification tbSpecification) {
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
    }

    @Override
    public void deleteSpecification(long id) {
        tbSpecificationMapper.deleteByPrimaryKey(id);
    }
}
