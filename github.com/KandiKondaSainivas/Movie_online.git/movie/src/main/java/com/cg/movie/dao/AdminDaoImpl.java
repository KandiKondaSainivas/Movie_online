package com.cg.movie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.cg.movie.bean.Movie;
import com.cg.movie.bean.Screen;
import com.cg.movie.bean.Show;
import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public class AdminDaoImpl implements AdminDao {
	Map<Integer, Theater> map = new HashMap<Integer, Theater>();

	@Override
	public Theater addTheater(Theater theater) throws MovieException {

		boolean flag = map.containsKey(theater.getTheaterId());
		if (flag) {
			throw new MovieException("Id already exists");
		}
		map.put(theater.getTheaterId(), theater);
		return theater;
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {
		boolean flag = map.containsKey(theaterId);
		if (flag) {
			map.remove(theaterId);
			return flag;
		} else {
			throw new MovieException(theaterId + " Theater Id is not found");
		}

	}

}
