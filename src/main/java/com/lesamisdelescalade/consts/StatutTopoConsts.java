package com.lesamisdelescalade.consts;

public class StatutTopoConsts {
	private StatutTopoConsts() {
		throw new IllegalStateException("Utility class");
	}

	public static final Integer DISPONIBLE = 1;
	public static final Integer INDISPONIBLE = 2;
	public static final Integer EN_ATTENTE = 3;
	public static final String STATUT = "statut";
}
