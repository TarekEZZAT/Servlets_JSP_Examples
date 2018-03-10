package fr.uitt.biblio.balise.iterate;


import javax.servlet.jsp.tagext.*;
public class IterationTEI extends TagExtraInfo {
  
   public IterationTEI() {
	  super();
   }
   

   public VariableInfo[] getVariableInfo(TagData data) {
	  VariableInfo var
		 = new VariableInfo(
			data.getAttributeString("var"),
			data.getAttributeString("type"),	
			true,
			VariableInfo.NESTED);
	VariableInfo nbElements =
		new VariableInfo(
			"nbElements",
			"java.lang.Integer",
			true,
			VariableInfo.AT_BEGIN);
	  VariableInfo [] info = { var, nbElements };
	  return info;
   }
}