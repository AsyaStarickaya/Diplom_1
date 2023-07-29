import org.junit.Test;
import org.mockito.Mock;
import praktikum.ApiConstants;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngridientTest {
    @Mock
    IngredientType ingredientType;
    Ingredient ingredient = new Ingredient(ingredientType, ApiConstants.INGREDIENT_NAME, ApiConstants.INGREDIENT_PRICE);

    @Test
    public void getNameTest() {
        assertEquals(ApiConstants.INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(ApiConstants.INGREDIENT_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientType(){
        assertEquals(ingredientType, ingredient.getType());
    }

}
