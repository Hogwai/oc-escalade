package com.lesamisdelescalade.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.persistence.EntityExistsException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lesamisdelescalade.consts.UserInfoConsts;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.UtilisateurService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	protected static final Logger LOGGER = LogManager.getLogger(RegisterController.class);
	private static final long serialVersionUID = 1L;
	private static final String REGISTER_ERROR = "registerError";
	private static final String REGISTER_JSP = "/jsp/register.jsp";

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
			this.getServletContext().getRequestDispatcher(REGISTER_JSP).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(String.format("Error occurred: %s", e.toString()));
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			registerUser(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(String.format("Error occurred: %s", e.toString()));
		}
	}

	/**
	 * Register a new user
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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
		userInfos.put(UserInfoConsts.MEMBREASSOYN,
				request.getParameter(UserInfoConsts.MEMBREASSOYN) == null ? "0" : "1");

		Utilisateur userForSession = null;
		try {
			userForSession = utilisateurService.registerUser(userInfos);
		} catch (EntityExistsException e) {
			request.setAttribute(REGISTER_ERROR,
					"Les informations saisies existent déjà en base. Veuillez les modifier.");
			this.getServletContext().getRequestDispatcher(REGISTER_JSP).forward(request, response);
			return;
		}

		if (userForSession != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute(UserInfoConsts.UTILISATEUR, userForSession);
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			request.setAttribute(REGISTER_ERROR, "Veuillez remplir tous les champs.");
			this.getServletContext().getRequestDispatcher(REGISTER_JSP).forward(request, response);
		}
	}
}
