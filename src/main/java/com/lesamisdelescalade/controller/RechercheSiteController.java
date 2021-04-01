package com.lesamisdelescalade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.enums.CotationConsts;
import com.lesamisdelescalade.enums.SiteConsts;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.CotationService;
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
	private static CotationService cotationService;
	
	public RechercheSiteController() {}

	@SuppressWarnings("static-access")
	@Autowired
    public RechercheSiteController(SiteService siteService, CotationService cotationService) {
        super();
        this.siteService = siteService;
        this.cotationService = cotationService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setSiteService(SiteService siteService) {
    	this.siteService = siteService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setCotationService(CotationService cotationService) {
    	this.cotationService = cotationService;
    }

    
	public void setDropdownValues(HttpServletRequest request) {
		request.setAttribute(CotationConsts.COTATIONS, cotationService.getAllCotationInfos());
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
		this.setDropdownValues(request);
		SearchSiteCriteria criteria = new SearchSiteCriteria(request.getParameter(SiteConsts.LIBELLE), null, null, null,
				null, null, null, null, null, null);
		List<Site> sitesResult = siteService.search(criteria);
		request.setAttribute(SiteConsts.SITES, sitesResult);
		this.dispatchSearchSitePage(request, response);
	}
	
	

	
	private void dispatchSearchSitePage(HttpServletRequest request, HttpServletResponse response) {
		try {
            this.getServletContext().getRequestDispatcher("/jsp/searchSite.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}

}
