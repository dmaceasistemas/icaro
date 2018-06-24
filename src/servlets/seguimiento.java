package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import reportes.excepciones.ExcFiltroSinDatos;
import reportes.excepciones.ExcInvalidArgument;
import reportes.factorias.ReporteFactory;

public class seguimiento extends HttpServlet {
    
	private static final long serialVersionUID = 8617286791691823608L;

	public seguimiento() {
        super();
    }

	@Override
	public void init() throws ServletException {	
		super.init();
		ReporteFactory.getInstance().cargarReportes();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hola Mundo");
		String nombreReporte = request.getParameter("reporte");	
		
			try {				
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
}