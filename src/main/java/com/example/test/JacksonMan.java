package com.example.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.People;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;

public class JacksonMan {

    public static void main(String args[]){

        /**
         * 1、jackson 用法
         */
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


        /**
         * 2、fastJson 用法
         */
        System.out.println("---------------------------------------------------");

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("phone", "phoneNumber");//phoneNumber,18118999628
        bodyJson.put("method", "itv");
        bodyJson.put("lanId", "cityCode");//cityCode,8320100
        bodyJson.put("provinceId", "provinceCode");//provinceCode,8320000
        bodyJson.put("auth","authJson");

        System.out.println(bodyJson.toJSONString());

//       放的是个json格式的string，所以带/，文本需要包含“”，则需要添加转义字符

        //2.1 JSON, 是JSONObject和JSONArray的父类，两个子类可以用JSON所有的公共方法，一切转换

//        String s = "{"name":"john","age":"23","id":"007","userOrder":[{"orderId":"my","storeName":"oo"}]}";
        String n = "{\"name\":\"john\",\"age\":\"23\",\"id\":\"007\",\"userOrder\":[{\"orderId\":\"my\",\"storeName\":\"oo\"}]}";
        String jsonArrayString = "[{\"studentName\":\"lily\",\"studentAge\":12}," +
                "{\"studentName\":\"lucy\",\"studentAge\":15}]";
        //指定反序列化类
        People peopleJsonObject = JSON.parseObject(n,People.class);
        //不指定反序列化类
        JSONObject jsonObject = JSON.parseObject(n);



        System.out.println("通过类取值："+ peopleJsonObject.getAge());
        System.out.println("通过不指定的类取值："+jsonObject.getString("age"));

        //通过JSON来输出jsonString
        System.out.println("JSON输出jsonString："+JSON.toJSONString(jsonObject));

        //通过JSONObjet方法来输出jsonString
        System.out.println("JSONObject输出jsonString: "+jsonObject.toJSONString());

        //JSONObject是可变的，通过put添加一个元素
        jsonObject.put("newtime","newname");
        System.out.println("JSONObject是可变的："+ jsonObject.toJSONString());
        System.out.println("JSON对javabean 进行转换："+JSON.toJSONString(peopleJsonObject));


        //2.2 JSONObject就是一个map，键值对,get /put
        JSONObject jsonObject1 = JSONObject.parseObject(n); //继承自JSON
//        jsonObject1.get("newname");
//        jsonObject1.put("secName","secage");

        System.out.println("----------------------------------");

        //2.3 JSONArray实际时一个List，每个元素都存放JOSN Objcet
        JSONArray jsonArray = JSON.parseArray(jsonArrayString);
        System.out.println("JsonArray的输出String："+jsonArray.toJSONString());


        //2.3.1 JsonArray两种遍历方式
        int jsonObjectNumber = jsonArray.size();
        for(int i = 0; i < jsonObjectNumber; i++){
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            System.out.println("jsonArray第一种遍历访问每一个jsonObject："+jsonObject2.toString());
        }
        System.out.println("----------------------------------");
        Iterator<Object> jsonObjectIterator = jsonArray.iterator();
        while(jsonObjectIterator.hasNext()){
            JSONObject jsonObjectTemp = (JSONObject)jsonObjectIterator.next();
            System.out.println("jsonArray第二种遍历访问每一个jsonObject："+ jsonObjectTemp.toString());
        }
        System.out.println("----------------------------------");



    }
}
