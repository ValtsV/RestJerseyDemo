package com.valts.RestJerseyDemo.models;

public class Book {

    private int index;
    private String name;
    private int pageCount;

    public Book(){};
    public Book(int index, String name, int pageCount) {
        this.index = index;
        this.name = name;
        this.pageCount = pageCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
