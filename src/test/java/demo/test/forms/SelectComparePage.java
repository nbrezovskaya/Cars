package demo.test.forms;


import demo.test.model.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Combobox;
import webdriver.elements.Label;

/**
 * Class Select compare page
 */
public class SelectComparePage extends BaseForm {
    private Combobox cmbSelectMake1 = new Combobox(By.xpath("//*[@name='division_1']"), "Select a Make 1");
    private Combobox cmbSelectModel1 = new Combobox(By.xpath("//*[@name='model_1']"), "Select a Model 1");
    private Combobox cmbSelectYear1 = new Combobox(By.xpath("//*[@name='year_1']"), "Select a Year 1");
    private Combobox cmbSelectMake2 = new Combobox(By.xpath("//*[@name='division_2']"), "Select a Make 2");
    private Combobox cmbSelectModel2 = new Combobox(By.xpath("//*[@name='model_2']"), "Select a Model 2");
    private Combobox cmbSelectYear2 = new Combobox(By.xpath("//*[@name='year_2']"), "Select a Year 2");
    private Button btCompare = new Button(By.xpath("//a[text()='Compare']"), "Click Compare");

    public SelectComparePage() {
        super(By.xpath(".//*[@name='selectForm']"), "Compare");
    }

    /**
     * Choice of two cars to compare.
     * @param car1 car1
     * @param car2 car2
     */
    public void selectCars(Car car1, Car car2){
        cmbSelectYear1.click();
        cmbSelectYear1.clickOption(Integer.toString(car1.getYear()));
        cmbSelectMake1.click();
        cmbSelectMake1.clickOption(car1.getMake());
        cmbSelectModel1.click();
        cmbSelectModel1.clickOption(car1.getModel());
        cmbSelectYear2.click();
        cmbSelectYear2.clickOption(Integer.toString(car2.getYear()));
        cmbSelectMake2.click();
        cmbSelectMake2.clickOption(car2.getMake());
        cmbSelectModel2.click();
        cmbSelectModel2.clickOption(car2.getModel());
    }

    /**
     * Click button 'Compare'.
     */
    public void clickCompare(){
       btCompare.click();
    }
}
