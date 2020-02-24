package com.cg.movie.service;

import com.cg.movie.bean.Theater;
import com.cg.movie.dao.AdminDao;
import com.cg.movie.dao.AdminDaoImpl;
import com.cg.movie.exception.MovieException;

public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao;

	public AdminServiceImpl() {
		adminDao = new AdminDaoImpl();
	}

	@Override
	public Theater addTheater(Theater theater) throws MovieException {
		int id = theater.getTheaterId();
		boolean flag = validateTheaterId(id);

		if (flag == false) {

			throw new MovieException("Theater Id must be 4 digit starting with 2");
		}
		String name = theater.getTheaterName();
		boolean flag1 = validateName(name);

		if (flag1 == true) {
			throw new MovieException("Theater Name must be entered ");
		}

		String cname = theater.getTheaterCity();
		boolean flag12 = validateName(cname);

		if (flag12 == true) {
			throw new MovieException("City Name must be entered ");
		}

		String managername = theater.getManagerName();
		boolean flag2 = validateName(managername);

		if (flag2 == true) {
			throw new MovieException("Manager Name must be entered ");
		}
		String managercontact = theater.getManagerContact();
		boolean flag3 = validateContact(managercontact);

		if (flag3 == false) {
			throw new MovieException("Manager Contact Number must be 10 digits");
		}
		Theater theater1 = adminDao.addTheater(theater);

		return theater1;
	}

	@Override
	public boolean deleteTheater(int theaterId) throws MovieException {
		boolean flag = validateTheaterId(theaterId);

		if (flag == false) {

			throw new MovieException("Theater Id must be 4 digit starting with 2");
		}

		boolean flag1 = adminDao.deleteTheater(theaterId);

		return flag1;

	}

	@Override
	public boolean validateTheaterId(int theaterId) throws MovieException {
		boolean flag = false;

		if (theaterId == 0) {
			flag = false;
		} else {
			String s = Integer.toString(theaterId);
			flag = s.matches("(2)[0-9]{3}");

		}

		return flag;
	}

	@Override
	public boolean validateName(String name) throws MovieException {
		boolean flag = false;
		flag = name.isEmpty();

		if (flag) {
			flag = true;

		}

		return flag;
	}

	@Override
	public boolean validateContact(String number) throws MovieException {

		boolean flag = false;
		flag = number.matches("[0-9]{10}");

		return flag;
	}

}
