package vn.com.seabank.service.dto;

public class Conditions {
    private String index;
    private String field_name;
    private String  type;
    private String  value;
    private String  operators;
    private String  combined;

    @Override
    public String toString() {
        return "{" +
            "index='" + index + '\'' +
            ", field_name='" + field_name + '\'' +
            ", type='" + type + '\'' +
            ", value='" + value + '\'' +
            ", operators='" + operators + '\'' +
            ", combined='" + combined + '\'' +
            '}';
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperators() {
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getCombined() {
        return combined;
    }

    public void setCombined(String combined) {
        this.combined = combined;
    }
}
