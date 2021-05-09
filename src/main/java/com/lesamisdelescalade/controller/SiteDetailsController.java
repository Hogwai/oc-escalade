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

import com.lesamisdelescalade.consts.SecteurConsts;
import com.lesamisdelescalade.consts.SiteConsts;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.SecteurService;
import com.lesamisdelescalade.service.SiteService;

/**
 * Servlet implementation class SiteDetailsController
 */
@WebServlet("/site")
public class SiteDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(SiteDetailsController.class);
	
	private static final String PARSE_ERROR = "Error occurred during string parsing: %s";
	private static final String ERROR = "Error occurred: %s";
       
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private SecteurService secteurService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer siteId = this.getSiteFromReq(request);
    	Site currentSite = siteService.getById(siteId);
		request.setAttribute(SiteConsts.CURRENT_SITE, currentSite);
    	this.dispatchSiteDetailsPage(request, response);
	}
    
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer siteId = this.getSiteFromReq(request);
		if (request.getQueryString().equals(SiteConsts.MODIFY_TAG)) {
			Integer tagValue = request.getParameter(SiteConsts.TAG_YN) == null ? 0 : 1;
			siteService.updateSiteTag(siteId, tagValue);
		} else {
			String libelleSecteur = request.getParameter(SecteurConsts.LIBELLE_SECTEUR);
			secteurService.addSecteur(libelleSecteur, siteId);
		}
		
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
            LOGGER.error(String.format(ERROR, e.toString()));
        }
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void redirectSiteDetailsPage(HttpServletRequest request, HttpServletResponse response, Integer siteId) {
		if(siteId != null) {
			try {
				response.sendRedirect(request.getContextPath() + "/site?siteId=" + siteId.toString());
			} catch (IOException e){
	            LOGGER.error(String.format(ERROR, e.toString()));
	        }
		} else {
			this.getServletContext().getRequestDispatcher("/jsp/error.jsp");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
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
