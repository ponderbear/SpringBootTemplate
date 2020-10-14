package com.example.test;

import VO.People;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonMan {
    public static void main(String args[]){
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{\"name\":\"john\",\"age\":\"21\"}";
        try {

            //read:序列化一切
            // son字符串反序列化为POJO，可以根据不同的数据源进行读取，String、File
            People people = objectMapper.readValue(jsonString, People.class);
            //设置序列化输出的格式
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(people.toString());

            //write：反序列化一切
            // POJO序列化为json字符串
            //使用默认的输出格式
            String peopleString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);
            System.out.println(peopleString);

            //将字符串读取为树模型，按照树节点node来操作
            //JsonNode 不可变！！！
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            System.out.println(jsonNode.get("name").asText());


            //创建arrayNode/objectNode
            ArrayNode arrayNode1 = objectMapper.createArrayNode();
            JsonFactory jsonFactory = new JsonFactory();
            ArrayNode arrayNode2 = JsonNodeFactory.instance.arrayNode();
            arrayNode2.add("a");
            arrayNode2.add("b");
            ObjectNode objectNode = jsonNode.deepCopy();
            //JsonNode不可变
            //objectNode添加新的节点
            objectNode.set("word",arrayNode2);
            System.out.println(objectNode.toPrettyString());
//            System.out.println(objectNode.toPrettyString())

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
