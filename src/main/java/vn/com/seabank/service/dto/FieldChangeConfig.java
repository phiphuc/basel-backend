package vn.com.seabank.service.dto;

public class FieldChangeConfig {
    private String display;
    private String mandatory;
    private String field_name;

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "{" +
            "display='" + display + '\'' +
            ", mandatory='" + mandatory + '\'' +
            ", field_name='" + field_name + '\'' +
            '}';
    }
}
