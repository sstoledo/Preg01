package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.AlumnowebJpaController;
import dto.AlumnoWeb;

@WebServlet(name = "Clave", urlPatterns = { "/clave" })
public class Clave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        JSONObject respuesta = new JSONObject();
        AlumnowebJpaController dao = new AlumnowebJpaController();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        JSONObject json = new JSONObject(sb.toString());

        // obtenemos el usuario, contraseña actual y la nueva contraseña
        String usuario = json.getString("usuario");
        String contraseñaActual = json.getString("contraseñaActual");
        String contraseñaNueva = json.getString("contraseñaNueva");

        // validamos que no sean nulos o vacios
        if (contraseñaActual.isEmpty() || contraseñaNueva.isEmpty()) {
            respuesta.put("error", "Contraseña vacía");
            out.println(respuesta.toString());
            return;
        }

        // validamos que el usuario exista con su password
        if (dao.validarUsuario(usuario, contraseñaActual) == 0) {
            respuesta.put("error", "Usuario no encontrado");
            out.println(respuesta.toString());
            return;
        }

        // seteamos la nueva contraseña
        AlumnoWeb alu = dao.findAlumnoweb(usuario);
        alu.setPassEstd(dao.hashPassword(contraseñaNueva));
        try {
            dao.edit(alu);
            respuesta.put("success", true);
            out.println(respuesta.toString());
        } catch (Exception e) {
            // TODO: handle exception
            respuesta.put("error", "Error al actualizar la contraseña");
            out.println(respuesta.toString());
        }

    }
}
