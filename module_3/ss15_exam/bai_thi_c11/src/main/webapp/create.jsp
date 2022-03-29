<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 3/21/2022
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="header">
    <img src="https://i.pinimg.com/originals/d7/e1/de/d7e1de723fe424f143ef00cbd9c85466.jpg" alt="" class="logo">
    <span class="my-name">LE VAN CHIEN</span>
</div>

<div class="nav">
    <div class="botton-gradient">
        <a href="index.jsp" class="botton-gradient botton-gradient-1">Home</a>
        <a href="/sanPham" class="botton-gradient botton-gradient-2">List</a>
        <a href="create.jsp" class="botton-gradient botton-gradient-3">Create</a>
        <a href="search.jsp" class="botton-gradient botton-gradient-4">Search</a>
        <a href="#" class="botton-gradient botton-gradient-5">Blog</a>
        <%--        <span>Search</span>--%>
        <input type="text" value="Search">
    </div>
</div>

<div class="body">
    </center>
    <div align="center" class="create">
        <h2>Mượn sách</h2>
        <form method="post" action="/themuonsach?action=create">
            <table border="1" cellpadding="5">
                <%--                <tr>--%>
                <%--                    <th>ID sản phẩm:</th>--%>
                <%--                    <td>--%>
                <%--                        <input type="text" name="idSanPham" id="idSanPham" size="20" />--%>
                <%--&lt;%&ndash;                        <br>&ndash;%&gt;--%>
                <%--&lt;%&ndash;                        <c:if test="${map.get('customerCode')!=null}">&ndash;%&gt;--%>
                <%--&lt;%&ndash;                            <small>${map.get('customerCode')}</small>&ndash;%&gt;--%>
                <%--&lt;%&ndash;                        </c:if>&ndash;%&gt;--%>
                <%--&lt;%&ndash;                        <c:if test="${map.get('customerCodeRegex')==true}">&ndash;%&gt;--%>
                <%--&lt;%&ndash;                            <small>${map.get('customerCodeRegex')}</small>&ndash;%&gt;--%>
                <%--&lt;%&ndash;                        </c:if>&ndash;%&gt;--%>
                <%--                    </td>--%>
                <%--                </tr>--%>
                <tr>
                    <th>Mã mượn sách:</th>
                    <td>
                        <input type="text" name="maMuonSach" id="maMuonSach" size="20"/>
                    </td>
                </tr>
                <tr>
                    <th>Tên sách:</th>
                    <td>
                        <input type="text" name="maSach" id="maSach" size="20" value="${sachList.tenSach}"/>

                    </td>
                </tr>
                <tr>
                    <th>Tên học sinh:</th>

                    <td>
<%--                        <select name="maHocSinh">--%>
<%--                            <c:forEach items="${hocSinhList}" var="hocSinh">--%>
<%--                                    <option selected value="${hocSinh.maHocSinh}">${hocSinh.hoTen}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
                    </td>

                </tr>
                <tr>
                    <th>Ngày mượn sách:</th>
                    <td>
                        <input type="text" name="ngayMuon" id="ngayMuon" size="20"/>
                        <%--                        <br>--%>
                        <%--                        <c:if test="${map.get('IDNumber')!=null}">--%>
                        <%--                            <small>${map.get('IDNumber')}</small>--%>
                        <%--                        </c:if>--%>
                    </td>
                    <%--
                                    </tr>
                                    <tr>
                                        <th>Ngày trả sách:</th>
                                        <td>
                                            <input type="text" name="ngayTra" id="ngayTra" size="20"/>
                                            <%--                        <br>--%>
                    <%--                        <c:if test="${map.get('IDNumber')!=null}">--%>
                    <%--                            <small>${map.get('IDNumber')}</small>--%>
                    <%--                        </c:if>--%>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input hidden type="text" name="trangThai" id="trangThai" value="true" size="20"/>
                        <%--                        <br>--%>
                        <%--                        <c:if test="${map.get('dateOfBirth')!=null}">--%>
                        <%--                            <small>${map.get('dateOfBirth')}</small>--%>
                        <%--                        </c:if>--%>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Mượn sách"/>
                    </td>
                    <td colspan="2" align="center">
                        <a href="/themuonsach">Hủy</a>
                    </td>
                </tr>
            </table>
        </form>
        <%--        <c:if test="${message!=null}">--%>
        <%--            <h3>${message}</h3>--%>
        <%--        </c:if>--%>
    </div>
</div>

<div class="footer">
    <h3>Liên hệ</h3>
    <p>
        949 Nguyen Luong Bang Street, Hoa Hiep Nam Ward, Lien Chieu District, Danang City, Vietnam <br>
        Tel.: 84-708-313 527 * Fax: 84-708-313 527 <br>
        Email: lvchien268@gmail.com * www.chienle.com
    </p>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    $.extend(true, $.fn.dataTable.defaults, {
        "searching": false,
        "ordering": false
    });
    $(document).ready(function () {
        $('#example').DataTable({
            "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]]
        });
    });
</script>
</html>
