package com.zhonghao.es.demo;

import com.zhonghao.es.pojo.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void testCreate() {
        // 创建索引库
        template.createIndex(Item.class);
        // 映射关系
        template.putMapping(Item.class);
    }
}
