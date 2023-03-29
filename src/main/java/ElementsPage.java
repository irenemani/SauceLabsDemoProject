import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementsPage extends Core {

    private String text_UserNameXpath = "//input[@id='user-name']";
    private String text_PasswordId = "password";
    private String button_submitId = "login-button";
    private String page_HomepageId = "inventory_container";
    private String ItemsList_HomePageXpath = "//div[@class='inventory_item_name']";
    private String button_BikeLight_AddToCartXpath = "//button[@name='add-to-cart-sauce-labs-bike-light']";
    private String button_OneSie_AddToCartXpath = "//button[@name='add-to-cart-sauce-labs-onesie']";
    private String icon_ShoppingCart = "shopping_cart_link";
    private String cart_ItemsList = "//div[@class='cart_list']";
    private String cart_ItemBikeLightId = "item_0_title_link";
    private String cart_ItemOnesie = "item_2_title_link";
    private String button_ContinueShoppingId = "continue-shopping";
    private String button_LogOut_MenuClass = "bm-burger-button";
    private String label_LogOut_Xpath = "//a[@id='logout_sidebar_link']";
    private String label_ItemPriceXpath = "//div[@class='inventory_item_price']";
    private String label_InventoryItemsXpath = "//div[@class='inventory_item_name']";

    public List<WebElement> labelInventoryItemsXpath() {
        return driver.findElements(By.xpath(label_InventoryItemsXpath));
    }

    public List<WebElement> labelItemPriceXpath() {
        return driver.findElements(By.xpath(label_ItemPriceXpath));
    }

    public WebElement labelLogOut() {
        return driver.findElement(By.xpath(label_LogOut_Xpath));
    }

    public WebElement button_LogOut_MenuClass() {
        return driver.findElement(By.className(button_LogOut_MenuClass));
    }

    public WebElement buttonContinueShoppingId() {
        return driver.findElement(By.id(button_ContinueShoppingId));
    }

    public List<WebElement> cartItemsList() {
        return driver.findElements(By.xpath(cart_ItemsList));
    }

    public WebElement cartItemBikeLightId() {
        return driver.findElement(By.id(cart_ItemBikeLightId));
    }

    public WebElement cartItemOnesie() {
        return driver.findElement(By.id(cart_ItemOnesie));
    }

    public WebElement textUserNameXpath() {
        return driver.findElement(By.xpath(text_UserNameXpath));
    }

    public WebElement textPasswordId() {
        return driver.findElement(By.id(text_PasswordId));
    }

    public WebElement buttonSubmitId() {
        return driver.findElement(By.id(button_submitId));
    }

    public WebElement pageHomepageID() {
        return driver.findElement(By.id(page_HomepageId));
    }

    public List<WebElement> ItemsListHomePageXpath() {
        return driver.findElements(By.xpath(ItemsList_HomePageXpath));
    }

    public WebElement buttonBikeLightAddToCartXpath() {
        return driver.findElement(By.xpath(button_BikeLight_AddToCartXpath));
    }

    public WebElement buttonOneSieAddToCartXpath() {
        return driver.findElement(By.xpath(button_OneSie_AddToCartXpath));
    }

    public WebElement iconShoppingCart() {
        return driver.findElement(By.className(icon_ShoppingCart));
    }

}

