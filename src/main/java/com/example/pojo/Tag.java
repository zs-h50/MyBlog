package com.example.pojo;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private Long id;

    private String name;
    /**级联关系*/
    private List<Blog> blogs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}