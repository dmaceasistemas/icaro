package reportes.definicion.sigesp.imp;


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
import servlets.inicio;

public class RepTransitos extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public RepTransitos() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public RepTransitos(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	
	public void cargarParametros(HttpServletRequest request) {
		
		//String nroregistro = request.getParameter("nroregistro");
		//String estado      = request.getParameter("estado");
		String usuario     = request.getParameter("usuario");
		String logo        = inicio.class.getResource("/").getPath()+"reportes/imagenes/sigesp/imagenpedrocamejo.png";
		//String imganulado  = inicio.class.getResource("/").getPath()+"reportes/imagenes/docanulado.png";		
		
		/*if (estado.toUpperCase().trim()== "ANULADO" || estado.toUpperCase().trim().equals("ANULADO"))
			this.parametros.put("imganulado",imganulado);
		
		this.parametros.put("nroregistro",nroregistro);		*/
		this.parametros.put("usuario",usuario);
		this.parametros.put("logo",logo);
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		RepTransitos reporte = new RepTransitos();
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
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"sigesp/imp",this.parametros, conn, response), nombreReporte, response);			
		
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
	
		return parametros;
	}

	@Override
	public void setParametros(HashMap<String, Object> parametros) {
		this.parametros	= parametros;
		
	}


	
	
}
