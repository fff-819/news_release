package com.uml.pojo;

import java.util.List;

public class Pages {
    Long current;
    Long size;
    Long total;
    List list;

    public Pages() {
    }

    public Long getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "current=" + current +
                ", size=" + size +
                ", total=" + total +
                ", list=" + list +
                '}';
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Pages(Long current, Long size, Long total, List list) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.list = list;
    }
}
