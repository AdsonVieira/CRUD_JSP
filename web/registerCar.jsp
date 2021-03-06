<%@page import="br.unifacs.ltp2.model.Concessionaria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.unifacs.ltp2.dao.ConcessionariaDao"%>
<%@page import="br.unifacs.ltp2.dao.CarroDao"%>
<%  ArrayList<Concessionaria> conce =(ArrayList<Concessionaria>) request.getAttribute("concessionariaList"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" />
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script> 
            $(document).ready(function() {
                $('select').material_select();
            });
        </script>
        <title>Projeto JSP</title>
    </head>
    <body>
        <div class="row ">
            <%@ include file="layout/menu.jsp" %>
            <div class="col s9 ">
                <h3 style="margin-left: 10px;font-size: 45px;font-weight: 100;color: #222;"> Cadastrar autom�veis <h3>     
                        <div class="row">
                            <form class="col s7" method="POST" action="RegisterCar">  
                                <div class="row">
                                    <div class="input-field col s6">
                                        <input  name="f_nome" type="text" class="validate">
                                        <label for="first_name">Nome do fabricante</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input name="modelo" id="modelo" type="text" class="validate">
                                        <label for="last_name">Modelo</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input name="ano" type="text" class="datepicker">
                                        <label for="last_name">Ano</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input name="qui" type="text" >
                                        <label for="last_name">Quilometragem</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <input name="preco" type="text" >
                                        <label for="last_name">Pre�o</label>
                                    </div>
                                    <div class="input-field col s12">
                                        <select name="Con">
                                            <option value="" disabled selected>Selecione um Concessionaria</option>
                                            <%if(!conce.isEmpty()){%>
                                              <% for(Concessionaria c: conce){ %>
                                                <option value="<%= c.getId() %>"><%= c.getNome() %></option>
                                              <%}%>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="col s12">
                                        <button class="btn">Salvar </button>
                                    </div>
                                    
                                </div>
                                
                               
                            </form>

                        </div>
                        </div>
                        </div>


                        
                        </body>
                        </html>

