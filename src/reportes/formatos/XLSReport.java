package reportes.formatos;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class XLSReport implements Formato {


	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response) throws JRException, IOException {
		JRXlsExporter exporterXLS = new JRXlsExporter();
		response.setContentType("application/vnd.ms-excel");
		exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
		exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
		ServletOutputStream output = response.getOutputStream();
		exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporterXLS.exportReport();
		output.close();
	}

	public Object clone() throws CloneNotSupportedException {
		return new XLSReport();
	}
}
