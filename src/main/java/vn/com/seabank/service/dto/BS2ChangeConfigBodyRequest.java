package vn.com.seabank.service.dto;

import java.util.ArrayList;

public class BS2ChangeConfigBodyRequest {
    private String tbl_name;
    private ArrayList<FieldChangeConfig> fields;

    @Override
    public String toString() {
        return "{" +
            "tbl_name='" + tbl_name + '\'' +
            ", fields=" + fields +
            '}';
    }

    public String getTbl_name() {
        return tbl_name;
    }

    public void setTbl_name(String tbl_name) {
        this.tbl_name = tbl_name;
    }

    public ArrayList<FieldChangeConfig> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldChangeConfig> fields) {
        this.fields = fields;
    }
}
