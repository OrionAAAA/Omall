package com.ori.Omall.search.controller;

import com.ori.Omall.mapper.TbItemMapper;
import com.ori.Omall.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Orion on 2020/11/25 9:15
 */
@RestController
@RequestMapping("/itemsearch-ms")
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private SolrTemplate solrTemplate;

    @RequestMapping("/search")
    public Map search(@RequestBody Map searchMap){
        System.out.println(searchMap);
        System.out.println(itemSearchService.search(searchMap));
        return itemSearchService.search(searchMap);
    }
}
