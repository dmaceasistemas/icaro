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



public class RepGastoReembolsos extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepGastoReembolsos() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepGastoReembolsos(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	
	public void cargarParametros(HttpServletRequest request) {
		
		//Integer id_periodo= Integer.parseInt(request.getParameter("id_periodo"));
		String sede= request.getParameter("sede");
		String banco= request.getParameter("banco");
	

		//this.parametros.put("id_periodo",id_periodo);
		this.parametros.put("sede",sede);
		this.parametros.put("banco",banco);
	
		
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepGastoReembolsos reporte = new RepGastoReembolsos();
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
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"sigesp/cxp",this.parametros, conn, response), nombreReporte, response);			
			
		
		//generador.generarReporteXLS(nombreReporte, "sigesp/spg", this.parametros, conn, response);

		
		
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
