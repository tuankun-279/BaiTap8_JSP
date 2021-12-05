/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Category;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loki Kun
 */
public class AssignController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product pro = new Product(0);
        
       
         
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductManagementPU");
        EntityManager em = factory.createEntityManager();
        
        List<Category> list = em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        
        if(request.getParameter("proId") != null){
           int id = Integer.parseInt(request.getParameter("proId"));
            pro = em.find(Product.class, id);
        }
        request.setAttribute("categories", list);
        request.setAttribute("pro", pro);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list/assign.jsp");
        dispatcher.forward(request, response);
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
        
        String id = request.getParameter("proId");
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProductManagementPU");
        EntityManager em = factory.createEntityManager();
        
        if(id != null && !id.isEmpty()){
            Product pro = em.find(Product.class, Integer.parseInt(id));
            int cateid = Integer.parseInt(request.getParameter("category"));
            
            Category cate = em.find(Category.class, cateid);
            
            em.getTransaction().begin();
            pro.setCategoryId(cate);
            em.getTransaction().commit();
        }
        response.sendRedirect("/ProductManagement/categories");
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
