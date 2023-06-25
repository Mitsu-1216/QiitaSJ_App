package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterLogic;
import model.TodoBeans;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		List<TodoBeans> todoList = (List<TodoBeans>) application.getAttribute("todoList");

		if (todoList == null) {
			todoList = new ArrayList<>();
			application.setAttribute("todoList", todoList);
		}
		
		String name = request.getParameter("name");
		

		HttpSession session = request.getSession();
		session.setAttribute("name",name);
		
		if (name == null || name =="") {
			response.sendRedirect("/sampleSJ/");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String text = request.getParameter("text");
        
		if(text != null && text.length() != 0) {

			ServletContext application = this.getServletContext();
			List<TodoBeans> todoList = (List<TodoBeans>) application.getAttribute("todoList");

			HttpSession session = request.getSession();
			String name =  (String) session.getAttribute("name");

			TodoBeans todo = new TodoBeans(name,text,date);
			RegisterLogic registerTodo = new RegisterLogic();
			registerTodo.execute(todo, todoList);

			application.setAttribute("todoList", todoList);
		} else {
			request.setAttribute("errorMsg","タスクが入力されていません");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp");
		dispatcher.forward(request, response);
	}

}
