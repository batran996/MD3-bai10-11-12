package com.example.rikkei.controller;

import com.example.rikkei.model.Product;
import com.example.rikkei.service.IProductService;
import com.example.rikkei.service.ProductServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/", "/view"})
public class ProductControllerServlet extends HttpServlet {
    IProductService productService = new ProductServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            default:

                break;
        }
        showListProduct(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findByID(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.finAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                actionCreateProduct(request, response);
                break;
            case "edit":
                actionEditProduct(request, response);
                break;
            case "delete":
                actionDeleteProduct(request, response);
                break;
            default:
                actionSearchProduct(request,response);

        }
    }

    private void actionSearchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("search");
        List<Product>listSearch = productService.findByName(nameSearch);
        System.out.println(listSearch);
        request.setAttribute("productList",listSearch);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(request,response);

    }

    private void actionDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        request.setAttribute("message", "Delete success!");
        List<Product> productList = productService.finAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void actionEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findByID(id);
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int storage = Integer.parseInt(request.getParameter("storage"));
        product.setName(name);
        product.setPrice(price);
        product.setStorage(storage);
        productService.save(product);
        request.setAttribute("message", "Update success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/edit.jsp");
        dispatcher.forward(request, response);

    }

    private void actionCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        int storage = Integer.parseInt(request.getParameter("storage"));
        Product product = new Product(name, price, storage);
        productService.save(product);
        request.setAttribute("message", "Create success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(request, response);
    }

}
