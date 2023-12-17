package com.example.shoppingonline.DAO.AdminDAO;

import com.example.shoppingonline.Model.User.Admin;

public interface AdminDAO {

	boolean deleteAdmin(int adminId);
	boolean editAdmin(int adminId, Admin admin);
	Admin addAdmin(Admin admin);

}