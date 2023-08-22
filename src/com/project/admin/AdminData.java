package com.project.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class AdminData {

	public static ArrayList<Admin> adminList; 
		
	static {
		adminList = new ArrayList<Admin>();
	}

	public static ArrayList<Admin> getAdminList() {
		return adminList;
	}
	
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\dataAdmin.txt"));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Admin a = new Admin(temp[0],
											temp[1],
											temp[2],
											temp[3],
											temp[4],
											temp[5],
											temp[6]);
				
				AdminData.adminList.add(a);
				
			}
		
			reader.close();
			
		} catch (Exception e) {
			System.out.println("at AdminData.load");
			e.printStackTrace();
		}
		
	}
	
	public static void update() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\dataAdmin.txt"));
			
			for (Admin a : AdminData.adminList) {
				
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s\r\n"
											, a.getAdminNo()
											, a.getAdminId()
											, a.getAdminPwd()
											, a.getAdminName()
											, a.getAdminPhone()
											, a.getAdminbirth()
											, a.getAdminDelete()));
				
			}
			
			writer.close();
			
		} catch (Exception e) {
			System.out.println("at AdminData.update");
			e.printStackTrace();
		}
		
	}

	
}