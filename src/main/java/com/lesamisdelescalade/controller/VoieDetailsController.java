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
import org.springframework.stereotype.Component;

import com.lesamisdelescalade.enums.SecteurConsts;
import com.lesamisdelescalade.enums.SiteConsts;
import com.lesamisdelescalade.enums.VoieConsts;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Voie;
import com.lesamisdelescalade.service.SecteurService;
import com.lesamisdelescalade.service.SiteService;
import com.lesamisdelescalade.service.VoieService;

/**
 * Servlet implementation class VoieDetailsController
 */
@Component
@WebServlet("/voie")
public class VoieDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(VoieDetailsController.class);
	
	public static final String PARSE_ERROR = "Error occurred during string parsing: %s";
       
	@SuppressWarnings("unused")
	private static SiteService siteService;
	
	@SuppressWarnings("unused")
	private static SecteurService secteurService;
	
	@SuppressWarnings("unused")
	private static VoieService voieService;
	
	public VoieDetailsController() {}

	@SuppressWarnings("static-access")
	@Autowired
    public VoieDetailsController(SiteService siteService, SecteurService secteurService, VoieService voieService) {
        super();
        this.siteService = siteService;
        this.secteurService = secteurService;
        this.voieService = voieService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setSiteService(SiteService siteService) {
    	this.siteService = siteService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setSecteurService(SecteurService secteurService) {
    	this.secteurService = secteurService;
    }
    
    @SuppressWarnings("static-access")
   	@Autowired
	public void setVoieService(VoieService voieService) {
		this.voieService = voieService;
	}

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer voieId = null;
    	try {
    		voieId = Integer.valueOf(request.getParameter("voieId"));
		} catch (NumberFormatException e) {
			LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	Voie currentVoie = voieService.getById(voieId);
    	Secteur currentSecteur = currentVoie.getSecteur();
		Site currentSite = currentVoie.getSecteur().getSite();
		request.setAttribute(VoieConsts.CURRENT_VOIE, currentVoie);
		request.setAttribute(SecteurConsts.CURRENT_SECTEUR, currentSecteur);
		request.setAttribute(SiteConsts.CURRENT_SITE, currentSite);
    	this.dispatchSecteurDetailsPage(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void dispatchSecteurDetailsPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			this.getServletContext().getRequestDispatcher("/jsp/showVoieDetails.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			LOGGER.error(String.format("Error occurred: %s", e.toString()));
		}
	}

}
