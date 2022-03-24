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
    <title>Document</title>
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
    <center>
        <h1 style="margin-top: 10px">Product Application</h1>

        <tr>
            <h2>
                <a href="/sanPham?action=create">Add New Product</a>
            </h2>
        </tr>
        <table class="search">
            <tr>
                <td>
                    <form action="/sanPham" method="post">
                        <input type="hidden" name="action" value="searchTheoTen">
                        <input type="text" name="searchTheoTen">
                        <input type="submit" value="Name">
                    </form>
                </td>
                <td>
                    <form action="/sanPham" method="post">
                        <input type="hidden" name="action" value="searchTheoGia">
                        <input type="text" name="searchTheoGia">
                        <input type="submit" value="Price">
                    </form>
                </td>
                <td>
                    <form action="/sanPham" method="post">
                        <input type="hidden" name="action" value="searchTheoDanhMuc">
                        <input type="text" name="searchTheoDanhMuc">
                        <input type="submit" value="Category">
                    </form>
                </td>
                <td>
                    <form action="/sanPham" method="post">
                        <input type="hidden" name="action" value="searchTheoMau">
                        <input type="text" name="searchTheoMau">
                        <input type="submit" value="Color">
                    </form>
                </td>
            </tr>
        </table>
    </center>
    <div align="center">
    </div>
    <table border="1" id="example" class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>STT</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sanPham" items="${sanPhamList}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td><c:out value="${sanPham.tenSanPham}"/></td>
                <td><c:out value="${sanPham.gia}"/></td>
                <td><c:out value="${sanPham.soLuong}"/></td>
                <td><c:out value="${sanPham.mauSac}"/></td>
                <td><c:out value="${sanPham.danhMuc}"/></td>
                <td>
                    <a  href="/sanPham?action=edit&id=${sanPham.idSanPham}">Edit</a>
                        <%--                    <a href="/customers?action=delete&id=${customer.customerCode}">Delete</a>--%>
                    <button onclick="deleteById('${sanPham.idSanPham}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="footer">
    <h3>Liên hệ</h3>
    <p>
        949 Nguyen Luong Bang Street, Hoa Hiep Nam Ward, Lien Chieu District, Danang City, Vietnam <br>
        Tel.: 84-708-313 527 * Fax: 84-708-313 527 <br>
        Email: lvchien268@gmail.com * www.chienle.com
    </p>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <form action="/sanPham" method="get">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="deleteByModal" id="deleteByModal">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc muốn xóa không?</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Có hay Không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                    <button type="submit" class="btn btn-primary">Có</button>
                </div>
            </div>
        </form>

    </div>
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
<script>
    function deleteById(id) {
        document.getElementById("deleteByModal").value = id;
    }
</script>
</html>
