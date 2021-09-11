package ru.netology.tests;

import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.ConnectionHelper;
import ru.netology.data.DataHelper;
import ru.netology.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.ConnectionHelper.wipeCode;
import static ru.netology.data.ConnectionHelper.wipeData;
import static ru.netology.data.Launcher.launch;

public class LoginFuncTests {

    @BeforeAll
    static void launchApp(){
        launch();
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @AfterEach
    void start() {
        wipeCode();
    }

    @AfterAll
    static void run() {
        wipeData();
    }

    @Test
    void shouldLogin() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = ConnectionHelper.getCode();
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.validFields();
    }

    @Test
    void shouldNotVerify() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val invalidVerificationCode = DataHelper.getInvalidVerificationCode();
        verificationPage.invalidVerify(invalidVerificationCode);
    }

    @Test
    void shouldNotLogin() {
        val loginPage = new LoginPage();
        val invalidAuthInfo = DataHelper.getInvalidAuthInfo();
        loginPage.invalidLogin(invalidAuthInfo);
    }

}
