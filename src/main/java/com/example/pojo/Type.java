package com.example.pojo;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Type {
    private Long id;
    private String name;

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