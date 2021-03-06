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

@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
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
        // 폼에서 넘어온 데이터를 받아줌
        int num = Integer.parseInt(request.getParameter("num"));
        String pwd1 = request.getParameter("pwd1"); // 사용자로부터 입력받은 패스워드
        String pwd2 = request.getParameter("pwd2"); // 실제 DB에 저장되어있는 패스워드
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        // pwd1 과 pwd2 를 비교
        if(pwd1.equals(pwd2)) { // true 일 경우 데이터 수정
            BoardDAO bdao = new BoardDAO();
            bdao.updateBoard(num, subject, content);
            // 수정이 완료되었다면 전체 게시글 보기로 이동
            request.setAttribute("msg", "수정이 완료되었습니다.");

            RequestDispatcher dispatcher = request.getRequestDispatcher("BoardListCon.do");
            dispatcher.forward(request, response);
        } else {
            // 이전 페이지로 이동
            request.setAttribute("msg", "비밀번호가 맞지 않습니다.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("BoardUpdateCon.do");
            dispatcher.forward(request, response);
        }
    }
}
