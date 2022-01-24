package guru.qa.hw9;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BaseData {
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNo = "7981981981", //Faker дает кривые телефонные номера
            path = "img/chil.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana", //можно как вариант забить все штаты и города и рандомно выбирать для тестов
            city = "Karnal";
    String[] subjects = {"Chemistry", "Arts"}, /*аналогично штатам можно обогатить список предметов, чтобы рандомно
                                                брать несколько из них*/
            hobbies = {"Sports", "Reading", "Music"};

    public Map<String, String> getValuesForCheckingAfterSubmitting() {
        Map<String, String> valuesForCheckingAfterSubmitting = new HashMap<>();
        valuesForCheckingAfterSubmitting.put("Student Name", firstName + " " + lastName);
        valuesForCheckingAfterSubmitting.put("Student Email", email);
        valuesForCheckingAfterSubmitting.put("Gender", "Male");
        valuesForCheckingAfterSubmitting.put("Mobile", phoneNo);
        valuesForCheckingAfterSubmitting.put("Date of Birth", "30 April,2013");
        valuesForCheckingAfterSubmitting.put("Subjects", "Chemistry, Arts");
        valuesForCheckingAfterSubmitting.put("Hobbies", "Sports, Reading, Music");
//        valuesForCheckingAfterSubmitting.put("Picture", "chil.jpg");
        valuesForCheckingAfterSubmitting.put("Address", address);
        valuesForCheckingAfterSubmitting.put("State and City", state + " " + city);
        Arrays.stream(subjects).forEach(System.out::print);
        return valuesForCheckingAfterSubmitting;
    }
}
