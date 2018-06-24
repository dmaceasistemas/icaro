package reportes.definicion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

import reportes.excepciones.ExcFiltroSinDatos;
import reportes.excepciones.ExcInvalidArgument;
import reportes.formatos.Formato;


public abstract class Reporte implements Cloneable {

	private String rutaReporte = null;	
	private HttpServletRequest request;
	private String nombreReporte;
	private Formato formatoReporte;
	
	public abstract void cargarParametros(HttpServletRequest request);

	protected abstract JRDataSource executeQuery(Connection connection) throws SQLException;
	
	public abstract Object clone() throws CloneNotSupportedException;
	
	public abstract void generarReporte(String nombreReporte,HttpServletRequest request, HttpServletResponse response) throws JRException, IOException, SQLException, ExcInvalidArgument, ExcFiltroSinDatos;
	
	public abstract HashMap<String, Object> getParametros();
	
	public abstract void setParametros(HashMap<String, Object> parametros);
	
	
	
	public Reporte() {
	
	}
	
	public Reporte(HttpServletRequest request) {		
		cargarParametros(request);		
	}
	
	public void setRutaReporte(String rutaReporte) {
		this.rutaReporte = Reporte.class.getResource("/").getPath() + rutaReporte;
	}

	
	protected void copyAttributesTo(Reporte reporte) throws CloneNotSupportedException {
		reporte.rutaReporte = rutaReporte;		
	}

	

	
	

	public void setFormato(String idFormato) throws CloneNotSupportedException, ExcInvalidArgument {
		//formatoReporte = FormatoFactory.getInstance().getFormato(idFormato);
		// Todo: Activar factoria de Formatos; 
		
	}

	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	

	public String getNombreReporte() {
		return nombreReporte;
	}

	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	public Formato getFormatoReporte() {
		return formatoReporte;
	}

	public void setFormatoReporte(Formato formatoReporte) {
		this.formatoReporte = formatoReporte;
	}

	public String getRutaReporte() {
		return rutaReporte;
	}
	
	
}