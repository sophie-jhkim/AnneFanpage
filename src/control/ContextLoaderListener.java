package control;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;


@WebListener
public class ContextLoaderListener implements ServletContextListener {
	static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext(); // 서버를 켜자마자 반드시 호출된다. 이제 여기에 모든 것들을 준비해둘 예정
//			InitialContext initialContext = new InitialContext();
//			DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/oracle");
//			MySqlMemberDao memberDao = new MySqlMemberDao();
//			memberDao.setDataSource(ds);

//			sc.setAttribute("/member/login.do", new LogInController().setMemberDao(memberDao));
//		sc.setAttribute("/auth/logout.do", new LogOutController());
//			sc.setAttribute("/member/list.do", new MemberListController().setMemberDao(memberDao));
//		sc.setAttribute("/member/add.do", new MemberAddController().setMemberDao(memberDao));
//		sc.setAttribute("/member/update.do", new MemberUpdateController().setMemberDao(memberDao));
//		sc.setAttribute("/member/delete.do", new MemberDeleteController().setMemberDao(memberDao));
//			System.out.println(sc.getAttribute("/member/login.do"));

			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocaiton"));
			applicationContext = new ApplicationContext(propertiesPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

}
