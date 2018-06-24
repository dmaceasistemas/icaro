package reportes.definicion.apolo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import reportes.configuracion.conexion.PoolDataSourceApolo;
import reportes.configuracion.conexion.PoolDataSourceDemeter;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;
import servlets.apolo;


public class RepTratamientoPermanente extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepTratamientoPermanente() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepTratamientoPermanente(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {	
		//String encabezado = request.getParameter("encabezado");
		//String encabezado = "/reportes/imagenes/encabezado_new2.png";		
		String encabezado = apolo.class.getResource("/").getPath()+"reportes/imagenes/encabezado_new2.png";
		String logoCPC = apolo.class.getResource("/").getPath()+"reportes/imagenes/logo.jpg";
		String logoCVA = apolo.class.getResource("/").getPath()+ "reportes/imagenes/logo_cva.gif";	
		String pie = apolo.class.getResource("/").getPath()+"reportes/imagenes/pie_new.png";
		
		
		this.parametros.put("encabezado",encabezado);
		this.parametros.put("logoCPC",logoCPC);
		this.parametros.put("logoCVA",logoCVA);
		this.parametros.put("pie",pie);
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepTratamientoPermanente reporte = new RepTratamientoPermanente();
		copyAttributesTo(reporte);		
		return reporte;
		
	}
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		conn = PoolDataSourceApolo.getInstance().getConection();		
		GeneradorReporte generador = new GeneradorReporte();		
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"apolo",this.parametros, conn, response), nombreReporte, response);			
		
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
