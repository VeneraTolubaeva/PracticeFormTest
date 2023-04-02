import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class PracticeFormConfig {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        //Configuration.holdBrowserOpen = true;
        //Configuration.browser = "chrome";


    }
}
