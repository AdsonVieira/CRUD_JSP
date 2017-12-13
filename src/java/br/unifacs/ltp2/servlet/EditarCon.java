/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifacs.ltp2.servlet;

import br.unifacs.ltp2.dao.ConcessionariaDao;
import br.unifacs.ltp2.model.Concessionaria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adson
 */
public class EditarCon extends HttpServlet {

    

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
        if(!request.getParameter("id").isEmpty()){
            ConcessionariaDao conDao =new ConcessionariaDao();
            Concessionaria  conModel =new  Concessionaria();
            conModel = conDao.find(request.getParameter("id"));
            request.setAttribute("conEditId", conModel.getId());
            request.setAttribute("conEditNome", conModel.getNome());
            request.setAttribute("conEditCNPJ", conModel.getCnpj());
            RequestDispatcher view = getServletContext().getRequestDispatcher("/editarCon.jsp");
            view.forward( request, response );
        }else{
            RequestDispatcher view = getServletContext().getRequestDispatcher("/editarCon.jsp");
            view.forward( request, response );
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
        ConcessionariaDao conDao =new ConcessionariaDao();
        Concessionaria  conModel =new  Concessionaria();
        conModel.setId(Integer.parseInt(request.getParameter("idCon")));
        conModel.setNome((String) request.getParameter("nome"));
        conModel.setCnpj((String) request.getParameter("cnpj"));
        conDao.update(conModel);
        response.sendRedirect("/Conce");
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
