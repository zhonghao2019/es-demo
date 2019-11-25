package com.zhonghao.es.demo;

import com.zhonghao.es.pojo.Item;
import com.zhonghao.es.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Autowired
    private ItemRepository repository;

    @Test
    public void testCreate() {
        // 创建索引库
        template.createIndex(Item.class);
        // 映射关系
        template.putMapping(Item.class);
    }

    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米手机7", " 手机", "小米", 3499.00, "http://image.zhonghao.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.zhonghao.com/123.jpg"));
        list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.zhonghao.com/3.jpg"));
        repository.saveAll(list);
    }

    @Test
    public void testFind() {
        Iterable<Item> all = repository.findAll();
        for (Item item : all) {
            System.out.println(item);
        }
    }

    @Test
    public void testFindBy() {
        List<Item> list = repository.findByPriceBetween(3500d, 4000d);
        for (Item item : list) {
            System.out.println(item);
        }
    }
}
