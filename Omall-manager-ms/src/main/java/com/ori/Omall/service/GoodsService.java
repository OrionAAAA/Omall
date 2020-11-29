package com.ori.Omall.service;

import com.ori.Omall.entity.PageResult;
import com.ori.Omall.pojo.TbGoods;
import com.ori.Omall.pojo.TbItem;
import com.ori.Omall.pojogroup.Goods;

import java.util.List;

/**
 * Created by Orion on 2020/11/27 16:10
 */
public interface GoodsService {
    /**
     * 返回全部列表
     * @return
     */
    public List<TbGoods> findAll();


    /**
     * 返回分页列表
     * @return
     */
    public PageResult findPage(int pageNum, int pageSize);


    /**
     * 增加
     */
    public void add(Goods goods);


    /**
     * 修改
     */
    public void update(Goods goods);


    /**
     * 根据ID获取实体
     * @param id
     * @return
     */
    public Goods findOne(Long id);


    /**
     * 批量删除
     * @param ids
     */
    public void delete(Long[] ids);

    /**
     * 分页
     * @param pageNum 当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    public PageResult findPage(TbGoods goods, int pageNum, int pageSize);

    public void updateStatus(Long[] ids, String status);


    public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] ids, String status);
}
