package com.spring.springform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "inputform.bo")
	public String home(Model model) { // 파라미터 내부 객체는 따로 선언하지 않아도 스프링이 내부적으로 생성

		return "forminput";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	/*
	 * @RequestMapping(value = "inputprocess.bo", method = RequestMethod.POST)
	 * public String processform(ServletRequest request, Model model) { String
	 * id = request.getParameter("id"); String pw = request.getParameter("pw");
	 * 
	 * model.addAttribute("id", id); model.addAttribute("pw", pw);
	 * 
	 * 
	 * return "resultform"; }
	 */

	@RequestMapping(value = "inputprocess.bo")
	public ModelAndView processform(ServletRequest request, Model model) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		ModelAndView mv = new ModelAndView();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			pstmt = con.prepareStatement("select ename from emp order by ename asc");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String ename = rs.getString("ename");
				list.add(ename);

			}
			mv.setViewName("resultform");
			mv.addObject("list", list);

		} catch (Exception e) {
			System.out.println("DB연결 실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return mv;
	}

}
