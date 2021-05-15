package com.lesamisdelescalade.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lesamisdelescalade.consts.UserInfoConsts;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.UtilisateurService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    private static final long serialVersionUID = 1L;
    
    private static final String LOGIN_JSP = "/jsp/login.jsp";

    @Autowired
	private UtilisateurService utilisateurService;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletContext().getRequestDispatcher(LOGIN_JSP)
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
        String username = request.getParameter(UserInfoConsts.PSEUDO);
        String password = request.getParameter(UserInfoConsts.MOTDEPASSE);

        if (username != null && !username.isEmpty() &&
                (password != null && !password.isEmpty())) {
        	Utilisateur userForSession = utilisateurService.isRegisteredUser(username, password);
            if (userForSession != null) {
            	HttpSession session = request.getSession(true);
    			session.setAttribute(UserInfoConsts.UTILISATEUR, userForSession);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
				request.setAttribute("loginError",
						"Le pseudo et/ou le mot de passe sont incorrects. Veuillez réessayer.");
				this.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
			}
		} else {
			request.setAttribute("loginError", "Veuillez remplir tous les champs.");
			this.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}
    }
}
