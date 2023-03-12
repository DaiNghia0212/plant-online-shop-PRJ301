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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.cart.Cart;
import models.cart.Item;
import models.product.Product;
import models.product.ProductFacade;

/**
 *
 * @author daing
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

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
                ProductFacade productFacade = new ProductFacade();
                HashMap<String, Object> productsMap = new HashMap<>();
                try {
                    productsMap = productFacade.getProducts("", null, "updated_at", "descending", 0, 12);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                ArrayList popularProducts = new ArrayList();
                int count = 0;
                ArrayList<Product> list = new ArrayList<>();
                HttpSession session = request.getSession();
                Cart cart = (Cart) session.getAttribute("cart");
                for (Product product : (ArrayList<Product>) productsMap.get("products")) {
                    Item addedItem = cart.getItem(product.getId());
                    if (addedItem != null) {
                        product.setQuantity(product.getQuantity() - addedItem.getQuantity());
                    }
                    list.add(product);
                    count++;
                    if (count >= 2) {
                        count = 0;
                        popularProducts.add(list);
                        list = new ArrayList<>();
                    }
                }

                request.setAttribute("products", productsMap.get("products"));
                request.setAttribute("popularProducts", popularProducts);
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "about-us": {
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "information": {
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "policy": {
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "service": {
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "condition": {
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            case "contact-us": {
                request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
                break;
            }
            default:
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
//        processRequest(request, response);
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
