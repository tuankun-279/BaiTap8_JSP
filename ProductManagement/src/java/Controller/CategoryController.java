/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loki Kun
 */
public class CategoryController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductManagementPU");
        EntityManager em = factory.createEntityManager();
        
        List<Category> list = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        
        request.setAttribute("CategoryList", list);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list/category.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductManagementPU");
        EntityManager em = factory.createEntityManager();
        
        List<Category> list = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        
        request.setAttribute("CategoryList", list);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list/category.jsp");
        dispatcher.forward(request, response);
    
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
