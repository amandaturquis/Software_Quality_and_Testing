package InventoryTest;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest {
    private Inventory inventory;

    @Before
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testAddCoffee() {
        // Test adding valid coffee units
        try {
            inventory.addCoffee("5");
            assertEquals(20, inventory.getCoffee());
        } catch (InventoryException e) {
            fail("Unexpected InventoryException");
        }

        // Test adding invalid coffee units
        try {
            inventory.addCoffee("-5");
            fail("Expected InventoryException");
        } catch (InventoryException e) {
            assertEquals("Units of coffee must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void testAddMilk() {
        // Test adding valid milk units
        try {
            inventory.addMilk("4");
            assertEquals(19, inventory.getMilk());
        } catch (InventoryException e) {
            fail("Unexpected InventoryException");
        }

        // Test adding invalid milk units
        try {
            inventory.addMilk("-4");
            fail("Expected InventoryException");
        } catch (InventoryException e) {
            assertEquals("Units of milk must be a positive integer", e.getMessage());
        }
    }

    @Test
    public void testUseIngredients() throws RecipeException {
        // Test using ingredients with enough inventory
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("3");
        recipe.setAmtSugar("1");
        recipe.setAmtChocolate("1");

        assertTrue(inventory.useIngredients(recipe));
        assertEquals(13, inventory.getCoffee());
        assertEquals(12, inventory.getMilk());
        assertEquals(14, inventory.getSugar());
        assertEquals(14, inventory.getChocolate());

        // Test using ingredients with insufficient inventory
        Recipe insufficientRecipe = new Recipe();
        insufficientRecipe.setAmtCoffee("20");
        insufficientRecipe.setAmtMilk("20");
        insufficientRecipe.setAmtSugar("20");
        insufficientRecipe.setAmtChocolate("20");

        assertFalse(inventory.useIngredients(insufficientRecipe));
        assertEquals(13, inventory.getCoffee());
        assertEquals(12, inventory.getMilk());
        assertEquals(14, inventory.getSugar());
        assertEquals(14, inventory.getChocolate());
    }
}