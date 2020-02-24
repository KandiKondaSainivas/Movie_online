package com.cg.movie.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

class MovieTesting {

	AdminDao adminDao;
	Theater theater;

	@BeforeEach
	public void setup() {
		adminDao = new AdminDaoImpl();
	}

	@Test
	public void testAddTheater() throws MovieException {
		theater = new Theater(2134, "shiva", "hyderbad", null, null, "rahul", "9876543210");

		Theater theater1 = adminDao.addTheater(theater);

		assertEquals(2134, theater1.getTheaterId());

	}

	@Test
	public void testAddTheaterException() throws MovieException {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");

		adminDao.addTheater(theater);

		assertThrows(MovieException.class, () -> adminDao.addTheater(theater));

	}

	@Test
	public void testDeleteTheater() throws MovieException {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		adminDao.addTheater(theater);
		boolean flag = adminDao.deleteTheater(2134);

		assertTrue(flag);
	}

	@Test
	public void testDeleteTheaterException() throws MovieException {
		theater = new Theater(2134, "shiva", "hyderabad", null, null, "rahul", "9876543210");
		adminDao.addTheater(theater);
		assertThrows(MovieException.class, () -> adminDao.deleteTheater(2234));
	}
}