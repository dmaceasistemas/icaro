package reportes.factorias;

import java.sql.Connection;
import java.sql.SQLException;
import reportes.excepciones.ExcInvalidArgument;
import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class PoolDataSource {
	private static PoolDataSource poolDataSource = new PoolDataSource();

	public static final String POSTGRES = "POSTGRES";

	public static final String MYSQL = "MYSQL";

	private PoolDataSource() {
		new ComboPooledDataSource(MYSQL);
		new ComboPooledDataSource(POSTGRES);
	}

	public static PoolDataSource getInstance() {
		return poolDataSource;
	}

	public Connection getConection(String dataSourceName) throws SQLException, ExcInvalidArgument {
		ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) C3P0Registry
				.pooledDataSourceByName(dataSourceName);
		if (comboPooledDataSource == null) 
			throw new ExcInvalidArgument(
					"El DataSource con Nombre= " + dataSourceName +" NO EXISTE");
		return comboPooledDataSource.getConnection();

	}
}