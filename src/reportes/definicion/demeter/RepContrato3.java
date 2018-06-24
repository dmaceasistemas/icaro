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


public class RepContrato3 extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepContrato3() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepContrato3(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {		
/*		 int fechames = Integer.parseInt( request.getParameter("fechames"));		
		this.parametros.put("FechaMes",fechames);	
		
		 int fechaano	 = Integer.parseInt( request.getParameter("fechaano"));		
			this.parametros.put("FechaAño",fechaano);	*/
	 /*int fechames = 3;		
		this.parametros.put("FechaMes",fechames);	*/
		
	/*int fechaaño	 = 2010;		
			this.parametros.put("FechaAño",fechaaño);	*/
		
		
		
		
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepContrato3 reporte = new RepContrato3();
		copyAttributesTo(reporte);		
		return reporte;
		
	}
	@Override
	public void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws IOException, JRException{
	Connection conn = null;
	cargarParametros(request); 
	try {
		System.out.println(this.parametros);
		if (request.getParameter("jdbcUrl") != null)
			conn = PoolDataSourceDemeter.getInstance().cambiarConexion(request.getParameter("jdbcUrl")).getConnection();
		else
			conn = PoolDataSourceDemeter.getInstance().getConection();	
		GeneradorReporte generador = new GeneradorReporte();
		
		generador.generarReporteODT(nombreReporte, this.parametros, conn, response);
		/*
		generador.mostrarXLS(generador.generarReporteXLS(nombreReporte, this.parametros, conn, response), nombreReporte,response);*/			
		
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
