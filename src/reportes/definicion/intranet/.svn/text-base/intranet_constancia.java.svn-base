package reportes.definicion.intranet;

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


public class intranet_constancia extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public intranet_constancia() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public intranet_constancia(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {	

		String cedula	= request.getParameter("cedula");
		String codigo = request.getParameter("codigo");
		String enc1 = seguimiento.class.getResource("/").getPath()+"reportes/imagenes/seguimiento/encabezado_new.png";
		String pie = seguimiento.class.getResource("/").getPath()+"reportes/imagenes/seguimiento/pie_new2.png";
		
		this.parametros.put("cedula",cedula);		
		/*if (this.parametros.get("cedula")==null)
			this.parametros.put("cedula","%");*/
		
		System.out.println(request.getParameter("cedula")+"---"+request.getParameter("codigo"));
		this.parametros.put("codigo",codigo);
		/*if (this.parametros.get("codigo")==null)
			this.parametros.put("codigo","%");*/
		
		this.parametros.put("encabezado",enc1);
		this.parametros.put("pie",pie);	
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		intranet_constancia reporte = new intranet_constancia();
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
		generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"intranet",this.parametros, conn, response), nombreReporte, response);			
		
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