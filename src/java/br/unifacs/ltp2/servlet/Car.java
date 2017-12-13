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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adson
 */
public class Car extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConcessionariaDao condao = new ConcessionariaDao();
        ArrayList<Concessionaria> concessionariaList = new ArrayList<>();
        concessionariaList = (ArrayList<Concessionaria>) condao.read();
        request.setAttribute("concessionariaList", concessionariaList);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/registerCar.jsp");
        view.forward( request, response );
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Carro carroModel = new Carro();
        CarroDao carroDao = new CarroDao();
        carroModel.setFabricante((String) request.getParameter("f_nome"));
        carroModel.setModelo((String) request.getParameter("modelo"));
        carroModel.setAno((String) request.getParameter("ano"));
        carroModel.setQuilometragem((String) request.getParameter("qui"));
        carroModel.setPreco((String) request.getParameter("preco"));
        carroModel.setConcessionariaId( Integer.parseInt(request.getParameter("Con")));
        carroDao.add(carroModel);
        response.sendRedirect("/ListCar");   
     
     }

}
