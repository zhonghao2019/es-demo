package com.zhonghao.es.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 指定索引库，类型，分片数量
@Document(indexName = "zhonghao", type = "item", shards = 1)
public class Item {
    @Field(type = FieldType.Long)
    @Id
    Long id;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    String title; //标题，默认索引

    @Field(type = FieldType.Keyword)
    String category;// 分类

    @Field(type = FieldType.Keyword)
    String brand; // 品牌

    @Field(type = FieldType.Keyword)
    Double price; // 价格

    @Field(type=FieldType.Keyword, index = false)
    String images; // 图片地址
}
