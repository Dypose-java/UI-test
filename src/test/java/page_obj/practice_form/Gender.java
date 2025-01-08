package page_obj.practice_form;

public enum Gender {
    MALE("Male"),FEMALE("Female"),OTHER("Other");
    String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
