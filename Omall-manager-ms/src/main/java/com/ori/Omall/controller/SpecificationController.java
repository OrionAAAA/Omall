package com.ori.Omall.controller;

import com.ori.Omall.entity.PageResult;
import com.ori.Omall.entity.Result;
import com.ori.Omall.pojo.TbSpecification;
import com.ori.Omall.pojogroup.Specification;
import com.ori.Omall.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Orion on 2020/11/16 9:18
 */

@RestController
@RequestMapping("/specification-Ms")
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;


    @GetMapping("/findAll")
    public List<TbSpecification> loadSpecification(){
        System.out.println(specificationService.AllTbSpecification());
        return specificationService.AllTbSpecification();
    }

    /**
     * 返回全部列表
     * @return
     */
    @GetMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return specificationService.findPage(page, rows);
    }


    @GetMapping("/findOne")
    public Specification loadAnSpecification(long id){
        return specificationService.getSpecificationById(id);
    }

    @PostMapping("/add")
    public Result addSpecification(@RequestBody Specification specification){
        specificationService.addSpecification(specification);
        return new Result().success("添加成功");
    }

    /**
     * 修改
     * @param specification
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Specification specification){
        try {
            specificationService.updateSpecification(specification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @GetMapping("/delete")
    public Result delete(Long [] ids){
        try {
            specificationService.deleteSpecification(ids);
            System.out.println("SpecificationController.delete"+"删除成功");
            for (long id:ids){
                System.out.println(specificationService.getSpecificationById(id));
            }
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
