package reportes.formatos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;

public class XMLReport implements Formato{

	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response) throws JRException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		JRXmlExporter jRXmlExporter = new JRXmlExporter();
		jRXmlExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		jRXmlExporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
		jRXmlExporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
		jRXmlExporter.exportReport();
		out.close();
	}
	
	public Object clone() throws CloneNotSupportedException {
		return new XMLReport();
	}

}
