package controller;

import model.BoardBean;
import model.BoardDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/BoardWriteProcCon.do")
public class BoardWriteProcCon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        if(request.getParameter("writer") != null) {
            // bean 클래스로 데이터를 읽어드림
            BoardBean bean = new BoardBean();
            bean.setWriter(request.getParameter("writer"));
            bean.setSubject(request.getParameter("subject"));
            bean.setEmail(request.getParameter("email"));
            bean.setPassword(request.getParameter("password"));
            bean.setContent(request.getParameter("content"));

            BoardDAO bdao = new BoardDAO();

            bdao.insertBoard(bean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("BoardListCon.do");
            dispatcher.forward(request, response);
        }
    }
}
