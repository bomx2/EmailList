package com.sds.icto.emaillist.test;

import java.util.List;

import com.sds.icto.emaillist.dao.EmailListDAO;
import com.sds.icto.emaillist.vo.EmailListVO;

public class TESTEmailListDAO {

	public static void main(String[] args) {
		try {
			//0.  deleteTest
			testDelete();
			//1.insert TEST
			testInsert();
			//2.fetch TEST
			testFetchList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testDelete() throws Exception{
			EmailListDAO dao = new EmailListDAO();
			dao.delete();
	}
	
	public static void testFetchList() throws Exception{
		EmailListDAO dao = new EmailListDAO();
		List<EmailListVO> list = dao.fetchList();
		
		for (EmailListVO vo : list) {
			System.out.print(vo.getNo() + " : ");
			System.out.print(vo.getFirstname()+ " : ");
			System.out.print(vo.getLastname()+ " : ");
			System.out.print(vo.getEmail());
			System.out.print("\n");
		}
	}
	
	public static void testInsert() throws Exception{
		EmailListVO vo = new EmailListVO();
		vo.setFirstname("홍");
		vo.setLastname("길동");
		vo.setEmail("hong@sds.com");
		
		EmailListDAO dao = new EmailListDAO();
		dao.insert(vo);
	}

}
