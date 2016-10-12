package com.qiu.dmp.model.echart;

import java.util.List;

/**
 * Created by Administrator on 2016/10/10.
 */
public class Series {

    private String name;
    private String type;
    private List<Integer> data;


    public Series(String name, String type, List<Integer> data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Series{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Series series = (Series) o;

        if (getName() != null ? !getName().equals(series.getName()) : series.getName() != null) return false;
        if (getType() != null ? !getType().equals(series.getType()) : series.getType() != null) return false;
        return getData() != null ? getData().equals(series.getData()) : series.getData() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }
}
