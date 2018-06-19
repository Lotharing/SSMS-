package top.lothar.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//jar文件
import org.apache.commons.fileupload.FileUploadException;
import top.lothar.bean.User;
import top.lothar.service.PhotoService;
import top.lothar.tools.StringTool;

/**
 * 上传照片Servlet
 * @author Lothar
 *
 */
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PhotoService service = new PhotoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的方法
		String method = request.getParameter("method");
		
		if("GetPhoto".equals(method)){ //设置照片
			getPhoto(request, response);
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的方法
		String method = request.getParameter("method");
		
		if("SetPhoto".equals(method)){ //设置照片
			setPhoto(request, response);
		} 
	}
	
	/**
	 * 获取教师和学生的照片
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();
		//获取number
		String number = request.getParameter("number");
		if(!StringTool.isEmpty(number)){
			int type = Integer.parseInt(request.getParameter("type"));
			user.setAccount(number);
			user.setType(type);
		} else{
			user = (User) request.getSession().getAttribute("user");
		}
		InputStream is = service.getPhoto(user);
		if(is != null){
			byte[] b = new byte[is.available()];
			is.read(b);
			response.getOutputStream().write(b, 0, b.length);
		}
	}
	
	/**
	 * 教师和学生设置照片
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void setPhoto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取学号或工号
		User user = (User) request.getSession().getAttribute("user");
		
		String msg = service.setPhoto(user, request);
		
		response.getWriter().write(msg);
	}

}
