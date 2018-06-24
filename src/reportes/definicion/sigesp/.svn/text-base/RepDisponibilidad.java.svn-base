package reportes.definicion.sigesp;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import reportes.configuracion.conexion.PoolDataSourceSIGESP;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;




public class RepDisponibilidad extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepDisponibilidad() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepDisponibilidad(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	
	public void cargarParametros(HttpServletRequest request) {
		
		String cod1= request.getParameter("cod1");
		String cod2= request.getParameter("cod2");
		String cod3= request.getParameter("cod3");
		String codff= request.getParameter("codff");
		String fecha1 = request.getParameter("fecha");
		/*Date fecha=new Date();
	  	DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date parsedUtilDate =null;
		try {
			parsedUtilDate = formater.parse(request.getParameter("fecha"));
			java.sql.Date sqltDate= new java.sql.Date(parsedUtilDate.getTime());
			fecha=sqltDate;
		} catch (ParseException e) {
			
		}  
		*/
		System.out.print(fecha1);
		
		this.parametros.put("cod1",cod1);
		this.parametros.put("cod2",cod2);
		this.parametros.put("cod3",cod3);
		this.parametros.put("codff",codff);
		this.parametros.put("fecha",fecha1);		
		
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepDisponibilidad reporte = new RepDisponibilidad();
		copyAttributesTo(reporte);		
		return reporte;		
	}
	
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		conn = PoolDataSourceSIGESP.getInstance().getConection();		
		GeneradorReporte generador = new GeneradorReporte();		
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"sigesp/spg",this.parametros, conn, response), nombreReporte, response);			
		
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
