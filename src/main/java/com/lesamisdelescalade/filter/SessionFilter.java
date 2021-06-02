package com.lesamisdelescalade.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lesamisdelescalade.consts.UserInfoConsts;

@WebFilter(
	urlPatterns  = "/*", 
	dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class SessionFilter implements Filter {
	
	private static final String BASE_URI = "/lesamisdelescalade/";
	private List<String> excludedUri = new ArrayList<>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludedUri.add(BASE_URI);
		excludedUri.add(BASE_URI + "login");
		excludedUri.add(BASE_URI + "register");
		excludedUri.add(BASE_URI + "logout");
		excludedUri.add(BASE_URI + "img/lesamisdelescalade_crop.png");
		excludedUri.add(BASE_URI + "img/lesamisdelescalade_lg.png");
		excludedUri.add(BASE_URI + "jsp/login.jsp");
		excludedUri.add(BASE_URI + "jsp/register.jsp");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);
		String path = request.getRequestURI();
		if (path != null && !excludedUri.contains(path)
				&& (session == null || session.getAttribute(UserInfoConsts.UTILISATEUR) == null)) {
			req.setAttribute("loginError", "Votre session s'est terminé. Veuillez vous reconnecter.");
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		// Not used
	}
}
