/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.category.Category;
import models.category.CategoryFacade;
import models.product.Product;
import models.product.ProductFacade;
import org.apache.catalina.tribes.util.Arrays;

/**
 *
 * @author daing
 */
@WebServlet(name = "ProductController", urlPatterns = {"/product"})
public class ProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (String) request.getAttribute("action");
        ProductFacade productFacade = new ProductFacade();
        switch (action) {
            case "index": {
                String offset = request.getParameter("offset");
                String limit = request.getParameter("limit");
                String search = request.getParameter("search");
                String[] categoriesFilter = request.getParameterValues("categories");
                String selectedOrder = request.getParameter("order");
                TreeMap<String, String> orders = new TreeMap<>();
                orders.put("name-ascending", "Name, A to Z");
                orders.put("name-descending", "Name, Z to A");
                orders.put("price-ascending", "Price, low to high");
                orders.put("price-descending", "Price, high to low");
                if (offset == null) {
                    offset = "0";
                }
                if (limit == null) {
                    limit = "6";
                }
                String orderBy = "updated_at";
                String orderType = "descending";
                if (selectedOrder != null && orders.containsKey(selectedOrder)) {
                    orderBy = selectedOrder.substring(0, selectedOrder.indexOf("-"));
                    orderType = selectedOrder.substring(selectedOrder.indexOf("-") + 1, selectedOrder.length());
                }
                ArrayList<Integer> checkedCategories = new ArrayList<>();
                if (categoriesFilter != null) {
                    for (String categoriesFilter1 : categoriesFilter) {
                        checkedCategories.add(Integer.parseInt(categoriesFilter1));
                    }
                }
                HashMap<String, Object> productsMap = new HashMap<>();
                ArrayList<Category> categories = new ArrayList<>();
                CategoryFacade categoryFacade = new CategoryFacade();
                try {
                    productsMap = productFacade.getProducts(search, checkedCategories, orderBy, orderType, Integer.parseInt(offset), Integer.parseInt(limit));
                    categories = categoryFacade.selectAll();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                int totalPage = (int) Math.ceil((int) productsMap.get("total") / Double.parseDouble(limit));
                int currentPage = (Integer.parseInt(offset) / Integer.parseInt(limit)) + 1;
                request.setAttribute("currentPage", currentPage);
                request.setAttribute("search", search);
                request.setAttribute("checkedCategories", checkedCategories);
                request.setAttribute("orders", orders);
                request.setAttribute("selectedOrder", selectedOrder);
                request.setAttribute("products", productsMap.get("products"));
                request.setAttribute("totalProduct", (int) productsMap.get("total"));
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "product-detail": {
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = null;
                Category category = null;
                ArrayList<Product> relatedProducts = new ArrayList<>();
                CategoryFacade categoryFacade = new CategoryFacade();
                try {
                    product = productFacade.getProductById(id);
                    category = categoryFacade.getCategoryById(product.getCategoryId());
                    relatedProducts = productFacade.getRelatedProducts(product.getCategoryId());
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                request.setAttribute("product", product);
                request.setAttribute("category", category);
                request.setAttribute("products", relatedProducts);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
            }
            default:
            // show error 404 page
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
