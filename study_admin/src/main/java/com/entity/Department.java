package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int deptId;
    private int parentId;
    private String deptName;
    private List<Department> children;

    public Department(int deptId, int parentId, String deptName) {
        this.deptId = deptId;
        this.parentId = parentId;
        this.deptName = deptName;
        this.children = new ArrayList<>();
    }

    public int getDeptId() {
        return deptId;
    }

    public int getParentId() {
        return parentId;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void addChild(Department child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", parentId=" + parentId +
                ", deptName='" + deptName + '\'' +
                ", children=" + children +
                '}';
    }

}
