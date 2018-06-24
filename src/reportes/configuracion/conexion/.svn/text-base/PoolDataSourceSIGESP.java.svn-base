package reportes.configuracion.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import reportes.excepciones.ExcArgumentoInvalido;

import com.mchange.v2.c3p0.ComboPooledDataSource;





public class PoolDataSourceSIGESP {
	
	private static PoolDataSourceSIGESP poolDataSource ;
	private ComboPooledDataSource comboPooledDataSource;

	private PoolDataSourceSIGESP() {
		new ComboPooledDataSource();
	}

	public  static synchronized PoolDataSourceSIGESP getInstance() {
		if (poolDataSource == null)
			poolDataSource = new PoolDataSourceSIGESP();
		return poolDataSource;
	}

	public Connection getConection() throws SQLException, ExcArgumentoInvalido {
		
		if (comboPooledDataSource == null)
			comboPooledDataSource = obtenerConexion();
		if (comboPooledDataSource == null) 
			throw new ExcArgumentoInvalido(
					"El DataSource Sigesp NO EXISTE");
		return comboPooledDataSource.getConnection();

	}
	
	private ComboPooledDataSource obtenerConexion(){
		ApplicationContext context =  new ClassPathXmlApplicationContext("reportes/configuracion/conexion/configsigesp.xml");
		BeanFactory factory = (BeanFactory) context;
		return (ComboPooledDataSource) factory.getBean("configsigesp-prueba");
	}
	
}