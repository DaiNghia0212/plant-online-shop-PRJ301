/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.account.Account;
import models.account.AccountFacade;

/**
 *
 * @author daing
 */
@WebServlet(name = "Authentication", urlPatterns = {"/auth"})
public class AuthenticationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AuthenticationController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AuthenticationController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
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
        switch (action) {
            case "login": {
                request.getRequestDispatcher("/WEB-INF/pages/authentication/login.jsp").forward(request, response);
                break;
            }
            case "register": {
                request.getRequestDispatcher("/WEB-INF/pages/authentication/register.jsp").forward(request, response);
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
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "login": {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Account account = null;
                try {
                    account = AccountFacade.selectByEmail(email);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    // Need to show the error 500 page
                }
                if (account != null && password.equals(account.getPassword())) {
                    response.sendRedirect(request.getContextPath() + "/home/index.do");
                } else {
                    if (account == null) {
                        request.setAttribute("message", "Invalid email");
                    } else {
                        request.setAttribute("message", "Wrong password");
                    }
                    request.getRequestDispatcher("/WEB-INF/pages/authentication/login.jsp").forward(request, response);
                }
                break;
            }
            case "register": {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                int status = 1;
                int role = 0;
                Account account = new Account(email, password, name, phone, status, role);
                try {
                    AccountFacade.insert(account);
//                    show successfully register page
                      response.sendRedirect(request.getContextPath() + "/home/index.do");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    // Need to show the error 500 page
                }
                break;
            }
            case "logout": {
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    Account account = AccountFacade.selectById(id);
                    account.setStatus(0);
                    AccountFacade.update(account);
                    response.sendRedirect(request.getContextPath() + "/auth/login.do");
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            }
            default:
            // need to show the error 404 page
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>

}
