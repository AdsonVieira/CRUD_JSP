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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adson
 */
public class DeletarCon extends HttpServlet {

    

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
        
        ConcessionariaDao cDaoDelete = new ConcessionariaDao();
        Concessionaria   cModel = new Concessionaria();
        cModel.setId(Integer.parseInt(request.getParameter("id")));
        cDaoDelete.delete(cModel);
        response.sendRedirect("/Conce");
    }

    

}
