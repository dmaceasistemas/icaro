package reportes.factorias;


public class FormatoFactory {

	@SuppressWarnings("unused")
	static private FormatoFactory formatoFactory = new FormatoFactory();
	/*
	private Map<Integer, Formato> formatos = new HashMap<Integer, Formato>();

	private FormatoFactory() {
	}

	static public FormatoFactory getInstance() {
		return formatoFactory;
	}

	public Formato getFormato(String idFormato)
			throws CloneNotSupportedException, InvalidArgumentexception {
		if (idFormato == null)
			throw new InvalidArgumentexception("Esperado parametro: formatoReporte");
		Formato formato = formatos.get(Integer.valueOf(idFormato));
		if (formato == null)
			throw new InvalidArgumentexception("El Formato de Reporte con id= "
					+ idFormato + " no esta Registrado");
		return (Formato) formato.clone();
	}

	public void cargarFormatosReportes() throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException,
			InvalidArgumentexception {
		Connection connection = PoolDataSource.getInstance().getConection(PoolDataSource.POSTGRES);
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("Select id,clase from Formatos");
			this.formatos.clear();
			while (rs.next()) {
				Formato formato = (Formato) Class.forName(rs.getString(2))
						.newInstance();
				this.formatos.put(rs.getInt(1), formato);
			}
		} catch (SQLException e) {
			connection.close();
			throw e;
		}
	}*/

}