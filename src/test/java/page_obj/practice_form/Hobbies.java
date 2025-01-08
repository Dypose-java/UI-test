package page_obj.practice_form;

public enum Hobbies {
    SPORTS("Sports"),READING("Reading"),MUSIC("Music");
    String value;

    Hobbies(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
