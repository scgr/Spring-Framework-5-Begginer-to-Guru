package guru.springframework.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryTest {

	Category category;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		category = new Category();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetId() {
		Long identifier = 4L;

		category.setId(identifier);

		assertEquals(identifier, category.getId());
	}

	@Test
	public void testGetDescription() {
		String description = "Test description";

		category.setDescription(description);

		assertEquals(description, category.getDescription());
	}

	@Test
	public void testGetRecipes() {
		Set<Recipe> recipes = new HashSet<>();

		category.setRecipes(recipes);

		assertNotNull(category.getRecipes());
	}

}
