package com.xszheng.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syq on 2016/5/24.
 */
public class JsonUtil {

    private JSONObject jsonObject;

    private JsonUtil() {
    }

    public static JsonUtil newJson() {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.jsonObject = new JSONObject();
        jsonUtil.jsonObject.put("message", /*HTTPEnum.OK.getMessage()*/"请求成功");
        jsonUtil.jsonObject.put("code", /*HTTPEnum.OK.getCode()*/200);
        return jsonUtil;
    }


    public static JsonUtil newAppJson() {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.jsonObject = new JSONObject();
        jsonUtil.jsonObject.put("message", /*HTTPEnum.OK.getMessage()*/"请求成功");
        jsonUtil.jsonObject.put("code", /*HTTPEnum.OK.getCode()*/200);
        return jsonUtil;
    }


    public JsonUtil addData(String key, Object value) {
        this.jsonObject.put(key, value);
        return this;
    }

    public JsonUtil addMessage(Object value) {
        this.jsonObject.put("message", value);
        return this;
    }


    public JsonUtil addMsg(Object value) {
        this.jsonObject.put("msg", value);
        return this;
    }

    public JsonUtil addCode(Object value) {
        this.jsonObject.put("code", value);
        return this;
    }

    public JsonUtil addPageInfo(PageInfo<?> pageInfo) {
        JSONObject page = new JSONObject();
        page.put("currentPage", Integer.valueOf(pageInfo.getPageNum()));
        page.put("pages", Integer.valueOf(pageInfo.getPages()));
        page.put("total", Long.valueOf(pageInfo.getTotal()));
        this.jsonObject.put("page", page);
        return this;
    }

    public String toJsonString() {
        return this.jsonObject.toJSONString();
    }


    public JSON toJson() {
        return this.jsonObject;
    }


    public static <T> List<T> jsonArrayToJavaObj(JSONArray array, Class<T> javaObjClass) throws Exception {
        List<T> list = new ArrayList<>();
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject channelJson = array.getJSONObject(i);
                T ins = JSON.toJavaObject(channelJson, javaObjClass);
                list.add(ins);
            }
        }
        return list;
    }


}
