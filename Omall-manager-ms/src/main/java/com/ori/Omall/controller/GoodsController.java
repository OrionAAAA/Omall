package com.ori.Omall.controller;

import com.ori.Omall.entity.PageResult;
import com.ori.Omall.entity.Result;
import com.ori.Omall.pojo.TbGoods;
import com.ori.Omall.pojo.TbItem;
import com.ori.Omall.pojogroup.Goods;
import com.ori.Omall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Orion on 2020/11/27 16:07
 */
@RestController
@RequestMapping("/goods-ms")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbGoods> findAll(){
        return goodsService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult  findPage(int page,int rows){
        return goodsService.findPage(page, rows);
    }

    /**
     * 增加
     * @param goods
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Goods goods){
        System.out.println("#######"+goods.getGoods().getGoodsName()+"#######");
        System.out.println("#######"+goods.getGoodsDesc().getItemImages());
        System.out.println("#######"+goods.getGoodsDesc().getSpecificationItems());
        System.out.println("#######"+goods.getGoodsDesc().getCustomAttributeItems());

        try {
            // 获得商家信息:
            //String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
            String sellerId = "yqtech"; //暂时设定
            goods.getGoods().setSellerId(sellerId);

            goodsService.add(goods);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param goods
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Goods goods){
        // 获得商家信息:
        //String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        String sellerId = "yqtech"; //暂时设定
        Goods goods2 = goodsService.findOne(goods.getGoods().getId());
        if(!sellerId.equals(goods2.getGoods().getSellerId()) || !sellerId.equals(goods.getGoods().getSellerId())){
            return new Result(false, "非法操作");
        }

        try {
            goodsService.update(goods);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 审核
     * @param
     * @return
     */
    @RequestMapping("/updateStatus")
    public Result updateStatus(Long[] ids,String status){
        try {
            goodsService.updateStatus(ids,status);
            return new Result(true, "审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "审核失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Goods findOne(Long id){
        return goodsService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            goodsService.delete(ids);
            System.out.println("删除成功");
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){

        //String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
        String sellerId = "yqtech"; //暂时设定

        goods.setSellerId(sellerId);

        return goodsService.findPage(goods, page, rows);
    }

}
