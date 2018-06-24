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



public class RepTraspasosExcel extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepTraspasosExcel() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepTraspasosExcel(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	
	public void cargarParametros(HttpServletRequest request) {
		
		
		String tipo= request.getParameter("tipo");
		this.parametros.put("tipo",tipo);
		
		String compdes= request.getParameter("compdes");
		this.parametros.put("compdes",compdes);
		
		String comphas= request.getParameter("comphas");
		this.parametros.put("comphas",comphas);
		
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepTraspasosExcel reporte = new RepTraspasosExcel();
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
		//generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"sigesp/spg",this.parametros, conn, response), nombreReporte, response);			
			
		
		generador.generarReporteXLS(nombreReporte, "sigesp/spg", this.parametros, conn, response);

		
		
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
