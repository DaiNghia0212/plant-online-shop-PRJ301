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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.product.Product;
import models.product.ProductFacade;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//        processRequest(request, response);
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "index": {
                String search = request.getParameter("search");
                String orderBy = request.getParameter("orderBy");
                String orderType = request.getParameter("orderType");
                int offset = Integer.parseInt(request.getParameter("offset"));
                int limit = Integer.parseInt(request.getParameter("limit"));
                if (search == null) {
                    search = "";
                }
                if (orderBy == null) {
                    orderBy = "id";
                }
                if (orderType == null) {
                    orderType = "ascending";
                }
                if ((orderBy.equals("name") || orderBy.equals("price") || orderBy.equals("id")) && (orderType.equals("ascending") || orderType.equals("descending"))) {
                    ArrayList<Product> products = new ArrayList<>();
                    try {
                        products = ProductFacade.getProducts(search, orderBy, orderType, offset, limit);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                    request.setAttribute("products", products);
                    request.getRequestDispatcher("/WEB-INF/pages/product/index.jsp").forward(request, response);
                } else {
                    // send 400 error page
                }
                break;
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
