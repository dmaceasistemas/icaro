package reportes.definicion.seguimiento;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import reportes.configuracion.conexion.PoolDataSourceSEGUIMIENTO;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;
import servlets.seguimiento;


public class graphicReportx7 extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public graphicReportx7() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public graphicReportx7(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {	

		String enc1 = seguimiento.class.getResource("/").getPath()+"reportes/imagenes/seguimiento/encabezado_new2.png";
		String enc2 = seguimiento.class.getResource("/").getPath()+ "reportes/imagenes/seguimiento/imagenpedrocamejo.png";	
		String pie = seguimiento.class.getResource("/").getPath()+"reportes/imagenes/seguimiento/pie_new2.png";
		
		this.parametros.put("encabezado",enc1);
		this.parametros.put("encabezado2",enc2);
		this.parametros.put("pie",pie);	
		
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		graphicReportx7 reporte = new graphicReportx7();
		copyAttributesTo(reporte);		
		return reporte;		
	}
	
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		conn = PoolDataSourceSEGUIMIENTO.getInstance().getConection();		
		GeneradorReporte generador = new GeneradorReporte();		
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"seguimiento",this.parametros, conn, response), nombreReporte, response);			
		
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
