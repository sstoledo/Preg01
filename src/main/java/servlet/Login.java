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

@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        JSONObject respuesta = new JSONObject();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

        JSONObject json = new JSONObject(sb.toString());
        String dni = json.getString("login");
        String password = json.getString("password");

        // validar login y password que no sean nulos o vacios
        if (dni.isEmpty() || password.isEmpty()) {
            respuesta.put("error", "Login y/o contraseña vacíos");
            out.println(respuesta.toString());
            return;
        }

        AlumnowebJpaController dao = new AlumnowebJpaController();

        // validar si el usuario existe
        int validacion = dao.validarUsuario(dni, password);
        if (validacion == 1) {
            respuesta.put("success", true);
        } else if (validacion == 0) {
            respuesta.put("error", "Usuario no encontrado");
        } else if (validacion == -1) {
            respuesta.put("error", "Contraseña incorrecta");
        } else {
            respuesta.put("error", "Error desconocido");
        }

        out.println(respuesta.toString());

    }
}
