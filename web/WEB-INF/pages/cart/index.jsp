<%-- 
    Document   : cart
    Created on : Mar 8, 2023, 8:16:17 PM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- cart page -->
<div id="cart_page" class="cart-page animate__animated animate__fadeInUp">
    <div class="sp_header bg-white p-2 ">
        <div class="container custom_container ">
            <div class="row ">
                <div class="col-12 ">
                    <ul class="p-md-3 p-2 bg-light">
                        <li class="d-inline-block font-weight-bolderer"><a href="index.html">home</a></li>
                        <li class="d-inline-block  font-weight-bolderer"><a href="#" class="hr_">Cart</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="container custom_container ">
        <div class="row">
            <div class="col-12">
                <div class="title_outer">
                    <h1 class="mb-3 d-inline-block pb-3 position-relative border-bottom h1_">Cart</h1>
                </div>
                <!-- title_outer -->
            </div>
            <!-- col-12 -->
        </div>
        <!-- row -->
        <div class="row">
            <div class="col-12 col-lg-8">
                <div class="card">
                    <div class="card-header cart_header bg-white">
                        <div class="card-title mb-0">
                            <div class="row">
                                <div class="col-12">
                                    <h5 class="mb-0"><i class="fas fa-shopping-cart"></i>&nbsp;&nbsp;Shopping Cart</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body cart_body">
                        <div class="row view-cart-d">
                            <!-- <div class="col-12 my-2 mt-1 text-right ">
                                  <a href="#"><i class="fas fa-trash-alt"></i></a>
                                </div> -->
                            <div class="col-12 col-md-6 pr-0">
                                <div class="d-flex">
                                    <div class=" col-xl-4 col-lg-5 col-md-4 col-4 px-0">
                                        <a href="#"><img src="assets/img/product/product_13.jpg"
                                                         class="fst-image mx-auto d-block img-fluid" alt="product_13"></a>
                                    </div>
                                    <div class=" col-xl-8 col-lg-7 col-md-8 col-8 pr-0">
                                        <h4 class="product-name font-weight-bolder mb-2 mb-sm-3 mb-xl-3 mt-sm-2 mt-md-2"><a
                                                href="#">Aliquam Top Erat Volutpat</a></h4>
                                        <div><span class="font-weight-bolderer price">$69.00 </span> <del
                                                class="text-muted">$100.00</del></div>
                                        <div class="my-1 f_13">
                                            <span>size:</span>
                                            <span>s</span>
                                        </div>
                                        <div class="f_13">
                                            <span>color:</span>
                                            <span>white</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-6 mt-4">
                                <div class="d-flex">
                                    <div class="col-md-3 col-sm-4 col-5 text-left text-md-right my-2 ">
                                        <span class="font-weight-bolder">$45.00</span>
                                    </div>
                                    <div class="col-md-9 col-sm-4 col-5">
                                        <input type="number" class="form-control border" placeholder="0">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="row cart_p_remove1 view-cart-d">
                            <!-- <div class="col-12 my-2 mt-1 text-right view-cart-d ">
                                  <a href="#"><i class="fas fa-trash-alt"></i></a>
                                </div>  -->
                            <div class="col-12 col-md-6 pr-0">
                                <div class="d-flex">
                                    <div class=" col-xl-4 col-lg-5 col-md-4 col-4 px-0">
                                        <a href="#"><img src="assets/img/product/product_17.jpg"
                                                         class="fst-image mx-auto d-block img-fluid" alt="product_17"></a>
                                    </div>
                                    <div class=" col-xl-8 col-lg-7 col-md-8 col-8 pr-0">
                                        <h4 class="product-name font-weight-bolder mb-2 mb-sm-3 mb-xl-3 mt-sm-2 mt-md-2"><a
                                                href="#">Aliquam Top Erat Volutpat</a></h4>
                                        <div><span class="font-weight-bolderer price">$69.00 </span> <del
                                                class="text-muted">$100.00</del></div>
                                        <div class="my-1 f_13">
                                            <span>size:</span>
                                            <span>s</span>
                                        </div>
                                        <div class="f_13">
                                            <span>color:</span>
                                            <span>white</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-6 mt-4">
                                <div class="d-flex">
                                    <div class="col-md-3 col-sm-4 col-5 text-left text-md-right my-2 ">
                                        <span class="font-weight-bolder">$45.00</span>
                                    </div>
                                    <div class="col-md-9 col-sm-4 col-5">
                                        <input type="number" class="form-control border" placeholder="0">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="card-footer">
                            <div class="row">
                                <div class="col-6 col-sm-7 text-right">
                                    <div class="my-2 font-weight-bolder">
                                        <span>total:</span>
                                        <span>$56.00</span>
                                    </div>
                                </div>
                                <div class="col-6 col-sm-5 checkout-btn">
                                    <a href="checkout.html" class="btn btn-block f_13 font-weight-bolder">Checkout</a>
                                </div>
                            </div>
                        </div>

                    </div>

                    <p class="text-center cartempty1">Your Shopping cart is empty!</p>

                </div>
            </div>
            <div class="col-12 col-lg-4">
                <div class="border rounded bg-white final_payment">
                    <div class="card-body  border-bottom">
                        <p class="text-muted">5 items</p>
                        <p class="font-weight-bolderer">show details</p>
                        <div>
                            <span class="font-weight-bolder">subtotal</span>
                            <span class="float-right font-weight-bolder">$94.00</span>
                        </div>
                    </div>
                    <div class="card-body ">
                        <div>
                            <span class="font-weight-bolder">total(tax excl.)</span>
                            <span class="float-right font-weight-bolder">$94.00</span>
                        </div>
                        <div>
                            <span class="font-weight-bolder">taxes</span>
                            <span class="float-right font-weight-bolder">$9.00</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
