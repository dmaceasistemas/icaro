package reportes.definicion.demeter;
import java.lang.Integer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import reportes.configuracion.conexion.PoolDataSourceDemeter;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;


public class RepFactura extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepFactura() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepFactura(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {		
		 int numerofactura = Integer.parseInt( request.getParameter("numerofactura"));		
		this.parametros.put("NumeroFactura",numerofactura);	
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepFactura reporte = new RepFactura();
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
		System.out.println(" >>>>>  Nombre de Reporte "+nombreReporte);
		System.out.println(" >>>>>  parametros "+this.parametros);
		System.out.println(" >>>>>  conect "+conn);
		System.out.println(" >>>>>  response "+response);
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
