package reportes.definicion.demeter;

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
import reportes.configuracion.conexion.PoolDataSourceDemeter;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;


public class RepCierreCaja extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepCierreCaja() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepCierreCaja(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {	
		
		
		
		
			
		
		Date fechacierre=new Date();
	  	DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date parsedUtilDate =null;
		try {
			parsedUtilDate = formater.parse(request.getParameter("fechacierre"));
		} catch (ParseException e) {
			
		}  
		java.sql.Date sqltDate= new java.sql.Date(parsedUtilDate.getTime());
		fechacierre=sqltDate;
		System.out.print(fechacierre);
		this.parametros.put("FechaCierre",fechacierre);
	  	
		

	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepCierreCaja reporte = new RepCierreCaja();
		copyAttributesTo(reporte);		
		return reporte;
		
	}
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		if (request.getParameter("jdbcUrl") != null)
			conn = PoolDataSourceDemeter.getInstance().cambiarConexion(request.getParameter("jdbcUrl")).getConnection();
		else
			conn = PoolDataSourceDemeter.getInstance().getConection();
		GeneradorReporte generador = new GeneradorReporte();		
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"demeter", this.parametros, conn, response), nombreReporte, response);			
		
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
