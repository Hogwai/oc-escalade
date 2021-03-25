package com.lesamisdelescalade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lesamisdelescalade.enums.SitesConsts;
import com.lesamisdelescalade.enums.UserInfoConsts;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.CommentaireService;
import com.lesamisdelescalade.service.SiteService;

/**
 * Servlet implementation class SiteDetailsController
 */
@Component
@WebServlet("/site")
public class SiteDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(SiteDetailsController.class);
	
	private static final String PARSE_ERROR = "Error occurred during string parsing: %s";
       
	@SuppressWarnings("unused")
	private static SiteService siteService;
	
	@SuppressWarnings("unused")
	private static CommentaireService commentaireService;
	
	public SiteDetailsController() {}

	@SuppressWarnings("static-access")
	@Autowired
    public SiteDetailsController(SiteService siteService, CommentaireService commentaireService) {
        super();
        this.siteService = siteService;
        this.commentaireService = commentaireService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setSiteService(SiteService siteService) {
    	this.siteService = siteService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setCommentaireService(CommentaireService commentaireService) {
    	this.commentaireService = commentaireService;
    }

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer siteId = Integer.valueOf(request.getParameter("siteId"));
    	Site currentSite = siteService.getById(siteId);
		request.setAttribute("currentSite", currentSite);
    	this.dispatchSiteDetailsPage(request, response);
	}
    
    

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer siteId = Integer.valueOf(request.getParameter("siteId"));
		Integer tagValue = request.getParameter("tag") == null ? 0 : 1;
		siteService.updateSiteTag(siteId, tagValue);
		
		Site currentSite = siteService.getById(siteId);
		request.setAttribute("currentSite", currentSite);
		this.redirectSiteDetailsPage(request, response, siteId);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void dispatchSiteDetailsPage(HttpServletRequest request, HttpServletResponse response) {
		try {
            this.getServletContext().getRequestDispatcher("/jsp/showSiteDetails.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void redirectSiteDetailsPage(HttpServletRequest request, HttpServletResponse response, Integer siteId) {
		try {
			response.sendRedirect(request.getContextPath() + "/site?siteId=" + siteId.toString());
		} catch (IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}

}