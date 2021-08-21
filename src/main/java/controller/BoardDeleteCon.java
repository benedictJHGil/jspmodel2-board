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

@WebServlet("/BoardDeleteCon.do")
public class BoardDeleteCon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 글 번호를 입력
        int num = Integer.parseInt(request.getParameter("num"));
        // DB에 접근하여 하나의 게시글을 반환하는 메소드
        BoardDAO bdao = new BoardDAO();
        BoardBean bean = bdao.getOneUpdateBoard(num); // 조회수를 증가시키지 않는 메소드

        request.setAttribute("bean", bean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("BoardDeleteForm.jsp");
        dispatcher.forward(request, response);
    }
}
