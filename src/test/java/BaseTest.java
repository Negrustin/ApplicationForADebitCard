import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;

public class BaseTest {

    @BeforeAll
    static void setupAll() {

        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;

    }
    @AfterEach
    void tearDown() {

        Selenide.closeWebDriver();

    }

}
