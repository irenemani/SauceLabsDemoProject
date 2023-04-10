import org.testng.annotations.*;

public class HomePageTests extends CoreShell {

    @Test(priority = 1, groups = {"Sanity"})
    // To validate items in navigation page.
    public void testItemList() {
        actions.NavigationPageItemList();
    }
    @Test (priority=2, groups = {"Sanity"})
    // To validate items below $10.
    public void testCheckItemPrice() {
        actions.NavigationPageItemsPrice();
    }



}


