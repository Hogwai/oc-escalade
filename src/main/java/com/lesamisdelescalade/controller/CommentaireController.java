package com.lesamisdelescalade.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lesamisdelescalade.consts.SiteConsts;
import com.lesamisdelescalade.consts.UserInfoConsts;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.CommentaireService;
import com.lesamisdelescalade.service.SiteService;

/**
 * Servlet implementation class CommentaireController
 */
@WebServlet("/commentaire")
public class CommentaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(CommentaireController.class);
	
	private static final String PARSE_ERROR = "Error occurred during string parsing: %s";
       
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private CommentaireService commentaireService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer siteId = getSiteFromReq(request);
		switch (request.getQueryString()) {
			case "delete":
		    	this.deleteComment(request);
		        break;
		    case "add":
		    	this.addComment(request, siteId);
		        break;
		    case "modify":
		    	this.modifyComment(request);
		    	break;
	        default:
	        	break;
		}
		
    	Site currentSite = siteService.getById(siteId);
		request.setAttribute(SiteConsts.CURRENT_SITE, currentSite);
    	this.dispatchSiteDetailsPage(request, response, siteId);
	}
	
	
	
	
	/**
	 * Add new comment
	 * @param request
	 */
	public void addComment(HttpServletRequest request, Integer siteId) {
		String contenu = request.getParameter("commentText");
    	Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute(UserInfoConsts.UTILISATEUR);
    	commentaireService.addComment(contenu, currentUser.getId(), siteId);
	}
	
	/**
	 * Delete comment
	 * @param request
	 */
	public void deleteComment(HttpServletRequest request) {
		Integer commentId = Integer.valueOf(request.getParameter("commentId"));
    	commentaireService.deleteCommentById(commentId);
	}
	
	/**
	 * Modify comment
	 * @param request
	 */
	public void modifyComment(HttpServletRequest request) {
		String contenu = request.getParameter("commentText");
		Integer commentId = Integer.valueOf(request.getParameter("commentId"));
		commentaireService.updateComment(commentId, contenu);
	}
	
	
	/**
	 * Redirect to the site details page
	 * @param request
	 * @param response
	 */
	private void dispatchSiteDetailsPage(HttpServletRequest request, HttpServletResponse response, Integer siteId) {
		try {
			response.sendRedirect(request.getContextPath() + "/site?siteId=" + siteId.toString());
		} catch (IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}
	
	/**
	 * Get site id from request
	 * @param request
	 * 		HttpServletRequest
	 * @return SiteId
	 */
	private Integer getSiteFromReq(HttpServletRequest request) {		
		Integer siteId = null;
    	try {   		
    		siteId = Integer.valueOf(request.getParameter("siteId"));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return siteId;
	}

}
