import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class CoreShell extends Core {
    public static TestActions actions;
    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void setupBrowser(String browser, String website) {
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("start-maximized");
            options.addArguments("disable-popup-blocking");
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver(options);
        }
        driver.get(website);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();
        elementsPage = new ElementsPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new TestActions();
        builder = new Actions(driver);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /*@BeforeMethod(alwaysRun = true)
    @Parameters({"UserName", "Password"})
    public void testLogIn(String name, String nos) {
        actions.LogIn(name, nos);
    }

    @AfterMethod
    public void testLogOut() {
        actions.LogOut();
    }
*/
}

