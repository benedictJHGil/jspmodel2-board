<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
    <c:if test="${msg != null}">
        <script>
          alert("비밀번호가 틀렸습니다. 다시 입력해주세요.")
        </script>
    </c:if>
    <center>
        <h2>게시글 삭제</h2>

        <form action="/BoardDeleteProcCon.do" method="post">
            <table width="600" border="1" bgcolor="#d3d3d3">
                <tr height="40">
                    <td width="120" align="center">패스워드</td>
                    <td width="480" colspan="3">&nbsp;<input type="password" name="pwd1" size="50"></td>
                </tr>
                <tr height="40">
                    <td colspan="4" align="center">
                        <input type="hidden" name="num" value="${bean.num}">
                        <input type="hidden" name="pwd2" value="${bean.password}">
                        <input type="submit" value="글삭제">
            </table>
        </form>
            <table>
                        <input type="button" onclick="location.href='BoardListCon.do'" value="전체글보기">
                    </td>
                </tr>
            </table>

    </center>
</body>
</html>
