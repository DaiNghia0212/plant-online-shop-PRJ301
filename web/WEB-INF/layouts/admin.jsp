<%-- 
    Document   : admin
    Created on : Mar 16, 2023, 12:14:52 AM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title> Planty | Admin  </title>
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/assets/icon/Favicon.ico"/>">
        <!-- Google fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <!-- Bootstrap icons -->
        <link rel="stylesheet" href="<c:url value="/assets/dist/icons/bootstrap-icons-1.4.0/bootstrap-icons.min.css"/>" type="text/css">
        <!-- Bootstrap Docs -->
        <link rel="stylesheet" href="<c:url value="/assets/dist/css/bootstrap-docs.css"/>" type="text/css">
        <!-- Range slider -->
        <link rel="stylesheet" href="<c:url value="/assets/libs/range-slider/css/ion.rangeSlider.min.css"/>" type="text/css">
        <!-- Slick -->
        <link rel="stylesheet" href="<c:url value="/assets/libs/slick/slick.css"/>" type="text/css">

        <!-- Main style file -->
        <link rel="stylesheet" href="<c:url value="/assets/dist/css/app.css"/>" type="text/css">
    </head>
    <body>
        <!-- preloader -->
        <div class="preloader">
            <img src="<c:url value="/assets/images/loader.gif"/>" />
            <!-- <div class="preloader-icon"></div> -->
        </div>
        <!-- ./ preloader -->

        <!-- menu -->
        <div class="menu">
            <div class="menu-header">
                <a href="<c:url value="/home/index.do"/>" class="menu-header-logo">
                    <img src="<c:url value="/assets/images/logo.png"/>" alt="logo"/>
                </a>
                <!-- <a href="index.html" class="btn btn-sm menu-close-btn">
                    <i class="bi bi-x"></i>
                </a> -->
            </div>
            <div class="menu-body">
                <div class="dropdown">
                    <a href="#" class="d-flex align-items-center" data-bs-toggle="dropdown">
                        <div class="avatar me-3">
                            <img src="<c:url value="/assets/images/user/man_avatar3.jpg"/>"
                                 class="rounded-circle" alt="image"/>
                        </div>
                        <div>
                            <div class="fw-bold">Arthur Nguyen</div>
                        </div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a href="<c:url value="/authentication/logout.do"/>" class="dropdown-item d-flex align-items-center text-danger"
                           target="_blank">
                            <i class="bi bi-box-arrow-right dropdown-item-icon"></i> Logout
                        </a>
                    </div>
                </div>
                <ul>
                    <li class="menu-divider">E-Commerce</li>
                    <!-- 1. dashboard -->
                    <li>
                        <a  class="active"
                            href="<c:url value="/admin/index.do"/>">
                            <span class="nav-link-icon">
                                <i class="bi bi-bar-chart"></i>
                            </span>
                            <span>Dashboard</span>
                        </a>
                    </li>
                    <!-- 2. orders -->
                    <!--                    <li>
                                            <a href="#">
                                                <span class="nav-link-icon">
                                                    <i class="bi bi-receipt"></i>
                                                </span>
                                                <span>Orders</span>
                                            </a>
                                            <ul>
                                                <li>
                                                    <a  href="./orders.html">List</a>
                                                </li>
                                                <li>
                                                    <a  href="./order-detail.html">Detail</a>
                                                </li>
                                            </ul>
                                        </li>-->
                    <!-- 3. product -->
                    <li>
                        <a href="<c:url value="/admin/products.do"/>">
                            <span class="nav-link-icon">
                                <i class="bi bi-truck"></i>
                            </span>
                            <span>Products</span>
                        </a>
                    </li>
                    <!-- 4. invoices -->
                    <li>
                        <a href="#">
                            <span class="nav-link-icon">
                                <i class="bi bi-receipt"></i>
                            </span>
                            <span>Invoices</span>
                        </a>
                        <ul>
                            <li>
                                <a href="<c:url value="/admin/invoices.do"/>"
                                   >List</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/invoice-detail.do"/>"
                                   >Detail</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- ./  menu -->

        <!-- layout-wrapper -->
        <div class="layout-wrapper">
            <!-- header -->
            <div class="header">
                <div class="menu-toggle-btn"> <!-- Menu close button for mobile devices -->
                    <a href="#">
                        <i class="bi bi-list"></i>
                    </a>
                </div>
                <!-- Logo -->
                <a href="index.html" class="logo">
                    <img width="100" src="./assets/img/logo.png" alt="logo">
                </a>
                <!-- ./ Logo -->

                <div class="page-title" style="font-weight: 1000;">OVERVIEW</div>

            </div>
            <!-- ./ header -->
            <jsp:include page="../pages/admin/${action}.jsp"/>
            <!-- Bundle scripts -->
            <script src="<c:url value="/assets/libs/bundle.js"/>"></script>
            <!-- Apex chart -->
            <script src="<c:url value="/assets/libs/charts/apex/apexcharts.min.js"/>"></script>
            <!-- Slick -->
            <script src="<c:url value="/assets/libs/slick/slick.min.js"/>"></script>
            <!-- Examples -->
            <script src="<c:url value="/assets/dist/js/examples/dashboard.js"/>"></script>
            <script src="<c:url value="/assets/dist/js/examples/products.js"/>"></script>
            <script src="<c:url value="/assets/dist/js/examples/invoices.js"/>"></script>
            <!-- Range slider -->
            <script src="<c:url value="/assets/libs/range-slider/js/ion.rangeSlider.min.js"/>"></script>
            <!-- Main Javascript file -->
            <script src="<c:url value="/assets/dist/js/app.min.js"/>"></script>
    </body>
</html>
