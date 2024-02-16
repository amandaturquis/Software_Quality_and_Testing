package CoffeeMakerTest;

import edu.ncsu.csc326.coffeemaker.CoffeeMaker;
import edu.ncsu.csc326.coffeemaker.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    public void AddRecipe() {
        // Test adding a valid recipe
        Recipe recipe = new Recipe();
        recipe.setName("TestRecipe");
        assertTrue(coffeeMaker.addRecipe(recipe));

        // Test adding a duplicate recipe
        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void DeleteRecipe() {
        // Test deleting an existing recipe
        Recipe recipe = new Recipe();
        recipe.setName("TestRecipe");
        coffeeMaker.addRecipe(recipe);
        assertEquals("TestRecipe", coffeeMaker.deleteRecipe(0));

        // Test deleting a non-existing recipe
        assertNull(coffeeMaker.deleteRecipe(0));
    }

    @Test
    public void EditRecipe() {
        // Test editing an existing recipe
        Recipe originalRecipe = new Recipe();
        originalRecipe.setName("OriginalRecipe");
        coffeeMaker.addRecipe(originalRecipe);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("EditedRecipe");
        assertEquals("OriginalRecipe", coffeeMaker.editRecipe(0, newRecipe));

        // Test editing a non-existing recipe
        assertNull(coffeeMaker.editRecipe(1, newRecipe));
    }
}