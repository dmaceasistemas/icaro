package reportes.definicion.seguimiento;

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


public class Reportxparams extends Reporte{
	
	private HashMap<String, Object> parametros;
	
	public Reportxparams() {
		super();
		this.parametros = new HashMap<String, Object>();
	}
	
	public Reportxparams(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public void cargarParametros(HttpServletRequest request) {	

		String eje = request.getParameter("eje");
		String sede = request.getParameter("sede");
		String servicio = request.getParameter("servicio");
		String rubro = request.getParameter("rubro");
		String tipoproductor = request.getParameter("tipoproductor");
		String rangohas = request.getParameter("rangohas");
		String fecha_inicio = request.getParameter("fecha1");
		String fecha_fin = request.getParameter("fecha2");
		String sitio = request.getParameter("sitio");
		String enc1 = seguimiento.class.getResource("/").getPath()+"reportes/imagenes/seguimiento/encabezado_new2.png";
		String enc2 = seguimiento.class.getResource("/").getPath()+ "reportes/imagenes/seguimiento/imagenpedrocamejo.png";	
		String pie = seguimiento.class.getResource("/").getPath()+"reportes/imagenes/seguimiento/pie_new2.png";
		
		this.parametros.put("eje",eje);		
		if (this.parametros.get("eje")==null)
			this.parametros.put("eje","%");
		
		
		this.parametros.put("sede",sede);
		if (this.parametros.get("sede")==null)
			this.parametros.put("sede","%");
		
		this.parametros.put("servicio",servicio);
		if (this.parametros.get("servicio")==null)
			this.parametros.put("servicio","%");
		
		this.parametros.put("rubro",rubro);
		if (this.parametros.get("rubro")==null)
			this.parametros.put("rubro","%");
		
		this.parametros.put("tipoproductor",tipoproductor);
		if (this.parametros.get("tipoproductor")==null)
			this.parametros.put("tipoproductor","%");
		
		this.parametros.put("rangohas",rangohas);
		if (this.parametros.get("rangohas")==null)
			this.parametros.put("rangohas","%");
		
		this.parametros.put("sitio",sitio);		
		if (this.parametros.get("sitio")==null)
			this.parametros.put("sitio","%");
		
		this.parametros.put("fecha_inicio",fecha_inicio);
		this.parametros.put("fecha_fin",fecha_fin);		
		this.parametros.put("encabezado",enc1);
		this.parametros.put("encabezado2",enc2);
		this.parametros.put("pie",pie);	
		
		
	}

	

	@Override
	public Object clone() throws CloneNotSupportedException {
		Reportxparams reporte = new Reportxparams();
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
		//generador.mostrarPDF(generador.generarReportePDF(nombreReporte,"seguimiento",this.parametros, conn, response), nombreReporte, response);
		generador.generarReporteXLS(nombreReporte,"seguimiento",this.parametros, conn, response);		
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
