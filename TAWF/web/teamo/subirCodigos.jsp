<%-- 
    Document   : subirCodigos
    Created on : 16/07/2020, 01:05:32 PM
    Author     : Anel Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subir Codigos</title>

        <script type="text/javascript">
            function validarExt() {
                var archivoInput = document.getElementById('archivoCodigos');
                var archivoRuta = archivoCodigos.value;
                var extPermitidas = /(.txt)$/i;
                if (!extPermitidas.exec(archivoRuta)) {
                    alert('Asegurese de haber seleccionado un Archivo TXT');
                    archivoCodigos.value = '';
                    return false;
                } else {
                    alert('Archivo Correcto');
                }
            }
            function cargaExitosa() {
                if (archivoCodigos.files && archivoCodigos.files[0])
                {
                    alert('El archivo se subio de forma correcta');
                }
            }
        </script>
    </head>
    <body>
        <section class="contenedor">

            <header>
                <div class="i"><h5>TA</h5><h5 style="color: #00BFFF; padding-left: 5px;"> WF</h5></div><hr class="lun"><div class="lsm"><h6>Refrescate Ya</h6></div>
                <div id="menu">
                    <a href="index.html"><article id="ini"><p id="tm">INICIO</p></article></a>
                    <a href="subirCodigos.jsp"><article id="suba"><p id="tm">SUBIR ARCHIVO</p></article></a>
                </div>
            </header>

            <section class="co2">
                <h1>Subir Archivo Con Codigos</h1>
            </section>

            <section class="cd3">

                <div style="text-align: center">
                    <form action="subirCodigos.jsp" method="POST" style="padding-top: 1%;  color: darkcyan">
                        <div style="font-size: 22px;">
                            <label>Selecciona un archivo .txt:</label><br><br>
                            <div>
                                <input type="file" id="archivoCodigos" accept=".txt" required onchange="return validarExt()" style="height: 110%;">
                            </div>
                        </div>
                        <div style="padding-top: 5%; padding-bottom: 5%;">
                            <div style="display: inline-block">
                                <input type="submit" style="width: 150%; font-size: 20px;" value="Subir" onclick="cargaExitosa()">
                            </div>
                            <div style="display: inline-block; padding-left: 5%">
                                <a href="index.html"><button type="button" class="btn btn-danger" style="width: 150%; font-size: 20px;">Cancelar</button></a> 
                            </div>
                        </div>
                    </form>
                </div>

            </section>

            <footer>
                <center>
                    <div class="c21"> &#174; TAWF. Se reserva los derechos de esta pagina. &#169; Desarrollo Multiplataforma - 4TSM1 - Lopez Cruces Anel</div><br><br>
                </center> 
            </footer>   

        </section>
    </body>
</html>
