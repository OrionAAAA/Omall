package com.ori.Omall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ori.Omall.entity.PageResult;
import com.ori.Omall.mapper.TbContentCategoryMapper;
import com.ori.Omall.pojo.TbContentCategory;
import com.ori.Omall.pojo.TbContentCategoryExample;
import com.ori.Omall.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Orion on 2020/11/19 15:03
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<TbContentCategory> findAll() {
        return contentCategoryMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbContentCategory> page=   (Page<TbContentCategory>) contentCategoryMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(TbContentCategory contentCategory) {
        contentCategoryMapper.insert(contentCategory);
    }

    @Override
    public void update(TbContentCategory contentCategory) {
        contentCategoryMapper.updateByPrimaryKey(contentCategory);
    }

    @Override
    public TbContentCategory findOne(Long id) {
        return contentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            contentCategoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbContentCategory contentCategory, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbContentCategoryExample example=new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();

        if(contentCategory!=null){
            if(contentCategory.getName()!=null && contentCategory.getName().length()>0){
                criteria.andNameLike("%"+contentCategory.getName()+"%");
            }

        }

        Page<TbContentCategory> page= (Page<TbContentCategory>)contentCategoryMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
