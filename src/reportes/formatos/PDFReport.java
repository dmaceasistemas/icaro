package reportes.formatos;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

public class PDFReport implements Formato {

	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response)
			throws JRException, IOException {
		response.setContentType("application/pdf");
		byte[] output = JasperExportManager.exportReportToPdf(jasperPrint);
		response.setContentLength(output.length);
		ServletOutputStream ouputStream = response.getOutputStream();
		ouputStream.write(output);
		ouputStream.flush();
		ouputStream.close();
	}

	public Object clone() throws CloneNotSupportedException {
		return new PDFReport();
	}
}
