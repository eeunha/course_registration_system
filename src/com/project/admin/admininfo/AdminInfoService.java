package com.project.admin.admininfo;

import com.project.admin.AdminData;
import com.project.admin.Admin;

public class AdminInfoService {

	public static void check() {
		
		AdminData.load();
		
		String id = "qjweirowe142";
		
		for (Admin a : AdminData.adminList) {
			if (a.getAdminId().equals(id)) {
				System.out.printf("이름: %s\n아이디: %s\n전화번호: %s\n", a.getAdminName(), a.getAdminId(), a.getAdminPhone());
				break;
			}
		}
		
	}
	
}