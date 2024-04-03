package com.emegentes2.controlador;

import com.my.emergentes2.te_exameneqa.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Estudiantes objest = new Estudiantes();
        int id, pos;
        HttpSession ses = request.getSession();
        ArrayList<Estudiantes> lista = (ArrayList<Estudiantes>) ses.getAttribute("listaest");
        switch (op) {
            case "nuevo":
//Enviar un objeto vacio a editar
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
// Enviar un objeto a editar pero con contenido
                id = Integer.parseInt(request.getParameter("id"));
// Averiguar la posición del elemento en la lista
                pos = buscarPorIndice(request, id);
// Obtener el objeto
                objest = lista.get(pos);
                request.setAttribute("miobjest", objest);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
// Eliminar el registro de la colección segun el id
                id = Integer.parseInt(request.getParameter("id"));
// Averiguar la posición del elemento en la lista
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
                break;
            default:

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Estudiantes> lista = (ArrayList<Estudiantes>) ses.getAttribute("listaest");
        Estudiantes objest = new Estudiantes();
        objest.setId(id);
        objest.setNombre(request.getParameter("nombre"));
        objest.setP1(Integer.parseInt(request.getParameter("p1")));
        objest.setP2(Integer.parseInt(request.getParameter("p2")));
        objest.setP3(Integer.parseInt(request.getParameter("p3")));
        if (id == 0) {

// Nuevo registro
            int idNuevo = obtenerId(request);
            objest.setId(idNuevo);
            lista.add(objest);
        } else {
// edicion de registro
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objest);
        }
        request.setAttribute("listaest", lista);
        response.sendRedirect("index.jsp");
    }

    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiantes> lista = (ArrayList<Estudiantes>) ses.getAttribute("listaest");
        int pos = -1;
        if (lista != null) {
            for (Estudiantes est : lista) {
                ++pos;
                if (est.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }

    public int obtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Estudiantes> lista = (ArrayList<Estudiantes>) ses.getAttribute("listaest");
// Buscar el ultimo id
        int idn = 0;
        for (Estudiantes est : lista) {
            idn = est.getId();
        }
        return idn + 1;
    }
}
