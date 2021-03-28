package com.yangzehan.vo;

import java.util.List;

public class pagevo<T> {
    private int total;
    public List<T>list;

    @Override
    public String toString() {
        return "pagevo{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
