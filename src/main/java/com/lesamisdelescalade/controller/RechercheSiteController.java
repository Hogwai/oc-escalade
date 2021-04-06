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

import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.enums.SiteConsts;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.SiteService;

/**
 * Servlet implementation class RechercheController
 */
@Component
@WebServlet("/recherchesite")
public class RechercheSiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(RechercheSiteController.class);
       
	private static SiteService siteService;
	public RechercheSiteController() {}

	@SuppressWarnings("static-access")
	@Autowired
    public RechercheSiteController(SiteService siteService) {
        super();
        this.siteService = siteService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setSiteService(SiteService siteService) {
    	this.siteService = siteService;
    }
   

    
	public void setDropdownValues(HttpServletRequest request) {
		request.setAttribute(SiteConsts.VILLE_PAYS, siteService.getAllVillePays());
	}
	
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.setDropdownValues(request);
    	try {
            this.getServletContext().getRequestDispatcher("/jsp/searchSite.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String libelle = getParamStrFromReq(request, SiteConsts.LIBELLE);
		String ville = getParamStrFromReq(request, SiteConsts.VILLE);

		Integer nbSecteurMax = getParamIntFromReq(request, SiteConsts.NB_SECTEURS);
		Integer nbVoieMax = getParamIntFromReq(request, SiteConsts.NB_VOIES);
		Integer nbLongueurMax = getParamIntFromReq(request, SiteConsts.NB_LONGUEURS);

		Float hauteur = request.getParameter(SiteConsts.HAUTEUR).isEmpty() ? null
				: Float.valueOf(request.getParameter(SiteConsts.HAUTEUR));
		Integer tagValue = request.getParameter(SiteConsts.TAG) == null ? 0 : 1;

		SearchSiteCriteria criteria = new SearchSiteCriteria(libelle, hauteur, tagValue, ville, nbSecteurMax, nbVoieMax,
				nbLongueurMax, null);
		List<Site> sitesResult = siteService.search(criteria);
		request.setAttribute(SiteConsts.SITES, sitesResult);
		this.dispatchSearchSitePage(request, response);
	}
	
	
	private String getParamStrFromReq(HttpServletRequest request, String parameter) {
		return request.getParameter(parameter).isEmpty() ? null : request.getParameter(parameter);
	}
	
	private Integer getParamIntFromReq(HttpServletRequest request, String parameter) {
		return request.getParameter(parameter).isEmpty() ? null : Integer.valueOf(request.getParameter(parameter));
	}
	

	
	private void dispatchSearchSitePage(HttpServletRequest request, HttpServletResponse response) {
		this.setDropdownValues(request);
		try {
            this.getServletContext().getRequestDispatcher("/jsp/searchSite.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}

}
