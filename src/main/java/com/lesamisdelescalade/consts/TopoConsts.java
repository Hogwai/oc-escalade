package com.lesamisdelescalade.consts;

/**
 * Topo constants
 * @author Lilian
 *
 */
public class TopoConsts {
	private TopoConsts() {
		throw new IllegalStateException("Utility class");
	}

	public static final String PROPRIETAIRE = "proprietaire";
	public static final String EMPRUNTEUR = "emprunteur";
	public static final String TOPOS = "topos";
	public static final String NOM = "nom";
	public static final String DESCRIPTION = "description";
	public static final String SITE = "site";
	public static final String TOPO_TAG = "topoTag";
	public static final String TOPO_ID = "topoId";
	
	public static final String MODIFY = "modify";
	public static final String CANCEL = "cancel";
	public static final String ACCEPT = "accept";
	public static final String REFUSE = "refuse";
	
	public static final String TOPOS_EN_ATTENTE = "toposEnAttente";
	public static final String TOPOS_DISPONIBLES= "toposDisponibles";
	public static final String TOPOS_INDISPONIBLES= "toposIndisponibles";
	public static final String TOPOS_RESERVES= "toposReserves";
	public static final String TOPOS_ACCEPT= "toposAccept";
}
