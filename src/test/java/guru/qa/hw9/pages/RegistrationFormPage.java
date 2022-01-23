package guru.qa.hw9.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationFormPage {
    public static String URL = "/automation-practice-form";

    //Элементы формы регистрации
    private final SelenideElement
            formTitle = $("h5"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genderMaleRadio = $("#genterWrapper").$(byText("Male")),
            genderFemaleRadio = $("#genterWrapper").$(byText("Female")),
            genderOtherRadio = $("#genterWrapper").$(byText("Other")),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            hobbySportsCheckbox = $("#hobbiesWrapper").$(byText("Sports")),
            hobbyReadingCheckbox = $("#hobbiesWrapper").$(byText("Reading")),
            hobbyMusicCheckbox = $("#hobbiesWrapper").$(byText("Music")),
            uploadPicture = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            state = $("#state"),
            stateDropDownList = $("#react-select-3-input"),
            city = $("#city"),
            cityDropDownList = $("#react-select-4-input"),
            submitButton = $("#submit");
    private ElementsCollection days = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");

    //Элементы формы подтверждения регистрации
    private SelenideElement modalHeader = $(".modal-header");
    private ElementsCollection tableRows = $("tbody").$$("tr");

    @Step("Проверка загрузки страницы с регистрационной формой")
    public RegistrationFormPage checkThatPageIsLoaded() {
        formTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Ввод имени")
    public RegistrationFormPage typeFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Ввод фамилии")
    public RegistrationFormPage typeLastName(String lastname) {
        lastNameInput.setValue(lastname);
        return this;
    }

    @Step("Ввод e-mail")
    public RegistrationFormPage typeUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    @Step("Выбор пола: Мужской")
    public RegistrationFormPage setMaleRadio() {
        genderMaleRadio.click();
        return this;
    }

    @Step("Выбор пола: Женский")
    public RegistrationFormPage setFemaleRadio() {
        genderFemaleRadio.click();
        return this;
    }

    @Step("Ввод телефона")
    public RegistrationFormPage typeUserPhoneNo(String phoneNo) {
        userNumberInput.setValue(phoneNo);
        return this;
    }

    @Step("Ввод даты рождения {day}/{month}/{year}")
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        days.findBy(text(day)).click();
        return this;
    }

    @Step("Ввод предметов {subjects}")
    public RegistrationFormPage setSubjects(String... subjects) {
        Arrays.stream(subjects).forEach(subject -> {
            subjectsInput.setValue(subject).pressEnter();
        });
        return this;
    }

    @Step("Ввод хобби {hobbies}")
    public RegistrationFormPage setHobbies(String... hobbies) {
        Arrays.stream(hobbies).forEach(hobby -> {
            $("#hobbiesWrapper").$(byText(hobby)).click();
        });
        return this;
    }

    @Step("Загрузка фото")
    public RegistrationFormPage uploadPicture(String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }

    @Step("Ввод адреса {address}")
    public RegistrationFormPage typeAddress(String address) {
        currentAddressTextArea.setValue(address);
        return this;
    }

    @Step("Выбор штата")
    public RegistrationFormPage selectState(String stateName) {
        state.click();
        stateDropDownList.setValue(stateName).pressEnter();
        return this;
    }

    @Step("Выбор города")
    public RegistrationFormPage selectCity(String cityName) {
        city.click();
        cityDropDownList.setValue(cityName).pressEnter();
        return this;
    }

    @Step("Нажать на кнопку submit")
    public RegistrationFormPage pushSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверка заполненной формы")
    public void checkResultSubmitting(Map<String, String> tableRowsValues) {
        modalHeader.shouldHave(text("Thanks for submitting the form"));
        checkTableValues(tableRowsValues);
    }

    @Step("Проверка каждого заполненного поля")
    public void checkTableValues(Map<String, String> tableRowsValues) {
        tableRowsValues.forEach((key, value) -> {
            tableRows.findBy(text(key)).shouldHave(text(value));
        });
    }
}