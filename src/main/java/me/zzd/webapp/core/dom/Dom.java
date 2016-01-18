package me.zzd.webapp.core.dom;

import java.io.Serializable;

public abstract class Dom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract XmlDocument toDocument();
}
