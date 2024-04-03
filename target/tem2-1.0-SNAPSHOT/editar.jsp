<%@page import="com.my.emergentes2.est.Estudiantes"%>
<%
    Estudiantes est = (Estudiantes) request.getAttribute("miobjest");
    // Calcula la suma de P1, P2 y P3
    int suma = est.getP1() + est.getP2() + est.getP3();
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <div class="encabezado">
            <h1>PRIMER PARCIAL TEM-742</h1>
            <p>Nombre: Jhymi Rojas Sausedo</p>
            <p>Carnet: 10064526</p>
        </div>

        <h2><span style="font-weight: bold;">Reguistro de Calificaciones</span></h2>
        <div class="encabezado">
            <form action="MainServlet" method="post" >
                <table>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="id" value="<%= est.getId()%>" size="2" readonly></td>
                    </tr>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="nombre" value="<%= est.getNombre()%>"></td>
                    </tr>
                    <tr>    
                        <td>P1(30)</td>
                        <td><input type="text" name="p1"id="1" value="<%= est.getP1()%>" min="0" max="30" oninput="calcularSuma()"></td>
                    </tr>
                    <tr>
                        <td>P2(30)</td>
                        <td><input type="text" name="p2" id="2" value="<%= est.getP2()%>" min="0" max="30" oninput="calcularSuma()"></td>
                    </tr>
                    <tr>
                        <td>P3(40)</td>
                        <td><input type="text" name="p3" id="3" value="<%= est.getP3()%>" min="0" max="40" oninput="calcularSuma()"></td>
                    </tr>
                    <tr>
                        <td>Nota</td>
                        <td><input type="text" name="nota" id="nota" value="<%= est.getP1() + est.getP2() + est.getP3()%>" size="2" readonly></td>
                    </tr>
                </table>
        </div>

        <button href="MainServlet?op=enviar"  type="submit" onclick="return validarCampos()" >Enviar</button>
    </form>
    <script>
        function calcularSuma() {
            var p1 = parseInt(document.getElementById("1").value);
            var p2 = parseInt(document.getElementById("2").value);
            var p3 = parseInt(document.getElementById("3").value);
            var suma = p1 + p2 + p3;
            document.getElementById("nota").value = suma;
        }
         function validarCampos() {
            // Obtener los valores de los campos
            var p1 = parseInt(document.getElementById("1").value);
            var p2 = parseInt(document.getElementById("2").value);
            var p3 = parseInt(document.getElementById("3").value);
            // Verificar si los valores exceden los límites
            if (p1 > 30 || p2 > 30 || p3 > 40) {
                alert("Error: Los valores de P1, P2 o P3 no pueden exceder los límites permitidos.");
                return false; // Evitar el envío del formulario
            }
            // Si no se exceden los límites, permitir el envío del formulario
            return true;
        }
    </script>
</body>
</html>
