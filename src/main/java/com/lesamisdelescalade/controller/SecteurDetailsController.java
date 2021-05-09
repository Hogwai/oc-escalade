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

import com.lesamisdelescalade.consts.CotationConsts;
import com.lesamisdelescalade.consts.SecteurConsts;
import com.lesamisdelescalade.consts.SiteConsts;
import com.lesamisdelescalade.consts.VoieConsts;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.CotationService;
import com.lesamisdelescalade.service.SecteurService;
import com.lesamisdelescalade.service.SiteService;
import com.lesamisdelescalade.service.VoieService;

/**
 * Servlet implementation class SiteDetailsController
 */
@WebServlet("/secteur")
public class SecteurDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(SecteurDetailsController.class);
	
	public static final String PARSE_ERROR = "Error occurred during string parsing: %s";
	private static final String ERROR = "Error occurred: %s";
       
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private SecteurService secteurService;
	
	@Autowired
	private CotationService cotationService;
	
	@Autowired
	private VoieService voieService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer secteurId = this.getSecteurFromReq(request);
    	Secteur currentSecteur = secteurService.getById(secteurId);
		Site currentSite = siteService.getById(currentSecteur.getSite().getId());
		request.setAttribute(SiteConsts.CURRENT_SITE, currentSite);
		request.setAttribute(SecteurConsts.CURRENT_SECTEUR, currentSecteur);
		this.setDropdownValues(request);
    	this.dispatchSecteurDetailsPage(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer secteurId = this.getSecteurFromReq(request);
		Integer cotationId = this.getCotationFromReq(request);
		Integer tagValue = request.getParameter(VoieConsts.EQUIPEE_YN) == null ? 0 : 1;
		voieService.addVoie(secteurId, tagValue, cotationId);
		this.setDropdownValues(request);
    	this.redirectSecteurDetailsPage(request, response, secteurId);
	}
	
	/**
	 * 
	 * @param request
	 */
	public void setDropdownValues(HttpServletRequest request) {
		request.setAttribute(CotationConsts.COTATIONS, cotationService.getAllCotationInfos());
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void dispatchSecteurDetailsPage(HttpServletRequest request, HttpServletResponse response) {
		this.setDropdownValues(request);
		try {
			this.getServletContext().getRequestDispatcher("/jsp/showSecteurDetails.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			LOGGER.error(String.format(ERROR, e.toString()));
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void redirectSecteurDetailsPage(HttpServletRequest request, HttpServletResponse response, Integer secteurId) {
		if(secteurId != null) {
			try {
				response.sendRedirect(request.getContextPath() + "/secteur?secteurId=" + secteurId.toString());
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
	private Integer getSecteurFromReq(HttpServletRequest request) {
		Integer secteurId = null;
    	try {
    		secteurId = Integer.valueOf(request.getParameter(SecteurConsts.SECTEUR_ID));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return secteurId;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private Integer getCotationFromReq(HttpServletRequest request) {
		Integer cotationId = null;
    	try {
    		cotationId = Integer.valueOf(request.getParameter(CotationConsts.COTATION));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return cotationId;
	}

}
