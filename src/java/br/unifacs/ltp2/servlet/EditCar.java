/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifacs.ltp2.servlet;

import br.unifacs.ltp2.dao.CarroDao;
import br.unifacs.ltp2.dao.ConcessionariaDao;
import br.unifacs.ltp2.model.Carro;
import br.unifacs.ltp2.model.Concessionaria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adson
 */
public class EditCar extends HttpServlet {

    

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
        CarroDao cDaoEdit = new CarroDao();
        Carro carroEdit = new Carro();
        carroEdit = cDaoEdit.Find(request.getParameter("id"));
        request.setAttribute("IdCar", carroEdit.getId());
        request.setAttribute("fabricante", carroEdit.getFabricante());
        request.setAttribute("modelo", carroEdit.getModelo());
        request.setAttribute("ano", carroEdit.getAno());
        request.setAttribute("qui", carroEdit.getQuilometragem());
        request.setAttribute("pre", carroEdit.getPreco());
        request.setAttribute("con", carroEdit.getConcessionariaId());
        
        ConcessionariaDao condao = new ConcessionariaDao();
        ArrayList<Concessionaria> concessionariaList = new ArrayList<>();
        concessionariaList = (ArrayList<Concessionaria>) condao.read();
        request.setAttribute("concessionariaList", concessionariaList);
        
        RequestDispatcher view = getServletContext().getRequestDispatcher("/editarCar.jsp");
        view.forward( request, response );
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
        
        Carro carroModel = new Carro();
        CarroDao carroDao = new CarroDao();
        carroModel.setId(Integer.parseInt(request.getParameter("idCar")));
        carroModel.setFabricante((String) request.getParameter("f_nome"));
        carroModel.setModelo((String) request.getParameter("modelo"));
        carroModel.setAno((String) request.getParameter("ano"));
        carroModel.setQuilometragem((String) request.getParameter("qui"));
        carroModel.setPreco((String) request.getParameter("preco"));
        carroModel.setConcessionariaId(Integer.parseInt(request.getParameter("Con")));
        carroDao.update(carroModel);
        response.sendRedirect("/ListCar");   
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
