package controller;

import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static double quantity;
    private static final ArrayList<Product> cart;

    static {
        cart = new ArrayList<>();
    }
    private final ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }
    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "all";
        }
        switch (action) {
            case "sortAsc":
                sortAscProduct(request, response);
                break;
            case "sortDesc":
                sortDescProduct(request, response);
                break;
            case "add":
                addProduct(request, response);
                break;
            case "cart":
                cart(request, response);
                break;
            default:
                displayAllProduct(request, response);
        }
    }

    private void cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        cart.add(product);
        request.setAttribute("cart", cart);
        quantity += 1;
        request.setAttribute("quantity", quantity);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detail.jsp");
        requestDispatcher.forward(request, response);

    }

    private void sortDescProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.sortProductListDesc();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void sortAscProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.sortProductListAsc();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.getProductList();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

//    private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<Product> products = productService.getProducts();
//        request.setAttribute("listProduct", products);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void displayDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.getProduct(id);
//        request.setAttribute("product", product);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-detail.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<String> brands = productService.getBrands();
//        request.setAttribute("brand", brands);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String description = request.getParameter("description");
//        productService.createProduct(new Product(id, name, price, quantity, description));
//        ArrayList<Product> products = productService.getProducts();
//        request.setAttribute("listProduct", products);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.getProduct(id);
//        ArrayList<String> brands = product.getBrands();
//        request.setAttribute("brand", brands);
//        request.setAttribute("product", product);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<Product> products = productService.sortProduct();
//        request.setAttribute("products", products);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<Product> products = productService.getProducts();
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String description = request.getParameter("description");
//        Product product = productService.getProduct(id);
//        int index = -1;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId() == id) {
//                index = i;
//            }
//        }
//        product.editProduct(new Product(id, name, price, quantity, description), index);
//        products = productService.getProducts();
//        request.setAttribute("listProduct", products);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = productService.getProduct(id);
//        product.deleteProduct(product);
//        ArrayList<Product> products = productService.getProducts();
//        request.setAttribute("listProduct", products);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    public ArrayList<Product> sortProductListAsc() {
//        products.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
//        return products;
//    }
//
//    public ArrayList<Product> sortProductListDesc() {
//        products.sort((o1, o2) -> (int) (o2.getPrice() - o1.getPrice()));
//        return products;
//    }

}
