package vn.com.seabank.service.dto;

import java.util.ArrayList;

public class BS2GetDataRequest {
    private String tbl_name;
    private ArrayList<Conditions> conditions;
    private String page_index;
    private String page_size;

    public String getTbl_name() {
        return tbl_name;
    }

    public void setTbl_name(String tbl_name) {
        this.tbl_name = tbl_name;
    }

    public ArrayList<Conditions> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Conditions> conditions) {
        this.conditions = conditions;
    }

    public String getPage_index() {
        return page_index;
    }

    public void setPage_index(String page_index) {
        this.page_index = page_index;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    @Override
    public String toString() {
        return "{" +
            "tbl_name='" + tbl_name + '\'' +
            ", conditions=" + conditions +
            ", page_index='" + page_index + '\'' +
            ", page_size='" + page_size + '\'' +
            '}';
    }
}
