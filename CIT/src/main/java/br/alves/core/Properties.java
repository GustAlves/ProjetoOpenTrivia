package br.alves.core;

public class Properties {
	public static boolean FECHAR_BROWSER = true;

	public static Browsers BROWSER = Browsers.CHROME;

	public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.GRID;

	public enum Browsers {
		CHROME, FIREFOX, IE
	}

	public enum TipoExecucao {
		LOCAL, GRID, NUVEM
	}
}
