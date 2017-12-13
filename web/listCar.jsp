<%@page import="br.unifacs.ltp2.model.Carro"%>
<%@page import="br.unifacs.ltp2.model.Concessionaria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.unifacs.ltp2.dao.ConcessionariaDao"%>
<%@page import="br.unifacs.ltp2.dao.CarroDao"%>
<%  ArrayList<Carro> CarroList = (ArrayList<Carro>) request.getAttribute("carroList");%>
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
        <script src="/js/functions.js"></script>
        <title>Projeto JSP</title>
    </head>
    <body>
        <div class="row ">
            <%@ include file="layout/menu.jsp" %>
            <div class="col s9 ">
                <h3 style="margin-left: 10px;font-size: 45px;font-weight: 100;color: #222;"> Lista de autom�veis </h3>     
                        <div class="row">
                            <% if(!CarroList.isEmpty()){ %>
                                <table class="striped"s>
                                    <thead>
                                        <tr>
                                            <th>Fabricante</th>
                                            <th>Modelo</th>
                                            <th>Pre�o</th>
                                            <th>Quilometragem</th>
                                            <th>Ano</th>
                                            <th>Concessionaria</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(Carro c: CarroList){ %>
                                        <tr>
                                            <td><%=c.getFabricante()%></td>
                                            <td><%=c.getModelo()%></td>
                                            <td><%=c.getPreco()%></td>
                                            <td><%=c.getQuilometragem()%></td>
                                            <td><%=c.getAno()%></td>
                                            <td><%=c.getConcessionariaString()%></td>
                                            <td>
                                                <a class="btn-floating waves-effect waves-light blue darken-2"  href="/EditCar?id=<%=c.getId()%>">
                                                    <i class="material-icons">create</i>
                                                </a> 
                                            </td>
                                            <td>
                                                <a class="btn-floating waves-effect waves-light red sdarken-2"  href="/ModifyCar?id=<%=c.getId()%>">
                                                    <i class="material-icons">delete_forever</i>
                                                </a> 
                                            </td>
                                        </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            <%}else{%>
                                <blockquote>
                                    N�o h� carros para listar
                                </blockquote>
                            <%}%>
                        </div>
                        </div>
                        </div>



                        </body>
                        </html>


