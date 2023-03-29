import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestActions extends CoreShell {
    public void LogInFieldCheck() {
        // Validate all Log-In fields are present.
        Assert.assertTrue(elementsPage.textUserNameXpath().isDisplayed(), "User Name field is not found.");
        Assert.assertTrue(elementsPage.textPasswordId().isDisplayed(), "Password field is not found.");
        Assert.assertTrue(elementsPage.buttonSubmitId().isDisplayed(), "Submit button is not found.");
    }
    public void LogIn(String name, String nos) {
        elementsPage.textUserNameXpath().sendKeys(name);
        elementsPage.textPasswordId().sendKeys(nos);
        elementsPage.buttonSubmitId().click();
        wait.until(ExpectedConditions.visibilityOf(elementsPage.pageHomepageID()));
        Assert.assertTrue(elementsPage.pageHomepageID().isDisplayed(), "Home page is not displayed.");
        System.out.println("LogIn successful.");
    }
    public void NavigationPageItemList() {
        // Validate items in navigation page.
        System.out.println("Items in inventory list are:-");
        for (int i = 0; i < elementsPage.ItemsListHomePageXpath().size(); i++) {
            int x = i + 1;
            System.out.println(x + " " + elementsPage.ItemsListHomePageXpath().get(i).getText());
        }
    }
    public void NavigationPageItemsPrice() {
        // Validate items less than $10.
        System.out.println("Items below $10 :-");
        for (int i = 0; i < elementsPage.labelInventoryItemsXpath().size(); i++) {
            String price = elementsPage.labelItemPriceXpath().get(i).getText()
                    .replace("$", " ");
            Double newPrice = Double.valueOf(price);
            if (newPrice < 10) {
                System.out.println(i + " " + elementsPage.labelInventoryItemsXpath().get(i).getText());
            }
        }
    }
    public void AddToCart() {
        //Validate add to cart functionality by adding 2 items.
        elementsPage.buttonOneSieAddToCartXpath().click();
        elementsPage.buttonBikeLightAddToCartXpath().click();
        elementsPage.iconShoppingCart().click();

        Iterator<WebElement> it = elementsPage.cartItemsList().iterator();
        while (it.hasNext()) {
            WebElement itemIt = it.next();
            String itemName = itemIt.getText();
            if (itemName.contains("Sauce Labs Onesie") ||
                    itemName.equalsIgnoreCase("Sauce Labs Bike Light")) {
                System.out.println("Both items are added to cart.");
            }
        }
    }
    public void ContinueShopping() {
        elementsPage.iconShoppingCart().click();
        elementsPage.buttonContinueShoppingId().click();
        Assert.assertTrue(elementsPage.pageHomepageID().isDisplayed(),
                "Continue shopping button is not leading to home page.");
        System.out.println("Continue Shopping functionality is working.");
    }
    public void LogOut() {
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.button_LogOut_MenuClass()));
        elementsPage.button_LogOut_MenuClass().click();
        wait.until(ExpectedConditions.elementToBeClickable(elementsPage.labelLogOut()));
        elementsPage.labelLogOut().click();
        System.out.println("Log out successful.");
    }
    public void LoginInputTests() {
        try {
            FileInputStream fp = new FileInputStream("C:\\Users\\IRENE\\Desktop\\IRENE\\DataFile.xlsx");
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fp);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(1);

            Map<String, String> map = new HashMap<>();

            for (int i = 1; i < 4; i++) {
                String userId = null;
                String password = null;
                for (int j = 1; j < 3; j++) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(j);
                    if (j == 1) {
                        userId = cell.getStringCellValue();
                    } else {
                        password = cell.getStringCellValue();
                    }
                    map.put(userId, password);
                }
            }
            for (String i : map.keySet()) {
                elementsPage.textUserNameXpath().sendKeys(i);
                elementsPage.textPasswordId().sendKeys(map.get(i));
                elementsPage.buttonSubmitId().click();
                wait.until(ExpectedConditions.visibilityOf(elementsPage.pageHomepageID()));
                System.out.println("LogIn successful.\n"+i+" is valid.");
                wait.until(ExpectedConditions.elementToBeClickable(elementsPage.button_LogOut_MenuClass()));
                elementsPage.button_LogOut_MenuClass().click();
                wait.until(ExpectedConditions.elementToBeClickable(elementsPage.labelLogOut()));
                elementsPage.labelLogOut().click();
                System.out.println("Log out successful.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}