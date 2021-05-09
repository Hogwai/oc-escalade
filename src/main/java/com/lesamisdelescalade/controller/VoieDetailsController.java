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
import com.lesamisdelescalade.consts.LongueurConsts;
import com.lesamisdelescalade.consts.SecteurConsts;
import com.lesamisdelescalade.consts.SiteConsts;
import com.lesamisdelescalade.consts.VoieConsts;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Voie;
import com.lesamisdelescalade.service.CotationService;
import com.lesamisdelescalade.service.LongueurService;
import com.lesamisdelescalade.service.VoieService;

/**
 * Servlet implementation class VoieDetailsController
 */
@WebServlet("/voie")
public class VoieDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(VoieDetailsController.class);
	
	public static final String PARSE_ERROR = "Error occurred during string parsing: %s";
	private static final String ERROR = "Error occurred: %s";
       
	@Autowired
	private VoieService voieService;
	
	@Autowired
	private LongueurService longueurService;
	
	@Autowired
	private CotationService cotationService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer voieId = this.getVoieFromReq(request);
    	Voie currentVoie = voieService.getById(voieId);
    	Secteur currentSecteur = currentVoie.getSecteur();
		Site currentSite = currentVoie.getSecteur().getSite();
		request.setAttribute(VoieConsts.CURRENT_VOIE, currentVoie);
		request.setAttribute(SecteurConsts.CURRENT_SECTEUR, currentSecteur);
		request.setAttribute(SiteConsts.CURRENT_SITE, currentSite);
		this.setDropdownValues(request);
    	this.dispatchSecteurDetailsPage(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer voieId = this.getVoieFromReq(request);
		Integer cotationId = this.getCotationFromReq(request);
		Integer relaiValue = request.getParameter(LongueurConsts.RELAI_YN) == null ? 0 : 1;
		longueurService.addLongueur(voieId, relaiValue, cotationId);
		this.setDropdownValues(request);
    	this.redirectVoieDetailsPage(request, response, voieId);
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
		try {
			this.getServletContext().getRequestDispatcher("/jsp/showVoieDetails.jsp").forward(request, response);
		} catch (IOException | ServletException e) {
			LOGGER.error(String.format(ERROR, e.toString()));
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void redirectVoieDetailsPage(HttpServletRequest request, HttpServletResponse response, Integer voieId) {
		if(voieId != null) {
			try {
				response.sendRedirect(request.getContextPath() + "/voie?voieId=" + voieId.toString());
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
	private Integer getVoieFromReq(HttpServletRequest request) {
		Integer voieId = null;
    	try {
    		voieId = Integer.valueOf(request.getParameter(VoieConsts.VOIE_ID));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return voieId;
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
