import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Character.CONTROL;

public class PracticeFormTests extends PracticeFormConfig {

    @Test
    void successfulPracticeFormTest() {
        //Открываем сайт demoqa.com
        open("/automation-practice-form");
        //Удаление банеров и footer
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Заполняемполя Name
        $("#firstName").setValue("Venera");
        $("#lastName").setValue("Tolubaeva");
        //Заполняем полеe mail
        $("#userEmail").setValue("aaa@qa.com");
        //Выбираем Gender
        //$("#gender-radio-2").parent().click();
        $(byText("Female")).click();
        //Заполняемполе Mobile
        $("#userNumber").setValue("9999999999");
        //Выбираем Date of Birth
        $("#dateOfBirthInput").pressEnter();
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__day--030").click();
        //Либо можно вписать дату вручную, но это менее предпочтительный вариант
        //$("#dateOfBirthInput").sendKeys(CONTROL+"A");
        //$("#dateOfBirthInput").sendKeys("01Mar1990");
        //$("#dateOfBirthInput").pressEnter();
        //Заполняемполе Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        //Выбираем Hobbies
        $("#hobbies-checkbox-1").parent().click();
        $(byText("Reading")).click();
        //Загружаем picture
        $("#uploadPicture").uploadFromClasspath("practiceFormPicture.jpg");
        //Заполняем Current address
        $("#currentAddress").setValue("Some street 1");
        //Выбираем State
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        //Выбираем City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Venera Tolubaeva"),
                text("aaa@qa.com"),
                text("Female"),
                text("9999999999"),
                text("30 November,1987"),
                text("Maths"),
                text("Sports, Reading"),
                text("practiceFormPicture.jpg"),
                text("Some street 1"),
                text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
