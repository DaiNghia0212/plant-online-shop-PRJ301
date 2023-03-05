<%-- 
    Document   : main
    Created on : Mar 3, 2023, 1:47:25 AM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="" lang="en">

    <head>
        <title>Plantly</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/assets/images/Favicon.ico"/>">
        <!-- bootstrap min -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.min.css"/>">
        <!-- fontawesome  -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/all.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/fontawesome.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/fontawesome.min.css"/>">
        <!-- OwlCarousel2  -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/owl.carousel.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/owl.carousel.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/owl.theme.default.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/owl.theme.default.min.css"/>">
        <!-- fancybox  -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/jquery.fancybox.css"/>">
        <!-- animate  -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/animate.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/media.css"/>">
        <!-- style  -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/daterangepicker.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/magnific-popup.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/slick-theme.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/slick.css"/>">
        <!-- responsive -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/responsive.css"/>">
        <!-- googleapis  -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300;400;500;600;700;800&display=swap"
              rel="stylesheet">
    </head>

    <body>
        <!-- cart-model -->
        <div class="modal fade" id="cart_model" tabindex="-1"  aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="modal-title f_13 font-weight-bold">Product successfully added to your shopping cart</div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-sm-4 col-xs-12 mb-3  ">
                                <img src="assets/images/product/product_13.jpg" class="fst-image mx-auto d-block img-fluid border rounded" alt="product_13">
                            </div>
                            <div class="col-sm-8 col-xs-12 ">
                                <h6 class="font-weight-bold">Hummingbird printed t-shirt</h6>
                                <div class="font-weight-bold pb-1">$19.12</div>
                                <span class="font-weight-bold f_13 pb-1">Size: S</span><br>
                                <span class="font-weight-bold f_13 pb-1">Color: White</span><br>
                                <span class="font-weight-bold f_13 pb-1">Qty: 2</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class=" col-12 ">
                                <div class="border rounded final_payment">
                                    <div class="card-body  border-bottom">
                                        <p class="text-muted">5 items</p>
                                        <p class="font-weight-bolder">show details</p>
                                        <div>
                                            <span class="font-weight-bold">subtotal</span>
                                            <span class="float-right font-weight-bold">$94.00</span>
                                        </div>
                                        <div>
                                            <span class="font-weight-bold">shipping</span>
                                            <span class="float-right font-weight-bold">$9.00</span>
                                        </div>
                                    </div>
                                    <div class="card-body ">
                                        <div>
                                            <span class="font-weight-bold">total(tax excl.)</span>
                                            <span class="float-right font-weight-bold">$94.00</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-primary mt-2 f_13 px-3 py-2 rounded" data-dismiss="modal">close</a>
                        <a href="checkout.html" class="btn btn-primary mt-2 f_13 px-3 py-2 rounded">continue</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- cart_model -->
        <!-- eye-model -->
        <c:forEach var="product" items="${products}">
            <div class="modal fade product-${product.id}" id="eye_model" tabindex="-1"  aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-5 col-12">
                                    <img src="<c:url value="${product.imagePath}"/>" class="fst-image mx-auto d-block img-fluid border rounded" alt="product_13">
                                </div>
                                <div class="col-sm-7 col-12">
                                    <h5 class="font-weight-bold border-bottom me_name">${product.name}</h5>
                                    <div class="font-weight-bold border-bottom me_price">$${product.price}</div>
                                    <div class="my-2 border-bottom me_des">${product.description}</div>
                                    <div class="me_quan">
                                        <div class="sp_counter ">
                                            <div class="input-group">
                                                <span class="input-group-btn">
                                                    <button type="button" class="btn btn-default btn-number" disabled="disabled" data-type="minus" data-field="quant[${product.id}]"><span class="minus">-</span></button>
                                                </span>
                                                <input type="number" name="quant[${product.id}]" class="form-control input-number" value="1" min="1" max="${product.quantity}">
                                                <span class="input-group-btn">
                                                    <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="quant[${product.id}]"><span class="plus">+</span></button>
                                                </span>
                                            </div>
                                        </div>
                                        <span>
                                            <a href="cart.html" class="btn btn-primary primary mt-3">add to cart</a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <!-- eye_model -->
        <!-- compare-model -->
        <div class="modal fade" id="compare_model" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog  modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body text-center">
                        <p class="checked"></p>
                        <h5>Compare list updated!</h5>
                        <p class="text-muted font-weight-bolder">Product successfully removed from the product comparison!</p>
                        <div class="text-danger font-weight-bolder"><a href="compare.html">Go to Compare</a></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- compare_model -->
        <!-- heart-model -->
        <div class="modal fade" id="heart_model" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content ">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body text-center">
                        <p class="checked"></p>
                        <p class="text-muted font-weight-bolder">You must be logged in to manage your wishlist.</p>
                        <div class="text-danger font-weight-bolder"><a href="wishlist.html">Go to wishlist</a></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- heart_model -->
        <!-- shipping -->
        <div class="modal fade" id="shippingModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content ">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <ul>
                            <li>Fashion has been creating well-designed collections since 2010. </li>
                            <li>The brand offers feminine designs delivering stylish separates and statement dresses which have since evolved into a full ready-to-wear collection in which every item is a vital part of a woman's wardrobe. </li>
                            <li>The result? Cool, easy, chic looks with youthful elegance and unmistakable signature style. </li>
                            <li>All the beautiful pieces are made in Italy and manufactured with the greatest attention. Now Fashion extends to a range of accessories including shoes, hats, belts and more!</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- shipping -->
        <!-- ask about product -->
        <div class="modal fade" id="question_Modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title " id="exampleModalLabel">shipping</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body que_form">
                        <h6>have a any question?</h6>
                        <form>
                            <div>
                                <div class="col-12 sp_form pl-0 pb-3">
                                    <textarea class="form-control"  rows="3" placeholder="Enter Your Message"></textarea>
                                </div>
                                <div class="col-12 sp_form pl-0 pb-3">
                                    <input type="text" class="form-control" placeholder="Enter Your Name">
                                </div>
                                <div class="col-12 sp_form pl-0 pb-3">
                                    <input type="email" class="form-control" placeholder="Enter Your Mail">
                                </div>
                                <div class="col-12 sp_form pl-0 pb-3 ">
                                    <input type="tel" pattern=".{10}" class="form-control" id="other_number" oninput="check(this)" required placeholder="Enter Your Phone">
                                </div>
                                <div class="col-12 sp_form pl-0 pb-3">
                                    <button type="submit" class="btn btn-primary">submit review</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- ask about product -->
        <!-- add to wishlist -->
        <div class="modal fade" id="wish_Modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-body">
                        Please login and you will add product to your wishlist
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Sign In</button>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- add to wishlist -->
        <!-- header area -->
        <header>
            <div class="header-top py-4 border-bottom sticky-md-top">
                <div class="header-top-container">
                    <div class="row header_row">
                        <div class="col-xl-2 col-lg-2 col-6  head-logo pl-md-0">
                            <div class="text-left header-top-left pt-2"><a href="<c:url value="/home/index.do"/>"><img src="<c:url value="/assets/images/logo.png"/>" class="img-responsive img" alt="logo"></a></div>
                        </div>
                        <!-- head-logo -->
                        <div class="col-xl-10 col-lg-10 col-6  head-navbar">
                            <div class="d-flex navbar">
                                <div class="text-center col-xl-8 col-lg-7 col-md-12">  
                                    <ul class="main-menu navbar">
                                        <li><a href="<c:url value="/home/index.do"/>">Home</a></li>
                                        <li><a href="<c:url value="/product/index.do"/>">shop</a></li>
                                        <li><a href="<c:url value="/home/about-us.do"/>">about us</a></li>
                                        <li>
                                            <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">more <!--<svg class="svg-inline--fa fa-angle-down fa-w-10" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="angle-down" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512" data-fa-i2svg=""><path fill="currentColor" d="M143 352.3L7 216.3c-9.4-9.4-9.4-24.6 0-33.9l22.6-22.6c9.4-9.4 24.6-9.4 33.9 0l96.4 96.4 96.4-96.4c9.4-9.4 24.6-9.4 33.9 0l22.6 22.6c9.4 9.4 9.4 24.6 0 33.9l-136 136c-9.2 9.4-24.4 9.4-33.8 0z"></path></svg>--><i class="fas fa-angle-down"></i></a>
                                            <ul class="dropdown-menu all-page-drop">
                                                <li class="d-block"><a class="dropdown-item font-weight-bolderer" href="<c:url value="/home/information.do"/>">delivery informations</a></li>
                                                <li class="d-block"><a class="dropdown-item font-weight-bolderer" href="<c:url value="/home/policy.do"/>">privacy policy</a></li>
                                                <li class="d-block"><a class="dropdown-item font-weight-bolderer" href="<c:url value="/home/service.do"/>">custom service</a></li>
                                                <li class="d-block"><a class="dropdown-item font-weight-bolderer" href="<c:url value="/home/condition.do"/>">term & condition</a></li>
                                                <li class="d-block"><a class="dropdown-item font-weight-bolderer" href="<c:url value="/home/contact-us.do"/>">contact us</a></li>
                                            </ul>
                                        </li>

                                    </ul></div>
                                <div class="col-xl-4 col-lg-5 head-right text-right">
                                    <ul class="top_cart">
                                        <li class="dropdown right1 md_acc md_acco">
                                            <span class="account-block">
                                            </span>
                                            <span class="dropdown-toggle my_account" role="menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <a href="#"></a>
                                            </span>
                                            <c:choose>
                                                <c:when test="${account != null}">
                                                    <span class="dropdown-menu r_menu dropdown-menu-right">
                                                        <a class="dropdown-item font-weight-bolderer" href="<c:url value="/authentication/logout.do"/>">logout</a>
                                                    </span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="dropdown-menu r_menu dropdown-menu-right">
                                                        <a class="dropdown-item font-weight-bolderer" href="<c:url value="/authentication/login.do"/>">log in</a>
                                                        <a class="dropdown-item font-weight-bolderer" href="<c:url value="/authentication/register.do"/>">register</a>
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </li>
                                        <!--  <li class="d-lg-none d-md-inline-block user">
                                              <div class="head_ border rounded bg-white text-left">
                                                 <a class=" md_login" href="#"></a>
                                              </div>
                                              </li> -->
                                        <li class="dropdown d-inline-block my-cart md_acco">
                                            <a href="#" class="cart-qty">
                                                <span class="cart-contents">
                                                </span>
                                                <span class="d-lg-inline-block d-md-none d-sm-none d-none align-middle font-weight-bolderer"></span><span class="price_cart d-md-inline-block align-middle font-weight-bolderer">2</span>
                                            </a>
                                            <span class="dropdown-toggle Price-amount" role="menu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            </span>
                                            <div class="dropdown-menu s_cart dropdown-menu-right">
                                                <ul class="shopping-cart p-2 ">
                                                    <li class="pb-2 d-block cart-remove cart_cross">
                                                        <div class="media">

                                                            <div>
                                                                <a href="#"><img src="assets/images/product/product_13.jpg" class="fst-image img-fluid align-self-center" alt="product_13"></a>
                                                            </div>
                                                            <div class="media-body">
                                                                <h6 class="mt-0 f_15">Media heading</h6>
                                                                <p><span class="f_13">1 x $ 299.00</span></p>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <li class="pb-2 d-block cart-remove border-bottom pl-0 cart_cross wblastcart">
                                                        <!-- <span class=""></span> -->
                                                        <div class="media ">

                                                            <div>
                                                                <a href="#"><img src="assets/images/product/product_21.jpg" class="fst-image img-fluid align-self-center" alt="product_21"></a>
                                                            </div>
                                                            <div class="media-body">
                                                                <h6 class="mt-0 f_15">Media heading</h6>
                                                                <p><span>1 x $ 299.00</span></p>
                                                            </div>
                                                        </div>
                                                    </li>


                                                    <li class="d-block text-muted font-weight-bolderer p-2 border-bottom">
                                                        <span class="text-left">subtotal:</span>
                                                        <span class="float-right">$230.00</span>
                                                    </li>
                                                    <li class="d-block font-weight-bolderer pt-2">
                                                        <span class="text-left"><a href="<c:url value="/cart/index.do"/>">view cart</a></span>
                                                        <span class="float-right"><a href="<c:url value="/payment/index.do"/>">check out</a></span>
                                                    </li>
                                                </ul>
                                                <p class="text-center cartempty">Your Shopping cart is empty!</p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <!-- col-sm-4 head-right text-right -->
                            </div>

                        </div>  
                        <!-- head-navbar -->
                    </div>
                </div>
            </div>
        </header>
        <!-- header area end -->
        <!-- vertical menu and slider -->
        <div id="home_vertical_menu">
            <div class="row ">
                <div class="col-lg-3 vertical_menu">
                    <div class="v_menu bg-white rounded">
                        <div class="cat_menu bg-warning rounded-top"><a href="#" class="pe-auto text-uppercase d-md-none d-sm-none d-none d-lg-block font-weight-bold"><i class="fas fa-bars"></i>all categories</a></div>
                        <div class="navbar-header d-xl-none d-lg-none">
                            <button type="button" class="btn-navbar navbar-toggle" onclick="openNav()" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fas fa-bars"></i></button>
                        </div>
                        <div id="mySidenav" class="sidenav">
                            <div class="close-nav d-xl-none d-lg-none">
                                <span class="categories">Menu</span>
                                <a href="javascript:void(0)" class="closebtn pull-right" onclick="closeNav()"><i class="fas fa-times"></i></a>
                            </div>
                            <ul class="vertical_main_menu h_menu navbar navbar-nav">
                                <li><a href="<c:url value="/home/index.do"/>">Home</a></li>
                                <li class="">
                                    <a class="dropdown-toggle" href="<c:url value="/product/index.do"/>"  role="button" data-toggle="dropdown" aria-expanded="false">shop&nbsp;<span class="float-right"><i class="fas fa-angle-down"></i></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">left sidebar</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-right-sidebar.html">right sidebar</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown mega_menu m1_menu level-1 font-weight-bolderer">
                                    <a class="dropdown-toggle" href="single-product.html"  role="button" data-toggle="dropdown" aria-expanded="false">portfolio&nbsp;<span class="float-right"><i class="fas fa-angle-down"></i></span></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <ul class="row mx-0">
                                                <li class="mg_menu col-lg-6 col-md-12 ">
                                                    <ul>
                                                        <li class="h_title text-uppercase font-weight-bolder border-bottom">portfolio grid 2</li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="portfolio-grid-2.html">portfolio grid 2</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="portfolio-grid-3.html">portfolio grid 3</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="portfolio-grid-4.html">portfolio grid 4</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="mesonary-grid-2.html">mesonary grid 2</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="mesonary-grid-3.html">mesonary grid 3</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="mesonary-grid-4.html">mesonary grid 4</a></li>
                                                    </ul>
                                                </li>
                                                <li class="mg_menu col-lg-6 col-md-12">
                                                    <ul>
                                                        <li class="h_title text-uppercase font-weight-bolder border-bottom">theme elements</li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="title.html">title</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="category-style.html">category</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="services.html">services</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="product-tab.html">product tab</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="multi-slider-product.html">multi slider product</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a class="dropdown-toggle" href="blog.html"  role="button" data-toggle="dropdown" aria-expanded="false">
                                        blog&nbsp;<span class="float-right mt-1"><i class="fas fa-angle-down"></i></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item font-weight-bolderer" href="blog.html">blog</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="blog-left-sidebar.html">left sidebar</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="blog-right-sidebar.html">right sidebar</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown mega_menu level-1 font-weight-bolderer">
                                    <a class="dropdown-toggle" href="single-product.html"  role="button" data-toggle="dropdown" aria-expanded="false">Category&nbsp;<span class="float-right mt-1"><i class="fas fa-angle-down"></i></span></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <ul class="row mx-0">
                                                <li class="mg_menu col-lg-4 col-md-12 ">
                                                    <ul>
                                                        <li class="h_title text-uppercase font-weight-bolder border-bottom">Pot</li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Pigmyweeds</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Indoor Plants</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">outdoor Plants</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Flamingo plant</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Succulent Plant</a></li>
                                                    </ul>
                                                </li>
                                                <li class="mg_menu col-lg-4 col-md-12">
                                                    <ul>
                                                        <li class="h_title text-uppercase font-weight-bolder border-bottom">Plants</li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Nerve Plant</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Flowering Plants</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Plant Seed</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Luck Plants</a></li>
                                                        <li><a class="dropdown-item font-weight-bolderer" href="shop-left-sidebar.html">Plant House</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown level-1 font-weight-bolderer">
                                    <a class="dropdown-toggle" href="#"  role="button" data-toggle="dropdown" aria-expanded="false">pages&nbsp;<span class="float-right mt-1"><i class="fas fa-angle-down"></i></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item font-weight-bolderer" href="about-us.html">about us</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="login.html">login</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="registration.html">registration</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="single-product.html">single product</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="single-blog.html">single blog</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="cart.html">cart</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="compare.html">compare</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="wishlist.html">wishlist</a></li>
                                        <li><a class="dropdown-item font-weight-bolderer" href="checkout.html">check out</a></li>
                                        <!-- <li><a class="dropdown-item font-weight-bolderer" href="forgot.html">forgot password</a></li> -->
                                    </ul>
                                </li>
                                <li class="level-1 font-weight-bolderer"><a href="contact-us.html">contact-us</a></li
                                >
                            </ul>
                        </div>
                    </div>
                    <!-- v_menu bg-white rounded -->
                </div>
            </div>
            <!-- row -->
        </div>
        <!-- container  menu_slider mt-4 -->
        <!-- vertical menu and slider end -->
        <jsp:include page="../pages/${controller}/${action}.jsp"/>
        <!-- footer -->
        <div class="footer animate__animated animate__fadeInUp">
            <div class="first_footer">
                <div class="container ">
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-3 col-12 f_col">
                            <div class="fst_col">
                                <div class="footer_title">
                                    <h5 class="text-uppercase">contact us<button class="toggle collapsed" data-toggle="collapse"
                                                                                 data-target="#fproduct"></button></h5>
                                </div>
                                <div class="categorie collapse " id="fproduct">
                                    <ul class="add_row">
                                        <li>
                                            <div class="data1  contact-ic">
                                                <a href="#">Demo A - 2 Tong Duy Tan Street,<br> District 5, HCM</a>
                                            </div>
                                        </li>
                                        <li>
                                            <a href="#" class="contact-ic ">+841234567890</a>
                                        </li>
                                        <li>
                                            <a href="#" class="mail_f contact-ic">website@gmail.com</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-3 col-12">
                            <div class="fth_col">
                                <div class="footer_title">
                                    <h5 class="text-uppercase">information<button class="toggle collapsed" data-toggle="collapse"
                                                                                  data-target="#fh_product"></button></h5>
                                </div>
                                <div class="categorie collapse" id="fh_product">
                                    <ul>
                                        <li><a href="<c:url value=""/>about-us.html">About</a></li>
                                        <li><a href="<c:url value=""/>information.html">Delivery Infomations</a></li>
                                        <li><a href="<c:url value=""/>policy.html">Privacy Policy</a></li>
                                        <li><a href="<c:url value=""/>service.html">Custom Service</a></li>
                                        <li><a href="<c:url value=""/>condition.html">Terms &amp; Condition</a></li>
                                        <li><a href="<c:url value=""/>contact-us.html">Contact Us</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-12 d-none d-sm-none d-md-block news-letter">
                            <div class="newsletter d-inline-block align-middle">
                                <h4 class="">Sign up to Newsletter</h4>
                                <p class="mb-0">Make sure that you never miss our interesting news and exclusive promotion. No
                                    spam, Ever!</p>
                            </div>
                            <div class="input-group">
                                <input type="text" class="form-control border-white" placeholder="Subscribe newsletter..."
                                       aria-label="Subscribe newsletter..." aria-describedby="button-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary text-uppercase" type="button"
                                            id="button-addon2">Subscribe</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- row first_footer -->
            <div class="fifth_footer">
                <div class="container ">
                    <div class="">
                        <div class="text-center demo_link d-block">2023 @ All rights reserved Powered by Planty </div>
                        <div class="footer_bottom text-center">
                            <div class="d-flex justify-content-center">
                                <div class="social_links">
                                    <a href="#"><i class="fab fa-facebook-f"></i></a>
                                </div>
                                <div class="social_links">
                                    <a href="#"><i class="fab fa-youtube"></i></a>
                                </div>
                                <div class="social_links">
                                    <a href="#"><i class="fab fa-skype"></i> </a>
                                </div>
                                <div class="social_links">
                                    <a href="#"><i class="fab fa-twitter"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- row second_footer -->
            </div>
        </div>
        <!-- footer end -->
        <!-- scroll -->
        <a href="#" id="scroll"></a>
        <!-- jquery-3.4.1 -->
        <script src="<c:url value="/assets/js/jquery-3.4.1.min.js"/>"></script>
        <!-- owl.carousel -->
        <script src="<c:url value="/assets/js/owl.carousel.js"/>"></script>
        <!-- bootstrap.min -->
        <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
        <!-- popper.min -->
        <script src="<c:url value="/assets/js/popper.min.js"/>"></script>
        <!-- wow.js - v1.2.1 -->
        <script src="<c:url value="/assets/js/wow.min.js"/>"></script>
        <!-- Font Awesome Free 5.15.1 -->
        <script src="<c:url value="/assets/js/all.min.js"/>"></script>
        <!-- custom js -->
        <script src="<c:url value="/assets/js/custom.js"/>"></script>
    </body>
</html>
