package servlets;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;

import reportes.excepciones.ExcFiltroSinDatos;
import reportes.excepciones.ExcInvalidArgument;
import reportes.factorias.ReporteFactory;

public class demeter extends HttpServlet {
    
	private static final long serialVersionUID = 8617286791691823608L;

	public demeter() {
        super();
        
    }

	@Override
	public void init() throws ServletException {	
		super.init();
		ReporteFactory.getInstance().cargarReportes();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreReporte = request.getParameter("reporte");	
		
			try {
				//ReporteFactory.getInstance().getReporte(nombreReporte).cargarParametros(request);
				ReporteFactory.getInstance().getReporte(nombreReporte).generarReporte(nombreReporte,request,response);
			} catch (JRException e) {				
				e.printStackTrace();
			} catch (SQLException e) {				
				e.printStackTrace();
			} catch (ExcInvalidArgument e) {			
				e.printStackTrace();
			} catch (ExcFiltroSinDatos e) {			
				e.printStackTrace();
			} catch (CloneNotSupportedException e) {		
			e.printStackTrace();
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");       
		 
	
	}
	
	
	 
	
	
	@SuppressWarnings("unused")
	private void dibujarHtml(ServletOutputStream out, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");       
		 out.println("<html>");
	        out.println("<head>");	        
	        out.println("<title>Icaro Web Reporter - Version Java</title>");
	        out.println("<link href='css/cssicaro.css' rel='stylesheet' type='text/css' media='all'>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div id='encabezado'>");
	        out.println("<div id='nombre-aplicacion'><img src='imagenes/icaro_reporter.png' alt=''></div>");
	        out.println("</div>");
	        out.println("<div id='content'>");
	        out.println("</div>");    
	        out.println("</body>");
	        out.println("</html>");
	}

}
