package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loki Kun
 */
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductManagementPU");
        EntityManager em = factory.createEntityManager();

        List<Product> allProduct = em.createNamedQuery("Product.findAll", Product.class).getResultList();

        int categoryId = request.getParameter("cateId") == null ? 0 : Integer.parseInt(request.getParameter("cateId"));

        if (categoryId == 0) {
            request.setAttribute("ProductList", allProduct);
        } else {
            List<Product> filterProduct = (List<Product>) allProduct.stream()
                    .filter(p -> p.getCategoryId().getCategoryId() == categoryId)
                    .collect(Collectors.toList());
            request.setAttribute("ProductList", filterProduct);
        }
        RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher("/list/product.jsp");
        dispatcher2.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
