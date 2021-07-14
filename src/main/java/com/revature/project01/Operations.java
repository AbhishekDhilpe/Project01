package com.revature.project01;

import org.hibernate.Session;

import com.revature.project01.tools.HibernateUtil;

public class Operations {
	
	public static String hello() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return "session started";
	}
}
