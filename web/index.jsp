<%@page import="br.unifacs.ltp2.dao.ConcessionariaDao"%>
<%@page import="br.unifacs.ltp2.dao.CarroDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="css/style.css" rel="stylesheet" />
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <title>Projeto JSP</title>
    </head>
    <body>
        <div class="row ">
            <%@ include file="layout/menu.jsp" %>
            <div class="col s9 ">
                <h3 style="margin-left: 10px;font-size: 45px;font-weight: 100;color: #222;"> Painel de controle </h3>     
                <div class="row">
                    <div class="col s12 m5">
                        <div class="card teal darken-1">
                            <div class="card-content white-text">
                              <span class="card-title">Total de carros</span>
                              <p>
                                  <%= request.getAttribute("totalCar") %>
                              </p>
                            </div>
                        </div>
                    </div>
                    <div class="col s12 m5">
                        <div class="card teal darken-1">
                            <div class="card-content white-text">
                                <span class="card-title">Total de Concessionárias</span>
                               <p>
                                  <%= request.getAttribute("totalCon") %>
                              </p>
                            </div>
                        </div>
                    </div>
                              
                </div>
            </div>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    <script  type="text/javascript" src="js/functions.js"> </script>
</html>
