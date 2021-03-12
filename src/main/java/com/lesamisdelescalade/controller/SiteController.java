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

import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.SiteService;

/**
 * Servlet implementation class SiteController
 */
@Component
@WebServlet("/site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(SiteController.class);
       
	private static SiteService siteService;
	
	public SiteController() {}

	@SuppressWarnings("static-access")
	@Autowired
    public SiteController(SiteService siteService) {
        super();
        this.siteService = siteService;
    }
    
    @SuppressWarnings("static-access")
	@Autowired
    public void setSiteService(SiteService siteService) {
    	this.siteService = siteService;
    }

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Site> sites = siteService.getAllSiteInfos();
    	request.setAttribute("sites", sites);
    	try {
            this.getServletContext().getRequestDispatcher("/jsp/showSite.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
