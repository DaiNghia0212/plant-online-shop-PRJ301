package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.account.Account;
import models.cart.Cart;
import models.cart.Item;
import models.category.Category;
import models.category.CategoryFacade;
import models.product.Product;
import models.product.ProductFacade;

/**
 *
 * @author daing
 */
@WebServlet(urlPatterns = {"/admin"})
public class AdminController extends HttpServlet {

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
        processRequest(request, response);
        String action = (String) request.getAttribute("action");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null || account.getRole() != 1) {
            response.sendRedirect(request.getContextPath() + "/home/index.do");
        } else {
            switch (action) {
                case "index": {
                    request.getRequestDispatcher(Config.ADMIN_LAYOUT).forward(request, response);
                    break;
                }
                case "products": {
                    ProductFacade productFacade = new ProductFacade();
                    ArrayList<Integer> checkedCategories = new ArrayList<>();
                    CategoryFacade categoryFacade = new CategoryFacade();
                    Map<String, String> orders = new LinkedHashMap<>();
                    orders.put("updated_at-desc", "Latest");
                    orders.put("name-asc", "Name, A to Z");
                    orders.put("name-desc", "Name, Z to A");
                    orders.put("price-asc", "Price, low to high");
                    orders.put("price-desc", "Price, high to low");
                    Cart cart = (Cart) session.getAttribute("cart");

                    int offset = Integer.parseInt(request.getParameter("offset") != null ? request.getParameter("offset") : "0");
                    int limit = Integer.parseInt(request.getParameter("limit") != null ? request.getParameter("limit") : "6");
                    String search = request.getParameter("search") != null ? request.getParameter("search") : "";
                    String[] categoriesFilter = request.getParameterValues("categories");
                    String selectedOrder = request.getParameter("order") != null && orders.containsKey(request.getParameter("order")) ? request.getParameter("order") : "updated_at-desc";
                    String orderBy = selectedOrder.substring(0, selectedOrder.indexOf("-"));
                    String orderType = selectedOrder.substring(selectedOrder.indexOf("-") + 1, selectedOrder.length());
                    if (categoriesFilter != null) {
                        for (String category : categoriesFilter) {
                            checkedCategories.add(Integer.parseInt(category));
                        }
                    }

                    try {
                        ArrayList<Category> categories = categoryFacade.selectAll();
                        HashMap<String, Object> productsMap;
                        if (checkedCategories.isEmpty()) {
                            productsMap = productFacade.getProducts(orderBy, orderType, offset, limit, search);
                        } else {
                            productsMap = productFacade.getProducts(orderBy, orderType, offset, limit, search, checkedCategories);
                        }
                        ArrayList<Product> products = (ArrayList<Product>) productsMap.get("products");
                        Map<Integer, String> categoryMap = new HashMap();
                        for (Category category : categories) {
                            categoryMap.put(category.getId(), category.getName());
                        }
                        for (Product product : products) {
                            Item addedItem = cart.getItem(product.getId());
                            if (addedItem != null) {
                                product.setQuantity(product.getQuantity() - addedItem.getQuantity());
                            }
                        }
                        int totalProduct = (int) productsMap.get("total");
                        int totalPage = (int) Math.ceil(totalProduct * 1.0 / limit);
                        int currentPage = (offset / limit) + 1;
                        request.setAttribute("products", products);
                        request.setAttribute("totalProduct", totalProduct);
                        request.setAttribute("pageSize", 6);
                        request.setAttribute("totalPage", totalPage);
                        request.setAttribute("currentPage", currentPage);
                        request.setAttribute("search", search);
                        request.setAttribute("categories", categories);
                        request.setAttribute("categoryMap", categoryMap);
                        request.setAttribute("checkedCategories", checkedCategories);
                        request.setAttribute("orders", orders);
                        request.setAttribute("selectedOrder", selectedOrder);
                        request.getRequestDispatcher(Config.ADMIN_LAYOUT).forward(request, response);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                    break;
                }
                case "create-product": {
                    CategoryFacade categoryFacade = new CategoryFacade();
                    try {
                        ArrayList<Category> categories = categoryFacade.selectAll();
                        request.setAttribute("categories", categories);
                        request.getRequestDispatcher(Config.ADMIN_LAYOUT).forward(request, response);
                    } catch (SQLException ex) {
                        log(ex.getMessage());
                    }
                    break;
                }
                case "edit-product": {
                    CategoryFacade categoryFacade = new CategoryFacade();
                    ProductFacade productFacade = new ProductFacade();
                    int id = Integer.parseInt(request.getParameter("id"));
                    try {
                        ArrayList<Category> categories = categoryFacade.selectAll();
                        Product product = productFacade.getProductById(id);
                        request.setAttribute("categories", categories);
                        request.setAttribute("product", product);
                        request.getRequestDispatcher(Config.ADMIN_LAYOUT).forward(request, response);
                    } catch (SQLException ex) {
                        log(ex.getMessage());
                    }
                    break;
                }
                case "delete-product": {
                    ProductFacade productFacade = new ProductFacade();
                    int id = Integer.parseInt(request.getParameter("id"));
                    try {
                        productFacade.delete(id);
                    } catch (SQLException ex) {
                        log(ex.getMessage());
                    }
                    response.sendRedirect(request.getContextPath() + "/admin/products.do");
                    break;
                }
                case "orders": {
                    request.getRequestDispatcher(Config.ADMIN_LAYOUT).forward(request, response);
                    break;
                }
                case "order-detail": {
                    request.getRequestDispatcher(Config.ADMIN_LAYOUT).forward(request, response);
                    break;
                }
            }
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
        String action = (String) request.getAttribute("action");
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null || account.getRole() != 1) {
            response.sendRedirect(request.getContextPath() + "/home/index.do");
        } else {
            switch (action) {
                case "create-product": {
                    String name = request.getParameter("name");
                    Double price = Double.parseDouble(request.getParameter("price"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    int categoryId = Integer.parseInt(request.getParameter("category"));
                    String description = request.getParameter("description");
                    String imagePath = "/assets/images/product/new_product.webp";

                    ProductFacade productFacade = new ProductFacade();
                    Product product = new Product(name, price, quantity, imagePath, description, categoryId);
                    try {
                        productFacade.insert(product);
                        response.sendRedirect(request.getContextPath() + "/admin/products.do");
                    } catch (SQLException ex) {
                        log(ex.getMessage());
                    }
                    break;
                }
                case "edit-product": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                    Double price = Double.parseDouble(request.getParameter("price"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    int categoryId = Integer.parseInt(request.getParameter("category"));
                    String description = request.getParameter("description");
                    String imagePath = "/assets/images/product/new_product.webp";

                    ProductFacade productFacade = new ProductFacade();
                    Product product = new Product(id, name, price, quantity, imagePath, description, categoryId);
                    try {
                        productFacade.updateProduct(product);
                        response.sendRedirect(request.getContextPath() + "/admin/products.do");
                    } catch (SQLException ex) {
                        log(ex.getMessage());
                    }
                    break;
                }
            }
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
    }// </editor-fold>

}
