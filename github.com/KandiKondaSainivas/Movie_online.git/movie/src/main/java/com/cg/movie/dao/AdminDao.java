package com.cg.movie.dao;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminDao {

	public Theater addTheater(Theater theater) throws MovieException;

	public boolean deleteTheater(int theaterId) throws MovieException;
}
