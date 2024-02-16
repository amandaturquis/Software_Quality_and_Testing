package RecipeTest;

import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RecipeTest {
    private Recipe recipe;

    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void testSetAmtChocolate() {
        // Test setting valid chocolate units
        try {
            recipe.setAmtChocolate("3");
            assertEquals(3, recipe.getAmtChocolate());
        } catch (RecipeException e) {
            fail("Unexpected RecipeException");
        }

        // Test setting invalid chocolate units
        try {
            recipe.setAmtChocolate("-3");
            fail("Expected RecipeException");
        } catch (RecipeException e) {
            assertEquals("Units of chocolate must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void testSetName() {
        // Test setting a valid recipe name
        recipe.setName("ChocolateCoffee");
        assertEquals("ChocolateCoffee", recipe.getName());

        // Test setting a null recipe name
        recipe.setName(null);
        assertNull(recipe.getName());
    }

    @Test
    public void testSetPrice() {
        // Test setting a valid price
        try {
            recipe.setPrice("5");
            assertEquals(5, recipe.getPrice());
        } catch (RecipeException e) {
            fail("Unexpected RecipeException");
        }

        // Test setting an invalid price
        try {
            recipe.setPrice("-5");
            fail("Expected RecipeException");
        } catch (RecipeException e) {
            assertEquals("Price must be a positive integer", e.getMessage());
        }
    }

}
