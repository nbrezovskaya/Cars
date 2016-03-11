package demo.test.forms;

import demo.test.model.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Table;

import java.util.List;

/**
 * Class Compare cars page
 */
public class CompareCarsPage extends BaseForm {
    private Table compareTable = new Table(By.xpath("//table[@id='vehicleCompare']"), "Compare Table");

    public CompareCarsPage() {
        super(By.xpath(".//*[@id='search']/h1"), "Compare");
    }

    /**
     * Receives and compares data transmission and engine at the two selected cars.
     * @param car1
     * @param car2
     */
    public void compareCars(Car car1, Car car2) {
        String[] engines1 = compareTable.getColumnOfRowWithCell(CompareRow.ENGINES.getName(), 2).split("\n");
        String[] engines2 = compareTable.getColumnOfRowWithCell(CompareRow.ENGINES.getName(), 3).split("\n");
        String[] transmissions1 = compareTable.getColumnOfRowWithCell(CompareRow.TRANSMISSIONS.getName(), 2).split("\n");
        String[] transmissions2 = compareTable.getColumnOfRowWithCell(CompareRow.TRANSMISSIONS.getName(), 3).split("\n");
        compareCarAndList(car1.getEngines(), engines1);
        compareCarAndList(car2.getEngines(), engines2);
        compareCarAndList(car1.getTransmissions(), transmissions1);
        compareCarAndList(car2.getTransmissions(), transmissions2);
    }

    /**
     * Compares list of parameters.
     * @param carList
     * @param compareList
     */
    private void compareCarAndList(List<String> carList, String[] compareList) {
        Assert.assertEquals(compareList.length, carList.size());
        for (int i = 0; i < carList.size(); i++) {
            Assert.assertEquals(compareList[i], format(carList.get(i)));
        }
    }
    /**
     * Format string.
     * @param string
     * @return string
     */
    public String format(String string) {
        return string.replaceAll("manual", "man").replaceAll("speed", "spd").replaceAll(",", "");
    }
}
