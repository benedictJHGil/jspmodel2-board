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

@WebServlet("/BoardUpdateCon.do")
public class BoardUpdateCon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 해당 번호
        int num = Integer.parseInt(request.getParameter("num"));
        // DB 에서 하나의 게시글에 대한 정보를 반환하는 메소드
        BoardDAO bdao = new BoardDAO();
        BoardBean bean = bdao.getOneUpdateBoard(num);

        request.setAttribute("bean", bean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("BoardUpdateForm.jsp");
        dispatcher.forward(request, response);
    }
}
