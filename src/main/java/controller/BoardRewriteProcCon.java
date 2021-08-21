package controller;

import model.BoardBean;
import model.BoardDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BoardRewriteProcCon.do")
public class BoardRewriteProcCon extends HttpServlet {
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
            // 빈에 넘어온 데이터를 저장
            BoardBean bean = new BoardBean();
            bean.setWriter(request.getParameter("writer"));
            bean.setSubject(request.getParameter("subject"));
            bean.setEmail(request.getParameter("email"));
            bean.setPassword(request.getParameter("password"));
            bean.setContent(request.getParameter("content"));

            bean.setRef(Integer.parseInt(request.getParameter("ref")));
            bean.setRe_step(Integer.parseInt(request.getParameter("re_step")));
            bean.setRe_level(Integer.parseInt(request.getParameter("re_level")));

            BoardDAO bdao = new BoardDAO();

            bdao.reinsertBoard(bean);
            RequestDispatcher dispatcher = request.getRequestDispatcher("BoardListCon.do");
            dispatcher.forward(request, response);
        }

    }
}
