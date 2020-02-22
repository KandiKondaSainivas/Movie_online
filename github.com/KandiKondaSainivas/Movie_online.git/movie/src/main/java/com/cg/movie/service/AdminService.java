package com.cg.movie.service;

import com.cg.movie.bean.Theater;
import com.cg.movie.exception.MovieException;

public interface AdminService {
	public Theater addTheater(Theater theater) throws MovieException;

	public boolean deleteTheater(int theaterId) throws MovieException;

	public boolean validateTheaterId(int theaterId) throws MovieException;

	public boolean validateName(String name) throws MovieException;

	public boolean validateContact(String number) throws MovieException;
}
