package sogong_project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentManagerTest {
	
	StudentManager manager;

	@BeforeEach
	void setUp() throws Exception {
		manager = new StudentManager();
	}

	
	@Test
	void testAddStudent() {
		manager.addStudent("Kim");
		assertTrue(manager.hasStudent("Kim"));
	}

	@Test
	void testRemoveStudent() {
		manager.addStudent("Park");
		manager.removeStudent("Park");
		assertFalse(manager.hasStudent("Park"));
	}

	@Test
	void testAddDupStudent() {
		manager.addStudent("Jung");
		assertThrows(IllegalArgumentException.class, () -> manager.addStudent("Jung"));
	}
	
	@Test
	void testRemoveNonexistStudent() {
		assertThrows(IllegalArgumentException.class, () -> manager.removeStudent("Lee"));
	}

}