package vn.com.seabank.service.dto;

import java.time.LocalDateTime;

public class IValueInsertData {
    private String field_name;
    private String value;
    private String type;
    private String nullable;


    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    @Override
    public String toString() {
        return "{" +
            "field_name='" + field_name + '\'' +
            ", value='" + value + '\'' +
            ", type='" + type + '\'' +
            ", nullable='" + nullable + '\'' +
            '}';
    }
}
