package com.lesamisdelescalade.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Component
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    protected static final Logger LOGGER = LogManager.getLogger(LogoutController.class);
    private static final long serialVersionUID = 1L;
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	req.getSession().invalidate();
    	try {
			resp.sendRedirect(req.getContextPath() + "/login");
		} catch (IOException e) {
			 LOGGER.error(String.format("Error occurred during logout: %s", e.toString()));
		}
    }
}
