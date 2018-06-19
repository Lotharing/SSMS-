package top.lothar.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import net.sf.json.JSONObject;
import top.lothar.bean.Clazz;
import top.lothar.bean.Exam;
import top.lothar.bean.Grade;
import top.lothar.bean.Page;
import top.lothar.bean.Student;
import top.lothar.bean.Teacher;
import top.lothar.service.ExamService;
import top.lothar.service.ScoreService;
import top.lothar.service.StudentService;
import top.lothar.service.TeacherService;
import top.lothar.tools.StringTool;

/**
 * 成绩类Servlet
 * @author Lothar
 *
 */
public class ScoreServlet extends HttpServlet {
	
	//创建服务层对象
	private ScoreService service = new ScoreService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的方法
		String method = request.getParameter("method");
		//请求分发
		if("ExportScore".equalsIgnoreCase(method)){ //导出成绩
			exportScore(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求的方法
		String method = request.getParameter("method");
		//请求分发
		if("ScoreList".equalsIgnoreCase(method)){ //获取所有成绩数据
			scoreList(request, response);
		} else if("ColumnList".equalsIgnoreCase(method)){ //获取列
			columnList(request, response);
		} else if("SetScore".equalsIgnoreCase(method)){ //登记成绩
			setScore(request, response);
		} 
		
		
		
	}
	
	private void setScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String[] score = request.getParameterValues("score[]");
		
		service.setScore(score);
		//返回数据
        response.getWriter().write("success");
	}
	
	private void exportScore(HttpServletRequest request, HttpServletResponse response) {
		//获取分页参数
		Enumeration<String> pNames = request.getParameterNames();
		Exam exam = new Exam();
		while(pNames.hasMoreElements()){
			String pName = pNames.nextElement();
			String value = request.getParameter(pName);
			try {
				BeanUtils.setProperty(exam, pName, value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		service.exportScore(response, exam);
	}
	
	private void columnList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Enumeration<String> pNames = request.getParameterNames();
		Exam exam = new Exam();
		while(pNames.hasMoreElements()){
			String pName = pNames.nextElement();
			String value = request.getParameter(pName);
			try {
				BeanUtils.setProperty(exam, pName, value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		//获取数据
		String result = service.columnList(exam);
		//返回数据
        response.getWriter().write(result);
	}
	
	private void scoreList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Enumeration<String> pNames = request.getParameterNames();
		Exam exam = new Exam();
		while(pNames.hasMoreElements()){
			String pName = pNames.nextElement();
			String value = request.getParameter(pName);
			try {
				BeanUtils.setProperty(exam, pName, value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		//获取数据
		String result = service.getScoreList(exam);
		//返回数据
        response.getWriter().write(result);
	}
	
}
