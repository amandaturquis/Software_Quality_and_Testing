package RecipeBookTest;

import edu.ncsu.csc326.coffeemaker.Recipe;
import edu.ncsu.csc326.coffeemaker.RecipeBook;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RecipeBookTest {
    private RecipeBook recipeBook;

    @Before
    public void setUp() {
        recipeBook = new RecipeBook();
    }

    @Test
    public void testAddRecipe() {
        // Test adding a valid recipe
        Recipe recipe = new Recipe();
        recipe.setName("TestRecipe");
        assertTrue(recipeBook.addRecipe(recipe));

        // Test adding a duplicate recipe
        assertFalse(recipeBook.addRecipe(recipe));
    }

    @Test
    public void testDeleteNonExistingRecipe() {
        // Test deleting a non-existing recipe
        assertNull(recipeBook.deleteRecipe(0));
    }

    @Test
    public void testEditNonExistingRecipe() {
        // Test editing a non-existing recipe
        Recipe newRecipe = new Recipe();
        newRecipe.setName("EditedRecipe");
        assertNull(recipeBook.editRecipe(0, newRecipe));
    }

    @Test
    public void testAddMaxRecipes() {
        // Test adding the maximum number of recipes
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        Recipe recipe3 = new Recipe();
        Recipe recipe4 = new Recipe();
        Recipe recipe5 = new Recipe();

        assertTrue(recipeBook.addRecipe(recipe1));
        assertTrue(recipeBook.addRecipe(recipe2));
        assertTrue(recipeBook.addRecipe(recipe3));
        assertTrue(recipeBook.addRecipe(recipe4));
        assertFalse(recipeBook.addRecipe(recipe5)); // Cannot add more than 4 recipes
    }

}
