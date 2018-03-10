package fr.uitt.biblio.balise.iterate;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import java.util.*;
import java.io.*;

public class IterationTag extends BodyTagSupport {
	private String var, type;
	private Iterator iterator = null;
	private StringBuffer sortie = null;
	private int nbElements;

	public void setVar(String var) {
		this.var = var;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setListe(Collection liste) {
		if (liste.size() > 0)
			iterator = liste.iterator();
	}

	public int doStartTag() {

		sortie = new StringBuffer();
		nbElements = 0;

		if (iterator == null)
			return SKIP_BODY;
		if (iterator.hasNext()) {
			pageContext.setAttribute(var, iterator.next());
			nbElements++;
			return EVAL_BODY_BUFFERED;
		} else {
			return SKIP_BODY;
		}
	}

	public int doAfterBody() throws JspException {
		BodyContent body = getBodyContent();
		if (body != null) {
			sortie.append(body.getString());
			body.clearBody();
		}

		if (iterator.hasNext()) {
			pageContext.setAttribute(var, iterator.next());
			nbElements++;
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	public int doEndTag() throws JspException {
		BodyContent body = getBodyContent();
		if (body != null) {
			try {
				body.getEnclosingWriter().write(sortie.toString());
			} catch (IOException e) {
				throw new JspException("IterationTag: " + e.getMessage());
			}
		}
		pageContext.setAttribute("nbElements", new Integer (nbElements));
		return EVAL_PAGE;
	}

}
