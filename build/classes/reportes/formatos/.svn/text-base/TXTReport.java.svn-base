package reportes.formatos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;

public class TXTReport implements Formato {

	public void escribirReporte(JasperPrint jasperPrint, HttpServletResponse response) throws JRException, IOException {
		
		response.setContentType("text/plain");
		JRTextExporter exporter = new JRTextExporter();
		exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, Integer.valueOf("15"));
		//exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, Integer.valueOf("1"));
        exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, Integer.valueOf("80"));
        exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT,Integer.valueOf("150"));
        //exporter.setParameter(JRTextExporterParameter.LINE_SEPARATOR," ");
        exporter.setParameter(JRTextExporterParameter.JASPER_PRINT, jasperPrint);
        PrintWriter out = response.getWriter();
        exporter.setParameter(JRTextExporterParameter.OUTPUT_WRITER, out);
        exporter.exportReport();
        out.close();
	}
	
	public Object clone() throws CloneNotSupportedException {
		return new TXTReport();
	}
}
