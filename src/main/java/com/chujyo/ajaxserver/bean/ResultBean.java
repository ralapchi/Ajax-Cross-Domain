package com.chujyo.ajaxserver.bean;

import org.springframework.context.annotation.Bean;

/**
 * Created by qidd on 2018-3-19
 */
public class ResultBean {
    private String Data;

    public ResultBean(String data) {
        Data = data;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
