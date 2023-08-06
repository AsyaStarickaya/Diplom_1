import org.junit.*;
import praktikum.ApiConstants;
import praktikum.Bun;


import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun(ApiConstants.BUN_NAME, ApiConstants.BUN_PRICE);

    @Test
    public void getNameTest() {
        assertEquals(ApiConstants.BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(ApiConstants.BUN_PRICE, bun.getPrice(), 0);
    }
}
