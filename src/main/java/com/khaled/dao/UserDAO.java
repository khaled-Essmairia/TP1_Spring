package com.khaled.dao;

 

import javax.sql.DataSource; 
import com.khaled.models.User;

public interface UserDAO {
 
	void register(User user); 
	public void setDataSource(DataSource dataSource);
}
