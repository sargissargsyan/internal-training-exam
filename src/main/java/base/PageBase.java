package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.DriverHelper;

import java.util.List;

/**
 * @author Sargis Sargsyan on 6/7/21
 * @project internal-training-exam
 */
public abstract class PageBase<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private static final Logger LOGGER = Logger.getLogger("BasePage");
    protected WebDriver driver;
    protected static final String BASE_URL = System.getProperty("selenium.url", "https://tree.taiga.io/");

    public PageBase() {
        this.driver = DriverHelper.get().getDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract String getUrl();

    public void type(WebElement element, String text) {
        LOGGER.info("Typing " + text + " to element with location: " + element.toString());
        element.sendKeys(text);
    }
    public String getCurrentUrl() {
        LOGGER.info("Getting current url");
        return driver.getCurrentUrl();
    }

    public void type(By location, String text) {
        type(find(location), text);
    }

    public void type(String cssSelector, String text) {
        type(By.cssSelector(cssSelector), text);
    }

    public WebElement find(By location) {
        return driver.findElement(location);
    }

    public List<WebElement> findAll(By location) {
        return driver.findElements(location);
    }

    public void click(WebElement element) {
        LOGGER.info("Clicking on element with location:" + element.toString());
        element.click();
    }

    public void click(By location) {
        click(find(location));
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDisplayed(By location) {
        try {
            return find(location).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Actions getActions() {
        return new Actions(driver);
    }

}

