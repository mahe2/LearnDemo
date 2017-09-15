package com.learn.demo.bean;

/**
 * Created by mahe on 2017/9/1.
 */

public class EntryData extends CommenData {
    public String name;
    public String routePath;

    public EntryData(String name, String routePath) {
        this.name = name;
        this.routePath = routePath;
    }

    public EntryData() {
    }
}

