package com.qiu.dmp.model;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2016/9/21.
 */
public class DataFile {
    private int id;
    private String name;
    private String path;
    private long size;
    private Timestamp CreateTime;
    private int creater;
    private boolean leaf = true;


    @Override
    public String toString() {
        return "DataFile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", CreateTime=" + CreateTime +
                ", creater=" + creater +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Timestamp getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Timestamp createTime) {
        CreateTime = createTime;
    }

    public int getCreater() {
        return creater;
    }

    public void setCreater(int creater) {
        this.creater = creater;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataFile dataFile = (DataFile) o;

        if (getId() != dataFile.getId()) return false;
        if (getSize() != dataFile.getSize()) return false;
        if (getCreater() != dataFile.getCreater()) return false;
        if (isLeaf() != dataFile.isLeaf()) return false;
        if (getName() != null ? !getName().equals(dataFile.getName()) : dataFile.getName() != null) return false;
        if (getPath() != null ? !getPath().equals(dataFile.getPath()) : dataFile.getPath() != null) return false;
        return getCreateTime() != null ? getCreateTime().equals(dataFile.getCreateTime()) : dataFile.getCreateTime() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPath() != null ? getPath().hashCode() : 0);
        result = 31 * result + (int) (getSize() ^ (getSize() >>> 32));
        result = 31 * result + (getCreateTime() != null ? getCreateTime().hashCode() : 0);
        result = 31 * result + getCreater();
        result = 31 * result + (isLeaf() ? 1 : 0);
        return result;
    }
}
