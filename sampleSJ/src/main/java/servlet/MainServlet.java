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
		
        // リクエストパラメータの取得
		String name = request.getParameter("name");
		
        // nameが取得できなかった場合
		if (name == null || name.length() == 0) {
			request.setAttribute("errorName","お名前を入力してください");
            // フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
        
        // nameが取得できた場合
		} else {
            // アプリケーションスコープからtodoListを取得			
			ServletContext application = this.getServletContext();
			List<TodoBeans> todoList = (List<TodoBeans>) application.getAttribute("todoList");
			
            // todoListが取得できなかった場合、新規作成
			if (todoList == null) {
				todoList = new ArrayList<>();
				application.setAttribute("todoList", todoList);
			}
			
            // お名前をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("name",name);
            
            // フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        // リクエストパラメータの取得
		String date = request.getParameter("date");
		String text = request.getParameter("text");
        
        // タスク内容が入力されている場合
		if(text != null && text.length() != 0) {	
            ServletContext application = this.getServletContext();
			List<TodoBeans> todoList = (List<TodoBeans>) application.getAttribute("todoList");

			TodoBeans todo = new TodoBeans(text,date);
			RegisterLogic registerTodo = new RegisterLogic();
            //tosoListに追加 
			registerTodo.execute(todo, todoList);

            // アプリケーションスコープに保存
			application.setAttribute("todoList", todoList);
		
        // タスク内容が入力されていない場合
        } else {
			request.setAttribute("errorMsg","タスクが入力されていません");
		}

        // フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/todo.jsp");
		dispatcher.forward(request, response);
	}
}
