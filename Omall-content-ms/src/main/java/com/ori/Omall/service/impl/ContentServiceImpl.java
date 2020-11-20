package com.ori.Omall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ori.Omall.entity.PageResult;
import com.ori.Omall.mapper.TbContentMapper;
import com.ori.Omall.pojo.TbContent;
import com.ori.Omall.pojo.TbContentExample;
import com.ori.Omall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Orion on 2020/11/19 10:22
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<TbContent> findAll() {
        return contentMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbContent> page=(Page<TbContent>)contentMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbContent content) {

        contentMapper.insert(content);
    }

    @Override
    public void update(TbContent content) {
        contentMapper.updateByPrimaryKey(content);
    }

    @Override
    public TbContent findOne(Long id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            TbContent tbContent = contentMapper.selectByPrimaryKey(id);
//            redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());

            contentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbContent content, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbContentExample example=new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();

        if(content!=null){
            if(content.getTitle()!=null && content.getTitle().length()>0){
                criteria.andTitleLike("%"+content.getTitle()+"%");
            }
            if(content.getUrl()!=null && content.getUrl().length()>0){
                criteria.andUrlLike("%"+content.getUrl()+"%");
            }
            if(content.getPic()!=null && content.getPic().length()>0){
                criteria.andPicLike("%"+content.getPic()+"%");
            }
            if(content.getStatus()!=null && content.getStatus().length()>0){
                criteria.andStatusLike("%"+content.getStatus()+"%");
            }

        }

        Page<TbContent> page= (Page<TbContent>)contentMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<TbContent> findByCategoryId(Long categoryId) {
        return null;
    }
}
