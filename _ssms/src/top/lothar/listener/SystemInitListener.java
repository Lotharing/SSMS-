package top.lothar.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import top.lothar.bean.SystemInfo;
import top.lothar.dao.impl.BaseDaoImpl;

/**
 * 系统初始化
 * @author Lothar
 *
 */
public class SystemInitListener implements ServletContextListener {

    public SystemInitListener() {
    	
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
    	//获取系统初始化对象
    	SystemInfo sys = (SystemInfo) new BaseDaoImpl().getObject(SystemInfo.class, "SELECT * FROM system", null);
    	//放到域中
    	application.setAttribute("systemInfo", sys);
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }
	
}
