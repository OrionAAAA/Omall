package com.ori.Omall.controller;

import com.ori.Omall.entity.PageResult;
import com.ori.Omall.entity.Result;
import com.ori.Omall.pojo.TbContent;
import com.ori.Omall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Orion on 2020/11/20 16:27
 */
@RestController
@RequestMapping("/content-ms")
public class ContentController {

    @Autowired
    private ContentService contentService;


    @RequestMapping("/findByCategoryId")
    public List<TbContent> findByCategoryId(Long categoryId){
        return contentService.findByCategoryId(categoryId);
    }

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbContent> findAll(){
        return contentService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return contentService.findPage(page, rows);
    }

    /**
     * 增加
     * @param content
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbContent content){
        try {
            contentService.add(content);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param content
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbContent content){
        try {
            contentService.update(content);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbContent findOne(Long id){
        return contentService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            contentService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbContent content, int page, int rows  ){
        return contentService.findPage(content, page, rows);
    }

}
