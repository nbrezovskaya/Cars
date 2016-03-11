package demo.test.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;

/**
 * Class Cars main page
 */
public class CarsMainPage extends BaseForm {

    public CarsMainPage() {
        super(By.xpath("//a[@name='&lid=header-home']"), "Cars com");
    }

 }
