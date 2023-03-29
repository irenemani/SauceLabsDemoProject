
import org.testng.annotations.Test;

public class CartTests extends CoreShell {

    @Test (priority = 1, groups = {"Sanity"})
    // To validate add to cart functionality.
    public void testAddToCart() {
        actions.AddToCart();
    }

    @Test (priority =2)
    // To validate continue shopping functionality.
    public void testContinueShopping() {
        actions.ContinueShopping();
    }
}
