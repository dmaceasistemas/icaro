package reportes.formatos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

public class CSVReport implements Formato {

	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response)
			throws JRException, IOException {
		response.setContentType("text/plain");
		JRCsvExporter cSVReport = new JRCsvExporter();
		cSVReport.setParameter(JRHtmlExporterParameter.JASPER_PRINT,jasperPrint);
		cSVReport.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
		PrintWriter out = response.getWriter();
		cSVReport.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
		cSVReport.exportReport();
		out.close();
	}

	public Object clone() throws CloneNotSupportedException {
		return new CSVReport();
	}

}
