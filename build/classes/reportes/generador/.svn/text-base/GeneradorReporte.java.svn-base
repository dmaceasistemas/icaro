package reportes.generador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Detail;

import antlr.collections.List;
import reportes.fuentes.Raiz;
import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JROrigin;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ExporterFilter;
import net.sf.jasperreports.engine.export.ExporterNature;
import net.sf.jasperreports.engine.export.FontKey;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporterTagHelper;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.PdfFont;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.oasis.JROpenDocumentExporter;
import net.sf.jasperreports.engine.export.oasis.JROpenDocumentExporterNature;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;


public class GeneradorReporte {
	public final static int TIPOPDF 	= 1;
	public final static int TIPOHTML 	= 2;
	public final static int TIPOXLS 	= 3;
	private static final Object Unicode = null;
	
	private String accion;
	private int id;
	
	public GeneradorReporte() {
			super();
			
	}
	
	
	public JRHtmlExporter parametrizarHtml(JasperPrint jasperPrint, ByteArrayOutputStream out){
		JRHtmlExporter exporter = new JRHtmlExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,	false);
		exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, 
				              JRHtmlExporterParameter.SIZE_UNIT_POINT);
		return exporter;
	}
	
		
	
	 public byte[] generarReportePDF (String reporte, String sistema, Map<String, Object> parameters, Connection conn,HttpServletResponse response) {
	        byte[] pdf = null;
	        JasperPrint jasperPrint = null;
	        String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String ruta = nombreReporte.split("Raiz.class")[0];
			String nombreCompleto = ruta+sistema+"/"+reporte+".jasper";
			String rutaSubreport = ruta+sistema+"/";
			System.out.println("Ruta "+ rutaSubreport);
			parameters.put("SUBREPORT_DIR",rutaSubreport);			

	        try {     	        	
	        	jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	        	
	        	
	        	pdf = JasperExportManager.exportReportToPdf(jasperPrint);
	        		            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return pdf;
	}
	
	 public void mostrarPDF (byte[] informePDF, String reporte,HttpServletResponse response) throws IOException {
	      
	        ByteArrayOutputStream bos    = new ByteArrayOutputStream();
	        ServletOutputStream out      = response.getOutputStream();
	        bos.write(informePDF);

	        response.setContentType("application/pdf");	        
	        response.setHeader("Cache-Control", "cache");	        
	        response.setHeader("Content-Disposition", "attachment; filename="+reporte+".pdf");
	        response.setHeader("Pragma", "cache");	       
	        response.setContentLength(bos.size());
	        out.write(bos.toByteArray());
	        out.flush();
	        bos.close();
	        out.close();
	        response.flushBuffer();           
	    }
	
 public void generarReporteXLS (String reporte, String nombreSistema, Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
	        byte[] xls = null;
	        JasperPrint jasperPrint = null;
	        String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String ruta = nombreReporte.split("Raiz.class")[0];
			//String nombreCompleto = ruta+reporte+".jasper";
			String nombreCompleto = ruta+nombreSistema+"/"+reporte+".jasper";	
			
    		 try {     	        	
	        	jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
	        	
	        	JExcelApiExporter exporterXLS = new JExcelApiExporter();
	    		response.setContentType("application/vnd.ms-excel");
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	    		exporterXLS.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS,Boolean.FALSE);
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BACKGROUND, Boolean.FALSE);
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
	    		exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
	    	exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_IGNORE_CELL_BORDER ,Boolean.FALSE);
	    	exporterXLS.setParameter(JRXlsAbstractExporterParameter.IS_COLLAPSE_ROW_SPAN  ,Boolean.TRUE);
	    	exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,nombreReporte);
	    		ServletOutputStream output = response.getOutputStream();
	    		exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, output);
	    		
	    		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
	    		exporterXLS.exportReport();
	    		output.close();
	       
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        
	}
	
 
 
public void generarReporteODT (String reporte, Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
     
     JasperPrint jasperPrint = null;
     String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String ruta = nombreReporte.split("Raiz.class")[0];
		String nombreCompleto = ruta+reporte+".jasper";	        
		
		 try {     	        	
     
			 jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
		
       
		response.setContentType("application/vnd.oasis.opendocument.text");
     //   response.setHeader("Content-Disposition", "inline; filename=\"prueba.odt\"");
        JROdtExporter  exporter = new JROdtExporter();
     	ServletOutputStream output = response.getOutputStream();
 		//exporter.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, output);
 		//exporter.setParameter(JRDocxExporterParameter.JASPER_PRINT,jasperPrint );
     	exporter.setParameter(	JRHtmlExporterParameter. OUTPUT_STREAM, output);
     
 		exporter.setParameter(	JRHtmlExporterParameter.JASPER_PRINT,jasperPrint );
 	
 		exporter.exportReport();

  
         output.close();
    
     } catch (Exception e) {
         e.printStackTrace();
     }

    
}			
public void generarReporteRTF (String reporte, Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
    
    JasperPrint jasperPrint = null;
    String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String ruta = nombreReporte.split("Raiz.class")[0];
		String nombreCompleto = ruta+reporte+".jasper";	        
	
		
		 try {     	        	
    
			 jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
             
      
     	JRRtfExporter rtfExporter = new JRRtfExporter();
      //  response.setContentType("application/msword");	        
     //	response.setContentType("text/html");
       	//	response.setContentType("application/msword");
     	//response.setContentType("application/vnd.oasis.opendocument.text");
     	// response.setContentType("application/rtf");
     	
     	response.setContentType("application/x-rtf"); 
     	// response.setContentType("text/richtext");
     	

     	
    
   	  response.setHeader("Content-Disposition", "inline; filename=\"prueba.rtf\"");
   
    	ServletOutputStream output = response.getOutputStream();
    	rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
    //	rtfExporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING,"ANSI");
       	rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint );     	                  
      
       	rtfExporter.exportReport();
    	
    	   	
   
   
   
   
         output.close();
   
    } catch (Exception e) {
        e.printStackTrace();
    }

   
}

public void generarReporteHTML (String reporte, String sistema,Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
    
    JasperPrint jasperPrint = null;
    String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String ruta = nombreReporte.split("Raiz.class")[0];
		String nombreCompleto = ruta+sistema+"/"+reporte+".jasper";	        
		ArrayList list = new ArrayList();	
		 try {    
			 jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
	    	  list.add( jasperPrint );		     	  
		 response.setContentType("application/vnd.oasis.opendocument.text");		     	  
    	JRHtmlExporter exporter = new JRHtmlExporter() ;
    	ServletOutputStream output = response.getOutputStream();
		exporter.setParameter(JRHtmlExporterParameter.OUTPUT_STREAM, output);		
		//exporter.setParameter(JRHtmlExporterParameter.ZOOM_RATIO,);
		exporter.setParameter(JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES ,Boolean.FALSE);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
		exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT,JRHtmlExporterParameter.SIZE_UNIT_POINT );
		//exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT,JRHtmlExporterParameter.SIZE_UNIT_PIXEL );
		exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE );
		exporter.setParameter(JRHtmlExporterParameter.IGNORE_PAGE_MARGINS,Boolean.TRUE );
		exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD,Boolean.TRUE );
		exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT_LIST,list );
		exporter.exportReport();

 
        output.close();
   
    } catch (Exception e) {
        e.printStackTrace();
    }

   
}

public void generarReporteHTML1 (String reporte, String sistema,Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
	
	JasperPrint jasperPrint = null;
    String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	String ruta = nombreReporte.split("Raiz.class")[0];
	String nombreCompleto = ruta+sistema+"/"+reporte+".jasper";
	try {    
		/*response.setContentType("text/html");
		jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
		JRHtmlExporter exporter = new JRHtmlExporter() ;
		ServletOutputStream output = response.getOutputStream();  
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);  
		exporter.setParameter(JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES ,Boolean.FALSE);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);		
		exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT,JRHtmlExporterParameter.SIZE_UNIT_POINT );
		exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE );
		exporter.setParameter(JRHtmlExporterParameter.IGNORE_PAGE_MARGINS,Boolean.TRUE );
		exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD,Boolean.TRUE );*/
		
		response.setContentType("text/html");
		jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
		JRHtmlExporter exporter = new JRHtmlExporter() ;
				
		PrintWriter output = response.getWriter();
		
		exporter.setParameter(JRHtmlExporterParameter.JASPER_PRINT,jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, output);
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.TRUE);		
		exporter.setParameter(JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES ,Boolean.TRUE);		
		exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,"UTF8");				
		exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT,JRHtmlExporterParameter.SIZE_UNIT_POINT );
		
		exporter.setParameter(JRHtmlExporterParameter.IGNORE_PAGE_MARGINS,Boolean.FALSE);
		exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD,Boolean.FALSE);
		
		
		exporter.exportReport();
		output.close();
		
		exporter.exportReport();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void generarReporteDOCX (String reporte, Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
    
    JasperPrint jasperPrint = null;
    String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String ruta = nombreReporte.split("Raiz.class")[0];
		String nombreCompleto = ruta+reporte+".jasper";	        
		
		 try {     	        	
    
			 jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);	
       
     	
    	JRDocxExporter exporterDOCX = new JRDocxExporter();
		response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		response.setHeader("Content-Disposition", "inline; filename=\"prueba.docx\"");					
	 	exporterDOCX.setParameter(JRDocxExporterParameter.IGNORE_PAGE_MARGINS,Boolean.TRUE);
		exporterDOCX.setParameter(JRDocxExporterParameter.FLEXIBLE_ROW_HEIGHT,Boolean.TRUE);
		exporterDOCX.setParameter(JRDocxExporterParameter.OUTPUT_FILE_NAME,nombreReporte);
		exporterDOCX.setParameter(JRDocxExporterParameter.CHARACTER_ENCODING,"UNICODE (UFT-8)");
		ServletOutputStream output = response.getOutputStream();
		exporterDOCX.setParameter(JRDocxExporterParameter.OUTPUT_STREAM, output);
		exporterDOCX.setParameter(JRDocxExporterParameter.JASPER_PRINT_LIST,  jasperPrint );
		
		exporterDOCX.exportReport();

         output.close();
   
    } catch (Exception e) {
        e.printStackTrace();
    }

   
}

public void generarReportePDFL (String reporte, Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
    
    JasperPrint jasperPrint = null;
  
    String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String ruta = nombreReporte.split("Raiz.class")[0];
		String nombreCompleto = ruta+reporte+".jasper";
		String rutaSubreport = ruta;
		parameters.put("SUBREPORT_DIR",rutaSubreport);
		System.out.println("Ruta "+ rutaSubreport);
		 try {    
			 jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);			  
			 response.setContentType("application/pdf");  
			 JRPdfExporter pdfExporter = new JRPdfExporter();
  	
         	
             
         ServletOutputStream output = response.getOutputStream();
  		pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
  		pdfExporter.setParameter(JRPdfExporterParameter.IS_TAGGED,Boolean.TRUE);
  		
  		pdfExporter.setParameter(JRPdfExporterParameter.TAG_LANGUAGE ,"HTML");
  		pdfExporter.setParameter(JRPdfExporterParameter.FORCE_SVG_SHAPES, Boolean.TRUE);
  		pdfExporter.setParameter(JRPdfExporterParameter. IS_TAGGED, Boolean.TRUE);
  		
  		pdfExporter.setParameter(JRPdfExporterParameter.PDF_VERSION,JRPdfExporterParameter.PDF_VERSION_1_7);
  		pdfExporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING,"UTF-8");
  		
     	 pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"ALGO"+".pdf");
     	 
     	 pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint );    
   
     	 pdfExporter.exportReport();
       	

    output.close();
   
    } catch (Exception e) {
        e.printStackTrace();
    }

   
}

public void generarReportePDFL (String sistema, String reporte, Map<String, Object> parameters, Connection conn,HttpServletResponse response) throws IOException {
    
    JasperPrint jasperPrint = null;
  
    String nombreReporte = Raiz.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String ruta = nombreReporte.split("Raiz.class")[0];
		String nombreCompleto = ruta+sistema+"/"+reporte+".jasper";
		String rutaSubreport = ruta+sistema+"/";
		parameters.put("SUBREPORT_DIR",rutaSubreport);
		
		 try {    
			 jasperPrint = JasperFillManager.fillReport(nombreCompleto,parameters,conn);			  
			 response.setContentType("application/pdf");  
			 JRPdfExporter pdfExporter = new JRPdfExporter();
  	
         	
             
         ServletOutputStream output = response.getOutputStream();
  		pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
  		pdfExporter.setParameter(JRPdfExporterParameter.IS_TAGGED,Boolean.TRUE);
  		
  		pdfExporter.setParameter(JRPdfExporterParameter.TAG_LANGUAGE ,"HTML");
  		pdfExporter.setParameter(JRPdfExporterParameter.FORCE_SVG_SHAPES, Boolean.TRUE);
  		pdfExporter.setParameter(JRPdfExporterParameter. IS_TAGGED, Boolean.TRUE);
  		
  		pdfExporter.setParameter(JRPdfExporterParameter.PDF_VERSION,JRPdfExporterParameter.PDF_VERSION_1_7);
  		pdfExporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING,"UTF-8");
  		
     	 pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"ALGO"+".pdf");
     	 
     	 pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint );    
   
     	 pdfExporter.exportReport();
       	

    output.close();
   
    } catch (Exception e) {
        e.printStackTrace();
    }

   
}

public String getAccion() {
			return accion;
		}

		public void setAccion(String accion) {
			this.accion = accion;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	
			
}
