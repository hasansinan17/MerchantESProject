package com.task.bases;

import com.task.page.DashboardPageElements;
import com.task.page.NewUserPageElements;
import com.task.page.UsersPageElements;

public class PageInitiliazer extends BaseClass{
	
	protected static DashboardPageElements dash;
	protected static NewUserPageElements newUser;
	protected static UsersPageElements user;
	
	public static void initializeAllPage() {
		
		dash=new DashboardPageElements();
		newUser=new  NewUserPageElements();
		user=new UsersPageElements(); 
		
	}

}
