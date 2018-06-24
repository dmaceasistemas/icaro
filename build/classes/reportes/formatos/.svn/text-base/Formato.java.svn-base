package reportes.formatos;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface Formato extends Cloneable{
	
	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response) throws JRException, IOException;
	
	public Object clone() throws CloneNotSupportedException;
	
	

}
