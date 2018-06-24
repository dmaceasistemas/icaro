package reportes.configuracion.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reportes.excepciones.ExcArgumentoInvalido;

import com.mchange.v2.c3p0.ComboPooledDataSource;





public class PoolDataSourceSEGUIMIENTO {
	
	private static PoolDataSourceSEGUIMIENTO poolDataSource ;
	private ComboPooledDataSource comboPooledDataSource;

	private PoolDataSourceSEGUIMIENTO() {
		new ComboPooledDataSource();
	}

	public  static synchronized PoolDataSourceSEGUIMIENTO getInstance() {
		if (poolDataSource == null)
			poolDataSource = new PoolDataSourceSEGUIMIENTO();
		return poolDataSource;
	}

	public Connection getConection() throws SQLException, ExcArgumentoInvalido {
		
		if (comboPooledDataSource == null)
			comboPooledDataSource = obtenerConexion();
		if (comboPooledDataSource == null) 
			throw new ExcArgumentoInvalido(
					"El DataSource Seguimiento NO EXISTE");
		return comboPooledDataSource.getConnection();

	}
	
	private ComboPooledDataSource obtenerConexion(){
		ApplicationContext context =  new ClassPathXmlApplicationContext("reportes/configuracion/conexion/configseguimiento.xml");
		BeanFactory factory = (BeanFactory) context;
		return (ComboPooledDataSource) factory.getBean("configseguimiento");
	}
	
}