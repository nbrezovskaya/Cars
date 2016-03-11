package demo.test.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.UlList;

import java.util.List;

/**
 * Class Description car page
 */
public class DescriptionCarPage extends BaseForm {
    private Button btOverview = new Button(By.xpath("//*[contains(text(), 'Overview')]"), "Tab Overview");
    private Button btOverviewActive = new Button(By.xpath("//*[contains(@class, 'active') and contains(text(), 'Overview')]"), "Tab Overview is active");
    private UlList transmissionsList = new UlList(By.xpath("//ul[li='Transmissions:']"), "Transmissions:");
    private UlList enginesList = new UlList(By.xpath("//ul[li='Available Engines:']"), "Available Engines:");

    public DescriptionCarPage() {
        super(By.xpath("//*[@itemprop='name']"), "Car name");
    }

    /**
     * Click on the tab 'Overview'.
     */
    public void clickTabOverview() {
        btOverview.clickAndWait();
    }

    /**
     * Check the activity tab 'Overview'.
     */
    public void assertTabOverviewActive() {
        Assert.assertEquals(true, btOverviewActive.isPresent());
    }

    /**
     * Check for is transmissionsList present on the page.
     * @return Is transmissionsList present
     * or
     * @return null
     */
    public List<String> getTransmissions() {
        return transmissionsList.isPresent() ? transmissionsList.getLiList() : null;
    }

    /**
     * Check for is enginesList present on the page.
     * @return Is enginesList present
     * or
     * @return null
     */
    public List<String> getEngines() {
        return enginesList.isPresent() ? enginesList.getLiList() : null;
    }
}
