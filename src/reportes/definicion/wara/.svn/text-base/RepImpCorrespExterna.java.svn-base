package reportes.definicion.wara;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import reportes.configuracion.conexion.PoolDataSourceWara;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;
import servlets.apolo;
import servlets.wara;


public class RepImpCorrespExterna extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepImpCorrespExterna() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepImpCorrespExterna(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {		
		Integer nroCorresp = Integer.parseInt(request.getParameter("nrocorresp"));
		String encabezado = wara.class.getResource("/").getPath()+"reportes/imagenes/wara/cintillo.png";
		String pie = apolo.class.getResource("/").getPath()+"reportes/imagenes/wara/pie.png";
		this.parametros.put("nrocorresp",nroCorresp);
		this.parametros.put("encabezado",encabezado);
		this.parametros.put("pie",pie);
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepImpCorrespExterna reporte = new RepImpCorrespExterna();
		copyAttributesTo(reporte);		
		return reporte;
		
	}
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		conn = PoolDataSourceWara.getInstance().getConection();		
		GeneradorReporte generador = new GeneradorReporte();
		//generador.generarReporteHTML(nombreReporte,"wara", this.parametros, conn, response);
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"wara", this.parametros, conn, response), nombreReporte, response);			
		
	} catch (SQLException e) {		
		e.printStackTrace();
	} catch (ExcArgumentoInvalido e) {		
		e.printStackTrace();
	} 
	finally {		     
	      try {
	        if (conn != null) {	         		         
	          conn.close();
	        }
	      }
	      catch (Exception e) {
	        e.printStackTrace();
	      }
	    }		
	}
	@Override
	protected JRDataSource executeQuery(Connection connection)	throws SQLException {
		
		return null;
	}

	@Override
	public HashMap<String, Object> getParametros() {
		// TODO Auto-generated method stub
		return parametros;
	}

	@Override
	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros	= parametros;
		
	}


	
	
}
