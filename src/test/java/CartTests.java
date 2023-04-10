
import org.testng.annotations.Test;

public class CartTests extends CoreShell {

    @Test (priority = 1)
    // To validate add to cart functionality.
    public void testAddToCart() {
        actions.AddToCart();
    }

    @Test (priority =2, groups = {"Sanity"})
    // To validate continue shopping functionality.
    public void testContinueShopping() {
        actions.ContinueShopping();
    }
}
