
package reportes.factorias;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import reportes.definicion.Reporte;
import servlets.demeter;


public class ReporteFactory {

	static private ReporteFactory reportManager = new ReporteFactory();

	//private Map<Integer, Reporte> reportes = new HashMap<Integer, Reporte>();
	private BeanFactory reportes;

	private ReporteFactory() {
	}

	static public ReporteFactory getInstance() {
		return reportManager;
	}

	public void cargarReportes(){
		reportes = new XmlBeanFactory(new FileSystemResource(demeter.class.getResource("/").getPath()+"/beans/reportes.xml"));		
	}
	public Reporte getReporte(String idReporte) throws CloneNotSupportedException{
		Reporte reporte = (Reporte) reportes.getBean(idReporte);
		return (Reporte) reporte.clone();
	}

	

}
