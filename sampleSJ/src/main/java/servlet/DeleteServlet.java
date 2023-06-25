package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TodoBeans;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		ServletContext application = this.getServletContext();
		List<TodoBeans> todoList = (List<TodoBeans>) application.getAttribute("todoList");

		// taskを検索
		int listIndex = 0;
		for (int i = 0; i < todoList.size(); i++) {
			if (todoList.get(i).getText().equals(text))
				listIndex = i;
		}
		// アプリケーションスコープからタスクを削除
		todoList.remove(listIndex);
		application.setAttribute("todoList", todoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp");
		dispatcher.forward(request, response);
	}

}
