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
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.SecteurService;
import com.lesamisdelescalade.service.SiteService;

/**
 * Servlet implementation class SiteDetailsController
 */
@Component
@WebServlet("/secteur")
public class SecteurDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(SecteurDetailsController.class);
	
	public static final String PARSE_ERROR = "Error occurred during string parsing: %s";
       
	@SuppressWarnings("unused")
	private static SiteService siteService;
	
	@SuppressWarnings("unused")
	private static SecteurService secteurService;
	
	public SecteurDetailsController() {}

	@SuppressWarnings("static-access")
	@Autowired
    public SecteurDetailsController(SiteService siteService, SecteurService secteurService) {
        super();
        this.siteService = siteService;
        this.secteurService = secteurService;
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

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer secteurId = Integer.valueOf(request.getParameter("secteurId"));
    	/*try {
    		secteurId = Integer.valueOf(request.getPathInfo().replace("/", ""));
		} catch (NumberFormatException e) {
			LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}*/
    	
    	Secteur currentSecteur = secteurService.getById(secteurId);
		Site currentSite = siteService.getById(currentSecteur.getSite().getId());
		request.setAttribute(SiteConsts.CURRENT_SITE, currentSite);
		request.setAttribute(SecteurConsts.CURRENT_SECTEUR, currentSecteur);
    	this.dispatchSecteurDetailsPage(request, response, currentSite.getId(), currentSecteur.getId());
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
	private void dispatchSecteurDetailsPage(HttpServletRequest request, HttpServletResponse response, Integer siteId,
			Integer secteurId) {
		try {
			/*response.sendRedirect(
					request.getContextPath() + "/site/" + siteId.toString() + "/secteur/" + secteurId.toString());*/
			/*response.sendRedirect(
					request.getContextPath() + "/secteur?secteurId=" + secteurId.toString());*/
			this.getServletContext().getRequestDispatcher("/jsp/showSecteurDetails.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			LOGGER.error(String.format("Error occurred: %s", e.toString()));
		}
	}

}
