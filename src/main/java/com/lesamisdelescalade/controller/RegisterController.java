package com.lesamisdelescalade.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lesamisdelescalade.enums.UserInfoConsts;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.UtilisateurService;

/**
 * Servlet implementation class RegisterController
 */
@Component
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	protected static final Logger LOGGER = LogManager.getLogger(RegisterController.class);
	private static final long serialVersionUID = 1L;
	
	private static UtilisateurService utilisateurService;
	
	public RegisterController() {}
	
	@SuppressWarnings("static-access")
	@Autowired
    public RegisterController(UtilisateurService utilisateurService) {
        super();
        this.utilisateurService = utilisateurService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setUtilisateurService(UtilisateurService utilisateurService) {
    	this.utilisateurService = utilisateurService;
    }
       
    
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            this.getServletContext().getRequestDispatcher("/jsp/register.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }

    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			registerUser(request, response);
		}catch (ServletException | IOException e) {
			LOGGER.error(String.format("Error occurred: %s", e.toString()));
		}
	}
	
    private void registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HashMap<String, String> userInfos = new HashMap<>();
		userInfos.put(UserInfoConsts.PSEUDO, request.getParameter(UserInfoConsts.PSEUDO));
		userInfos.put(UserInfoConsts.MOTDEPASSE, request.getParameter(UserInfoConsts.MOTDEPASSE));
		userInfos.put(UserInfoConsts.NUMTEL, request.getParameter(UserInfoConsts.NUMTEL));
		userInfos.put(UserInfoConsts.ADRESSE, request.getParameter(UserInfoConsts.ADRESSE));
		userInfos.put(UserInfoConsts.CODEPOSTAL, request.getParameter(UserInfoConsts.CODEPOSTAL));
		userInfos.put(UserInfoConsts.EMAIL, request.getParameter(UserInfoConsts.EMAIL));
		userInfos.put(UserInfoConsts.NOM, request.getParameter(UserInfoConsts.NOM));
		userInfos.put(UserInfoConsts.PRENOM, request.getParameter(UserInfoConsts.PRENOM));
		userInfos.put(UserInfoConsts.MEMBREASSOYN, request.getParameter(UserInfoConsts.MEMBREASSOYN) == null ? "0" : "1");
		Utilisateur userForSession = utilisateurService.registerUser(userInfos);
        if (userForSession != null) {
        	HttpSession session = request.getSession(true);
			session.setAttribute(UserInfoConsts.UTILISATEUR, userForSession);
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			request.setAttribute("registerError", "Veuillez remplir tous les champs.");
			this.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
		}
    }
}
