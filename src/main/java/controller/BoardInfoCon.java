package controller;

import model.BoardBean;
import model.BoardDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/BoardInfoCon.do")
public class BoardInfoCon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reqPro(request, response);
    }

    protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // number
        int num = Integer.parseInt(request.getParameter("num"));
        // DB 접근
        BoardDAO bdao = new BoardDAO();
        // 하나의 게시글에 대한 정보를 반환
        BoardBean bean = bdao.getOneBoard(num);
        request.setAttribute("bean", bean);
        // view = jsp 쪽으로 데이터를 넘겨줌
        RequestDispatcher dispatcher = request.getRequestDispatcher("BoardInfo.jsp");
        dispatcher.forward(request, response);
    }
}
