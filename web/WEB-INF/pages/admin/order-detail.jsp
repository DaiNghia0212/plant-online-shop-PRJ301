<%-- 
    Document   : invoice-detail
    Created on : Mar 16, 2023, 12:37:59 AM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- content -->
<div class="content ">
    <div class="d-flex gap-3 mb-4 d-print-none">
        <button onclick="javascript:window.print()" class="btn btn-outline-secondary d-none d-md-block btn-icon">
            <i class="bi bi-printer"></i> Print
        </button>
    </div>
    <div class="card">
        <div class="card-body">
            <div class="invoice">
                <div class="d-md-flex justify-content-between align-items-center mb-4">
                    <div>Invoice No : #000756</div>
                    <div>Date: 	3/29/2021</div>
                </div>
                <div class="d-md-flex justify-content-between align-items-center">
                    <h4>Invoice</h4>
                    <div>
                        <img width="120" src="../../assets/images/logo.png" alt="logo">
                    </div>
                </div>
                <hr class="my-4">
                <div class="row">
                    <div class="col-md-6">
                        <p>
                            <strong>Bill From</strong>
                        </p>
                        <p>5A Tong Du Tan, <br>D5</p>
                    </div>
                    <div class="col-md-6">
                        <p class="text-start text-md-end">
                            <strong>Bill to</strong>
                        </p>
                        <p>81 Nguen Huu Canh, <br>D1/HCM</p>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table mb-4 mt-4">
                        <thead class="thead-light">
                            <tr>
                                <th>#</th>
                                <th>Description</th>
                                <th class="text-end">Quantity</th>
                                <th class="text-end">Price</th>
                                <th class="text-end">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="text-end">
                                <td class="text-start">1</td>
                                <td class="text-start">Japanese Black Pine Bonsai</td>
                                <td>1</td>
                                <td>$1.190,90</td>
                                <td>$1.190,90</td>
                            </tr>
                            <tr class="text-end">
                                <td class="text-start">2</td>
                                <td class="text-start">Copper Coin in SOOP Ceramic Pot</td>
                                <td>1</td>
                                <td>$139.58</td>
                                <td>$139.58</td>
                            </tr>
                            <tr class="text-end">
                                <td class="text-start">3</td>
                                <td class="text-start">Ficus Elastica Shivereana in RAYON Ceramic Pot</td>
                                <td>1</td>
                                <td>$50,90</td>
                                <td>$101,80</td>
                            </tr>
                            <tr class="text-end">
                                <td class="text-start">4</td>
                                <td class="text-start">Jacaranda Obtusifolia in BETONI Concrete Pot</td>
                                <td>1</td>
                                <td>$10,50</td>
                                <td>$10,50</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="text-end">
                    <p>Sub Total: $1.442,78</p>
                    <p>Shipping: Free</p>
                    <p>Tax(18%) : $259.70</p>
                    <h4 class="fw-bold">Total: $1.702,48</h4>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- ./ content -->
