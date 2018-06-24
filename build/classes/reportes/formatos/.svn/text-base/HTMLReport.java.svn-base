package reportes.formatos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

public class HTMLReport implements Formato {

	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response)
			throws JRException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		JRHtmlExporter jRHtmlExporter = new JRHtmlExporter();
		jRHtmlExporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT,jasperPrint);
		jRHtmlExporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
		jRHtmlExporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
		jRHtmlExporter.exportReport();
		out.close();
	}

	public Object clone() throws CloneNotSupportedException {
		return new HTMLReport();
	}

}
