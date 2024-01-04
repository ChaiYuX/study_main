package com.entity;

import java.util.ArrayList;
import java.util.List;

public class TranDetail {

    private List<Row> row = new ArrayList<>();

    private String rowList;

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

    public String getRowList() {
        return rowList;
    }

    public void setRowList(String rowList) {
        this.rowList = rowList;
    }
}
