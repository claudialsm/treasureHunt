package com.lesson.treasureHunt;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("general tests")
public class AppTest {

	@Test
	@DisplayName("Values don't match")
	void notEquals() {
		assertNotEquals(10, 20);
	}

}