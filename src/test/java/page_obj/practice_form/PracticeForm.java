package page_obj.practice_form;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    public PracticeForm setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PracticeForm setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;

    }

    public PracticeForm setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;

    }

    public PracticeForm selectGender(String gender) {
        $("#genterWrapper").parent().$(byText(gender)).click();
        return this;

    }

    public PracticeForm setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;

    }

    public PracticeForm dateBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month").$(byText(day)).click();
        return this;

    }

    public PracticeForm selectHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        return this;

    }

    public PracticeForm addPicture() {
        $("#uploadPicture").uploadFromClasspath("img/practiceForm.png");
        return this;

    }

    public PracticeForm setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;

    }

    public PracticeForm setStateAndSity(String state, String city) {
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        return this;

    }

    public PracticeForm butSubmit() {
        $("#submit").click();
        return this;

    }

    public PracticeForm assertTitleUrl() {
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        return this;

    }
}


