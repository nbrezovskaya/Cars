package demo.test.forms;

import demo.test.model.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.Browser;
import webdriver.elements.Button;
import webdriver.elements.Combobox;
import webdriver.elements.Label;
/**
 * Class Car reviews page
 */
public class CarReviewsPage extends BaseForm {
    private Combobox cmbSelectMake = new Combobox(By.xpath("//*[@name='make']"), "Select a Make");
    private Combobox cmbSelectModel = new Combobox(By.xpath("//*[@name='model']"), "Select a Model");
    private Combobox cmbSelectYear = new Combobox(By.xpath("//*[@name='year']"), "Select a Year");
    private Button btGo = new Button(By.xpath("//*[@name='&lid=reviewsSearch']"), "Click Go");

    public CarReviewsPage() {
        super(By.xpath("//*[@class='col41']/h1"), "Car Reviews");
    }

    /**
     * Choose cars with parameters different from the previous.
     * @param  exclude
     * @return car
     */
    public Car selectRandomCar(Car exclude) {
        int maxTriesPerCar = Integer.parseInt(Browser.props.getProperty("maxTriesPerCar"));
        int triesMade = 0;
        Car car = new Car();
        do {
            cmbSelectMake.click();
            car.setMake(cmbSelectMake.clickRandomOption(true));
            cmbSelectModel.click();
            car.setModel(cmbSelectModel.clickRandomOption(true));
            cmbSelectYear.click();
            car.setYear(Integer.parseInt(cmbSelectYear.clickMaxOption()));
        } while ((car.getYear() < 1997 || car.equals(exclude)) && ++triesMade < maxTriesPerCar);
        btGo.clickAndWait();
        return car;
    }

}
