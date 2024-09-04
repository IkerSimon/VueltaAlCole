package com.ipartek.modelo;

import java.sql.Connection;

public interface I_Metodos {

	Connection conectar();
	void desconectar(Connection con);

}
