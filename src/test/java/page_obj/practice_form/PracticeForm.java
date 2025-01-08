package page_obj.practice_form;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    ElementsCollection form =$$(".table-responsive tr");

    @Step("Устанавливаем имя {firstName}")
    public PracticeForm setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }
    @Step("Устанавливаем фамилию {lastName}")
    public PracticeForm setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;

    }
    @Step("Устанавливаем email {email}")
    public PracticeForm setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;

    }
    @Step("Выбираем гендер  {gender}")
    public PracticeForm selectGender(String gender) {
        $("#genterWrapper").parent().$(byText(gender)).click();
        return this;

    }
    @Step("Устанавливаем телефон {phone}")
    public PracticeForm setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;

    }

    @Step("Устанавливаем дату,месяц:{month},год:{year},день:{day}")
    public PracticeForm dateBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month").$(byText(day)).click();
        return this;

    }
    @Step("Устанавливаем хобби {hobbies}")
    public PracticeForm selectHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        return this;

    }
    @Step("Добавление картинки")
    public PracticeForm addPicture() {
        $("#uploadPicture").uploadFromClasspath("img/practiceForm.png");
        return this;

    }
    @Step("Устанавливаем адрес")
    public PracticeForm setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;

    }
    @Step("Устанавливаем страна:{state},город:{city}")
    public PracticeForm setStateAndSity(String state, String city) {
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        return this;

    }
    @Step("Нажимаем кнопку submit")
    public PracticeForm butSubmit() {
        $("#submit").click();
        return this;

    }
    @Step("Проверка главного заголовка")
    public PracticeForm assertTitleUrl() {
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        return this;
    }
    @Step("Проверка имя")
    public PracticeForm assertName(String firstName,String lastName){
        form.get(1).shouldHave(text(firstName),text(lastName));
        return this;
    }
    @Step("Проверка фамилии")
    public PracticeForm assertEmail(String email){
        form.get(2).shouldHave(text(email));
        return this;
    }
    @Step("Проверка гендера")
    public PracticeForm assertGender(String name){
        form.get(3).shouldHave(text(name));
        return this;
    }
    @Step("Проверка телефона")
    public PracticeForm assertPhone(String name){
        form.get(4).shouldHave(text(name));
        return this;
    }
    @Step("Проверка даты рождения")
    public PracticeForm assertDateOfBirth(String name){
        form.get(5).shouldHave(text(name));
        return this;
    }
    @Step("Проверка предметов")
    public PracticeForm assertSubjects(String name){
        form.get(6).shouldHave(text(name));
        return this;
    }
    @Step("Проверка хобби")
    public PracticeForm assertHobbies(String name){
        form.get(7).shouldHave(text(name));
        return this;
    }
    @Step("Проверка загрузки картинки")
    public PracticeForm assertPicture(String name){
        form.get(8).shouldHave(text(name));
        return this;
    }
    @Step("Проверка адреса")
    public PracticeForm assertAddress(String name){
        form.get(9).shouldHave(text(name));
        return this;
    }
    /*public PracticeForm assertStateAndCity(String name){
        form.get(10).shouldHave(text(name));
        return this;
    }*/
}


