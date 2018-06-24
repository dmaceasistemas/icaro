package reportes.configuracion.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reportes.excepciones.ExcArgumentoInvalido;

import com.mchange.v2.c3p0.ComboPooledDataSource;





public class PoolDataSourceApolo {
	
	private static PoolDataSourceApolo poolDataSource ;
	private ComboPooledDataSource comboPooledDataSource;

	private PoolDataSourceApolo() {
		new ComboPooledDataSource();
	}

	public  static synchronized PoolDataSourceApolo getInstance() {
		if (poolDataSource == null)
			poolDataSource = new PoolDataSourceApolo();
		return poolDataSource;
	}

	public Connection getConection() throws SQLException, ExcArgumentoInvalido {
		
		if (comboPooledDataSource == null)
			comboPooledDataSource = obtenerConexion();
		if (comboPooledDataSource == null) 
			throw new ExcArgumentoInvalido(
					"El DataSource Apolo NO EXISTE");
		return comboPooledDataSource.getConnection();

	}
	
	private ComboPooledDataSource obtenerConexion(){
		ApplicationContext context =  new ClassPathXmlApplicationContext("reportes/configuracion/conexion/configapolo.xml");
		BeanFactory factory = (BeanFactory) context;
		return (ComboPooledDataSource) factory.getBean("configapolo");
	}
	
}