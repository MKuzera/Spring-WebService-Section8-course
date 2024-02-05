package com.javacourse.section8.HelloWorld;

public class HelloWorldBean {
    private String field;
    public HelloWorldBean(String field){
        this.field = field;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "field='" + field + '\'' +
                '}';
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
