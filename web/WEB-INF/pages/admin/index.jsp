<%-- 
    Document   : index
    Created on : Mar 15, 2023, 9:28:02 PM
    Author     : daing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- content -->
<div class="content ">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <!-- sale chart -->
        <div class="col-lg-12 col-md-12">
            <div class="card widget h-100">
                <div class="card-header d-flex">
                    <h6 class="card-title">
                        Sales Chart
                    </h6>
                </div>
                <div class="card-body">
                    <div class="d-md-flex align-items-center mb-3">
                        <div class="d-flex align-items-center">
                            <div class="display-7 me-3">
                                <i class="bi bi-bag-check me-2 text-success"></i> $10.552,40
                            </div>
                            <span class="text-success">
                                <i class="bi bi-arrow-up me-1 small"></i>8.30%
                            </span>
                        </div>
                        <div class="d-flex gap-4 align-items-center ms-auto mt-3 mt-lg-0">
                            <select class="form-select">
                                <optgroup label="2020">
                                    <option value="October">October</option>
                                    <option value="November">November</option>
                                    <option value="December">December</option>
                                </optgroup>
                                <optgroup label="2021">
                                    <option value="January">January</option>
                                    <option value="February">February</option>
                                    <option value="March">March</option>
                                    <option value="April">April</option>
                                    <option value="May" selected>May</option>
                                    <option value="June">June</option>
                                    <option value="July">July</option>
                                    <option value="August">August</option>
                                    <option value="September">September</option>
                                    <option value="October">October</option>
                                    <option value="November">November</option>
                                    <option value="December">December</option>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <!--<div id="sales-chart"></div>-->
                </div>
            </div>
        </div>     
    </div>
</div>
<!-- content -->

<!-- content-footer -->
<!-- <footer class="content-footer">
    <div>© 2021 Vetra - <a href="https://laborasyon.com" target="_blank">Laborasyon</a></div>
    <div>
        <nav class="nav gap-4">
            <a href="https://themeforest.net/licenses/standard" class="nav-link">Licenses</a>
            <a href="#" class="nav-link">Change Log</a>
            <a href="#" class="nav-link">Get Help</a>
        </nav>
    </div>
</footer> -->
<!-- ./ content-footer -->

</div>
<!-- ./ layout-wrapper -->


