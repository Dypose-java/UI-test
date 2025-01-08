package page_obj.practice_form;

public enum StateAndCity {
    NCR("NCR"),UTTAR_PRADESH("Uttar Pradesh")
    ,HARYANA("Haryana"),RAJASTHAN("Rajasthan"),
    JAPAIR("Jaipur"),JAISELMER("Jaiselmer");

    private String value;

    StateAndCity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
