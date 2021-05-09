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

import com.lesamisdelescalade.consts.StatutTopoConsts;
import com.lesamisdelescalade.consts.TopoConsts;
import com.lesamisdelescalade.consts.UserInfoConsts;
import com.lesamisdelescalade.model.Topo;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.TopoService;

/**
 * Servlet implementation class ListeToposController
 */
@WebServlet("/reservations")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final Logger LOGGER = LogManager.getLogger(ReservationController.class);
	
	private static final String PARSE_ERROR = "Error occurred during string parsing: %s";
	
	@Autowired
	private TopoService topoService;

	
	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur currentUser = (Utilisateur) request.getSession().getAttribute(UserInfoConsts.UTILISATEUR);
		if (request.getParameter(TopoConsts.ACCEPT) != null) {
			this.acceptTopoBooking(request);
			this.setListeToposRequest(request, currentUser);
			this.redirectReservationPage(request, response);
		} else if (request.getParameter(TopoConsts.REFUSE) != null) {
			this.refuseTopoBooking(request);
			this.setListeToposRequest(request, currentUser);
			this.redirectReservationPage(request, response);
		} else {
			this.setListeToposRequest(request, currentUser);
			this.dispatchReservationPage(request, response);
		}
	}
    
    /**
     * 
     * @param request
     * @param currentUser
     */
    private void setListeToposRequest(HttpServletRequest request, Utilisateur currentUser) {	
		List<Topo> toposAccept = topoService.getToposByProprietaireStatut(currentUser,
				StatutTopoConsts.EN_ATTENTE);
		List<Topo> toposReserves = topoService.getBookedToposByProprietaire(currentUser);
		
		request.setAttribute(TopoConsts.TOPOS_ACCEPT, toposAccept);
		request.setAttribute(TopoConsts.TOPOS_RESERVES, toposReserves);
    }
    
    
    /**
     * 
     * @param request
     * @param currentUser
     */
    public void acceptTopoBooking(HttpServletRequest request) {
    	Integer topoId = getTopoFromReq(request, TopoConsts.ACCEPT);
    	topoService.updateTopo(topoId, StatutTopoConsts.INDISPONIBLE);
    }
    
    /**
     * 
     * @param request
     * @param currentUser
     */
	public void refuseTopoBooking(HttpServletRequest request) {
    	Integer topoId = getTopoFromReq(request, TopoConsts.REFUSE);
		topoService.updateTopoEmprunteurStatut(null, topoId, StatutTopoConsts.DISPONIBLE);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 */
	private void dispatchReservationPage(HttpServletRequest request, HttpServletResponse response) {
		try {
            this.getServletContext().getRequestDispatcher("/jsp/reservations.jsp")
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
	private void redirectReservationPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(request.getContextPath() + "/reservations");
		} catch (IOException e){
            LOGGER.error(String.format("Error occurred: %s", e.toString()));
        }
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private Integer getTopoFromReq(HttpServletRequest request, String parameter) {
		Integer topoId = null;
    	try {
    		topoId = Integer.valueOf(request.getParameter(parameter));
		} catch (NumberFormatException e) {
			 LOGGER.error(String.format(PARSE_ERROR, e.toString()));
		}
    	return topoId;
	}
}
