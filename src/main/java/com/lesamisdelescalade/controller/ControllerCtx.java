package com.lesamisdelescalade.controller;

import com.lesamisdelescalade.dao.UtilisateurDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerCtx {
    private UtilisateurDao utilisateurDao;
    private final ClassPathXmlApplicationContext context;

    public ControllerCtx() {
        context = new ClassPathXmlApplicationContext("classpath:/META-INF/applicationContext.xml");
        initDao();
    }


    public void initDao(){ 	
        //utilisateurDao = (UtilisateurDao) context.getBean("utilisateurDao");
        utilisateurDao = context.getBean("utilisateurDao", UtilisateurDao.class);
    }

    public UtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }
}
