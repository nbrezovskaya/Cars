package demo.test.menus;


import org.openqa.selenium.By;
import webdriver.BaseEntity;
import webdriver.elements.Button;

/**
 * Class Main menu
 */
public class MainMenu extends BaseEntity {

    /**
     * Passes through the menu tabs.
     * @param menu menu
     * @param subMenu subMenu
     */
    public void navigateTo(Menu menu, Menu subMenu) {
        logStep("----------------------------------------------");
        Button menuButton = new Button(By.xpath(String.format("//span[text()='%s']", menu.getName())), menu.getName());
        logStep("++++++++++++++++++++++++++++++++++++++++++++++");
        Button subMenuButton = new Button(By.xpath(String.format("//li[a[contains(text(), '%s')]]", subMenu.getName())), subMenu.getName());
        logStep("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        menuButton.click();
        logStep("##############################################");
        subMenuButton.clickAndWait();
        logStep("______________________________________________");
    }

    /**
     * For logs
     * @param message Message
     * @return null
     */
    @Override
    protected String formatLogMsg(String message) {
        return null;
    }
}
