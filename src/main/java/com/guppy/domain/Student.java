package com.guppy.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    @JsonProperty("subjectList")
    private List<Subject> subjectList;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Subject {

        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

    }

}
