package vn.com.seabank.service.dto;

import java.util.List;

public class BS2InsertDataBodyRequest {
    private String tbl_name;
    private String group_table;
    private List<IValueInsertData> ivalues;

    public String getTbl_name() {
        return tbl_name;
    }

    public void setTbl_name(String tbl_name) {
        this.tbl_name = tbl_name;
    }

    public String getGroup_table() {
        return group_table;
    }

    public void setGroup_table(String group_table) {
        this.group_table = group_table;
    }

    public List<IValueInsertData> getIvalues() {
        return ivalues;
    }

    public void setIvalues(List<IValueInsertData> ivalues) {
        this.ivalues = ivalues;
    }

    @Override
    public String toString() {
        return "{" +
            "tbl_name='" + tbl_name + '\'' +
            ", group_table='" + group_table + '\'' +
            ", ivalues=" + ivalues +
            '}';
    }
}
