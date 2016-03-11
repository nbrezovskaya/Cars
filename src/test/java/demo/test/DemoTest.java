package demo.test;

import demo.test.forms.*;
import demo.test.menus.MainMenu;
import demo.test.menus.Menu;
import demo.test.model.Car;
import webdriver.BaseTest;
import webdriver.Browser;

public class DemoTest extends BaseTest {


    public void runTest() {

        logStep(1,"Open web-site");
        CarsMainPage cmp = new CarsMainPage();

        logStep(2,5);
        Car car1 = getCar();

        logStep(6);
        Car car2 = getCar(car1);

        logStep(7,"Transient on select cars to compare page");
        browser.navigate(Browser.getUrl());
        SelectComparePage scp = new SelectComparePage();


        logStep(8,"Choose cars for compare");
        scp.selectCars(car1, car2);

        logStep(9,"Compare options");
        scp.clickCompare();
        CompareCarsPage ccp = new CompareCarsPage();

        ccp.compareCars(car1, car2);

    }

    private Car getCar() {
        return getCar(null);
    }

    private Car getCar(Car exclude) {
        int maxTriesPerCarFeatures = Integer.parseInt(Browser.props.getProperty("maxTriesPerCarFeatures"));
        int triesMade = 0;
        Car car;
        do {
            logStep("Navigate to 'Buy' and chose 'Review a Car'");
            MainMenu mm = new MainMenu();
            mm.navigateTo(Menu.BUY, Menu.REVIEW_A_CAR);
            CarReviewsPage crp = new CarReviewsPage();

            logStep("Select random car");
            car = crp.selectRandomCar(exclude);
            DescriptionCarPage carPage = new DescriptionCarPage();

            logStep("Open 'Overview' tab and check its activity");
            carPage.clickTabOverview();
            carPage.assertTabOverviewActive();

            logStep("Find information on transmission and engine");
            car.setTransmissions(carPage.getTransmissions());
            car.setEngines(carPage.getEngines());
        } while (car.getTransmissions() == null && car.getEngines() == null && ++triesMade < maxTriesPerCarFeatures);
        return car;
    }
}
