<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.unifacs.ltp2.dao.ConcessionariaDao"%>
<%@page import="br.unifacs.ltp2.dao.CarroDao"%>

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
                <h3 style="margin-left: 10px;font-size: 45px;font-weight: 100;color: #222;"> Editar Concessionária <h3>     
                    <div class="row">
                        <form class="col s7" method="POST" action="EditarCon"> 
                            <input type="hidden" value="<%= request.getAttribute("conEditId") %>" name="idCon"/>
                            <div class="row">
                                <div class="input-field col s12">
                                    <input  name="nome" type="text" class="validate" value="<%= request.getAttribute("conEditNome") %>">
                                    <label for="first_name">Nome da Concessionária</label>
                                </div>
                                <div class="input-field col s12">
                                    <input name="cnpj" id="modelo" type="text" class="validate" value="<%= request.getAttribute("conEditCNPJ") %>">
                                    <label for="last_name">CNPJ</label>
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


