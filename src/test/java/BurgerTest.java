import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredient2;

    @Mock
    Bun bun;

    @Test
    public void addIngredientCountOfIngredientsIsCorrect() {
        //создать бургер
        Burger burger = new Burger();
        burger.setBuns(bun);
        // добавить ингредиенты, проверить х кол-во
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Assert.assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredientCountOfIngredientsIsCorrect() {
        //создать бургер
        Burger burger = new Burger();
        burger.setBuns(bun);
//        добавить ингредиенты
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        // удалить ингридиент
        burger.removeIngredient(1);
        //проверить кол-во
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientCompoundOfIngredientsIsCorrect() {
        //создать бургер
        Burger burger = new Burger();
        burger.setBuns(bun);
//        добавить ингредиенты
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        // передвинуть ингридиент
        burger.moveIngredient(0, 1);
        //проверить порядок
        Assert.assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void setBunShouldContainsBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }


    @Test
    public void getPriceReturnTruePrice() {
        Mockito.when(bun.getPrice()).thenReturn(ApiConstants.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(ApiConstants.INGREDIENT_PRICE);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(ApiConstants.EXPECTED_FINAL_PRICE, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptShouldBeCorrect() {
        Mockito.when(bun.getName()).thenReturn(ApiConstants.BUN_NAME);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(ApiConstants.INGREDIENT_NAME);
        Mockito.when(bun.getPrice()).thenReturn(ApiConstants.BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(ApiConstants.INGREDIENT_PRICE);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(ApiConstants.EXPECTED_FINAL_RECEIPT, burger.getReceipt());
    }
}
