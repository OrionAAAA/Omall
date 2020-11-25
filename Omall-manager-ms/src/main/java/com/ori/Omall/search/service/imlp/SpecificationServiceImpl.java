package com.ori.Omall.search.service.imlp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ori.Omall.entity.PageResult;
import com.ori.Omall.mapper.TbSpecificationMapper;
import com.ori.Omall.mapper.TbSpecificationOptionMapper;
import com.ori.Omall.pojo.TbSpecification;
import com.ori.Omall.pojo.TbSpecificationOption;
import com.ori.Omall.pojo.TbSpecificationOptionExample;
import com.ori.Omall.pojogroup.Specification;
import com.ori.Omall.search.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Orion on 2020/11/16 8:40
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    TbSpecificationMapper specificationMapper;
    @Autowired
    TbSpecificationOptionMapper specificationOptionMapper;


    @Override
    public List<TbSpecification> AllTbSpecification() {
        return specificationMapper.selectByExample(null);
    }

    @Override
    public Specification getSpecificationById(long id) {
        Specification specification=new Specification();
        specification.setSpecification(specificationMapper.selectByPrimaryKey(id));

        TbSpecificationOptionExample example=new TbSpecificationOptionExample();
        example.createCriteria().andSpecIdEqualTo(id);
        specification.setSpecificationOptionList(specificationOptionMapper.selectByExample(example));
        System.out.println(specification.getSpecification());
        System.out.println(specification.getSpecificationOptionList());
        return specification;
    }



    @Override
    public void deleteSpecification(Long [] ids) {
        for(Long id:ids){
            // 删除规格
            specificationMapper.deleteByPrimaryKey(id);

            // 删除规格选项:
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            specificationOptionMapper.deleteByExample(example);
        }
    }

    /**
     * 增加
     */
    @Override
    public void addSpecification(Specification specification) {
        // 保存规格  一方的数据
        specificationMapper.insert(specification.getSpecification());
        // 保存规格选项  多方的数据
        for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()){
            // 设置规格的ID:  主键回填
            specificationOption.setSpecId(specification.getSpecification().getId());

            specificationOptionMapper.insert(specificationOption);
        }
    }

    /**
     * 修改
     */
    @Override
    public void updateSpecification(Specification specification){
        // 修改规格 一方
        specificationMapper.updateByPrimaryKey(specification.getSpecification());

        // 先删除规格选项，再添加规格选项
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();

        criteria.andSpecIdEqualTo(specification.getSpecification().getId());

        specificationOptionMapper.deleteByExample(example);  //delete from specification_option where spec_id=?

        // 保存规格选项
        for(TbSpecificationOption specificationOption: specification.getSpecificationOptionList()){
            // 设置规格的ID:
            System.out.println(specificationOption.getId());
            specificationOption.setSpecId(specification.getSpecification().getId());

            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        return specificationMapper.selectOptionList();
    }
}
