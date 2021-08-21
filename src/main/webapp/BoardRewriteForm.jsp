<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <center>
        <h2>답변글 입력하기</h2>

        <form action="/BoardRewriteProcCon.do" method="post">
            <table width="600" border="1" bordercolor="gray" bgcolor="#d3d3d3">
                <tr height="40">
                    <td width="150" align="center">작성자</td>
                    <td width="450" ><input type="text" name="writer" size="50"></td>
                </tr>
                <tr height="40">
                    <td width="150" align="center">제목</td>
                    <td width="450" ><input type="text" name="subject" value="[답변] " size="50"></td>
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
                <%--form에서 사용자로부터 입력받지 않고 데이터를 넘김--%>
                <tr height="40">
                    <td align="center" colspan="2">
                        <input type="hidden" name="ref" value="${ref}">
                        <input type="hidden" name="re_step" value="${re_step}">
                        <input type="hidden" name="re_level" value="${re_level}">
                        <input type="submit" value="답변쓰기완료"> &nbsp;&nbsp;
                        <input type="reset" value="취소"> &nbsp;&nbsp;
            </table>
        </form>
            <table>
                        <input type="button" onclick="location.href='BoardList.jsp'" value="전체글보기">
                    </td>
                </tr>
            </table>
    </center>
</body>
</html>
