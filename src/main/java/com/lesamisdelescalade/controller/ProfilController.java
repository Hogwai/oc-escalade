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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.lesamisdelescalade.consts.SiteConsts;
import com.lesamisdelescalade.consts.StatutTopoConsts;
import com.lesamisdelescalade.consts.TopoConsts;
import com.lesamisdelescalade.consts.UserInfoConsts;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Topo;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.SiteService;
import com.lesamisdelescalade.service.TopoService;

/**
 * Servlet implementation class ProfilController
 */
@WebServlet("/profil")
public class ProfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(ProfilController.class);
	
	private static final String PARSE_ERROR = "Error occurred during string parsing: %s";
       
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private TopoService topoService;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getQueryString() == null) {
    		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute(UserInfoConsts.UTILISATEUR);
        	List<Topo> topos = topoService.getToposByProprietaire(currentUser);
        	List<Site> sites = siteService.getAllSiteInfos();
        	
        	request.setAttribute(SiteConsts.SITES, sites);
        	request.setAttribute(TopoConsts.TOPOS, topos);
        	this.dispatchProfilPage(request, response);
    	} else  {
    		this.modifyTopo(request);
    		this.redirectProfilPage(request, response);
    	}
	}
    
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.addTopo(request);
    	this.redirectProfilPage(request, response);
	}
	
	/**
	 * Modify a topo
	 * @param request
	 */
	public void modifyTopo(HttpServletRequest request) {
    	Integer topoId = getTopoFromReq(request);
		Integer statutTopoTag = Integer.valueOf(request.getParameter(StatutTopoConsts.STATUT))
				.equals(StatutTopoConsts.DISPONIBLE) ? StatutTopoConsts.INDISPONIBLE : StatutTopoConsts.DISPONIBLE;
		topoService.updateTopo(topoId, statutTopoTag);
	}
	
	/**
	 * Add a new topo
	 * @param request
	 */
	public void addTopo(HttpServletRequest request) {
		String nom = request.getParameter(TopoConsts.NOM);
		String description = request.getParameter(TopoConsts.DESCRIPTION);
    	Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute(UserInfoConsts.UTILISATEUR);
    	Integer siteId = getSiteFromReq(request);
    	Integer statutTopo = StatutTopoConsts.DISPONIBLE;
    	topoService.addTopo(nom, description, statutTopo, currentUser, siteId);
	}

	/**
	 * Dispatch profil page
	 * @param request
	 * @param response
	 */
	private void dispatchProfilPage(HttpServletRequest request, HttpServletResponse response) {
		try {
            this.getServletContext().getRequestDispatcher("/jsp/profil.jsp")
                    .forward(request, response);
        } catch (ServletException | IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}
	
	/**
	 * Redirect to profil page
	 * @param request
	 * @param response
	 */
	private void redirectProfilPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath() + "/profil");
		} catch (IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}
	
	/**
	 * Get topo id from request
	 * @param request
	 * @return
	 */
	private Integer getTopoFromReq(HttpServletRequest request) {
		Integer topoId = null;
    	try {
    		topoId = Integer.valueOf(request.getParameter(TopoConsts.MODIFY));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return topoId;
	}
	
	/**
	 * Get site id from request
	 * @param request
	 * @return
	 */
	private Integer getSiteFromReq(HttpServletRequest request) {
		Integer siteId = null;
    	try {
    		siteId = Integer.valueOf(request.getParameter(SiteConsts.SITE_ID));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return siteId;
	}

}
