package com.lesamisdelescalade.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lesamisdelescalade.dao.UtilisateurDao;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Controller
@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    private static final long serialVersionUID = 1L;

    //private final ControllerCtx context;
    
    @Autowired
    private UtilisateurDao utilisateurDao;*/

    /*public LoginController() {
        super();
        this.context = new ControllerCtx();
    }*/


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            validateAuthentication(req, resp);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }

    }

    private void validateAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && !username.isEmpty() &&
                (password != null && !password.isEmpty())) {
            if (Boolean.TRUE.equals(utilisateurDao.isRegisteredUser(username, password))) {
           //if (Boolean.TRUE.equals(context.getUtilisateurDao().isRegisteredUser(username, password))) {
                HttpSession session = request.getSession(true);
                session.setAttribute( "login", username);
                session.setAttribute( "password", password);

                request.getRequestDispatcher("jsp/loginSuccess.jsp").forward(request, response);
            } else {
                throw new ServletException("Login not successful..");
            }
        }
    }
}
