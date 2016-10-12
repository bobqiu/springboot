package com.qiu.dmp.model;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/7.
 */
public class Dept {

    private int deptId;
    private int parentId;
    private String deptName;
    private Date createTime;
    private String note;


    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", parentId=" + parentId +
                ", deptName='" + deptName + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (getDeptId() != dept.getDeptId()) return false;
        if (getParentId() != dept.getParentId()) return false;
        if (getDeptName() != null ? !getDeptName().equals(dept.getDeptName()) : dept.getDeptName() != null)
            return false;
        if (getCreateTime() != null ? !getCreateTime().equals(dept.getCreateTime()) : dept.getCreateTime() != null)
            return false;
        return getNote() != null ? getNote().equals(dept.getNote()) : dept.getNote() == null;

    }

    @Override
    public int hashCode() {
        int result = getDeptId();
        result = 31 * result + getParentId();
        result = 31 * result + (getDeptName() != null ? getDeptName().hashCode() : 0);
        result = 31 * result + (getCreateTime() != null ? getCreateTime().hashCode() : 0);
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        return result;
    }
}
