package webdriver.elements;

import org.openqa.selenium.By;

/**
 * Class, Describing element button
 */
public class Button extends BaseElement {

    /**
     * Constructor
     * @param locator locator
     * @param name name
     */
    public Button(final By locator, final String name) {
        super(locator, name);
    }

    /**
     * Constructor
     * @param string locator
     * @param name name
     */
    public Button(String string, String name) {
    	 super(string, name);
	}

    /**
     * Returns Element type
     * @return Element type
     */
	protected String getElementType() {
        return getLoc("loc.button");
    }

    /**
     * Constructor
     * @param locator locator
     */
	public Button(By locator) {
		super(locator);
	}

}
