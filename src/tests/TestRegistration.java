package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.RegisterModal;
import util.Util;

import java.util.Random;

class TestRegistration {
    private Util util = new Util();

    private String url = "http://localhost:3000/";

    private RegisterModal registerModal;
    private HomePage homePage;

    private Random random = new Random();
    private int increment = random.nextInt(10000);

    private String usrnm;
    private String mail;
    private String pwd;


    @BeforeEach
    void setUp(){
        homePage = new HomePage();
        registerModal = new RegisterModal();
        util.navigateToUrl(url);
    }

    @AfterEach
    void teardown(){
        util.tearDown();
    }

    @Test
    void testRegistration(){
        usrnm = System.getenv("USERNAME") + increment;
        mail = increment + System.getenv("EMAIL");
        pwd = System.getenv("PASSWORD");
        homePage.openRegisterModal();
        registerModal.doRegister(usrnm, mail, pwd);
        Assertions.assertTrue(homePage.logoutBtnAppears());
    }
}
