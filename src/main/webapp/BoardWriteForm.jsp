<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <center>
        <h2>게시글 쓰기</h2>

        <form action="/BoardWriteProcCon.do" method="post">
            <table width="600" border="1" bordercolor="gray" bgcolor="#d3d3d3">
                <tr height="40">
                    <td align="center" width="150">작성자</td>
                    <td width="450"><input type="text" name="writer" size="50"></td>
                </tr>
                <tr height="40">
                    <td align="center" width="150">제목</td>
                    <td width="450"><input type="text" name="subject" size="50"></td>
                </tr>
                <tr height="40">
                    <td align="center" width="150">이메일</td>
                    <td width="450"><input type="email" name="email" size="50"></td>
                </tr>
                <tr height="40">
                    <td align="center" width="150">비밀번호</td>
                    <td width="450"><input type="password" name="password" size="50"></td>
                </tr>
                <tr height="40">
                    <td align="center" width="150">글내용</td>
                    <td width="450"><textarea name="content" cols="50" rows="10"></textarea></td>
                </tr>
                <tr height="40">
                    <td align="center" colspan="2">
                        <input type="submit" value="글쓰기">&nbsp;&nbsp;
                        <input type="reset" value="다시작성">&nbsp;&nbsp;
            </table>
        </form>
            <table>
                        <button onclick="location.href='BoardListCon.do'">전체 게시글 보기</button>
                    </td>
                </tr>
            </table>

    </center>
</body>
</html>
