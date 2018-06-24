package reportes.definicion.demeter;
import java.lang.Integer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import reportes.configuracion.conexion.PoolDataSourceDemeter;
import reportes.definicion.Reporte;
import reportes.excepciones.ExcArgumentoInvalido;
import reportes.generador.GeneradorReporte;


public class RepContrato2 extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepContrato2() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepContrato2(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {		
    	int numerocontrato = Integer.parseInt( request.getParameter("numerocontrato"));		
		this.parametros.put("NumeroContrato",numerocontrato);		
	    String sede=request.getParameter("Sede");		
		this.parametros.put("Sede",sede);
		
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepContrato2 reporte = new RepContrato2();
		copyAttributesTo(reporte);		
		return reporte;
		
	}
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		
		if (request.getParameter("jdbcUrl") != null)
			conn = PoolDataSourceDemeter.getInstance().cambiarConexion(request.getParameter("jdbcUrl")).getConnection();
		else
			conn = PoolDataSourceDemeter.getInstance().getConection();	
		GeneradorReporte generador = new GeneradorReporte();		
		generador.generarReportePDFL("demeter/contratos",nombreReporte, this.parametros, conn, response);					
		
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
