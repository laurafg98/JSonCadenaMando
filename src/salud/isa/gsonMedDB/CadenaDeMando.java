package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class CadenaDeMando {
	protected CadenaDeMando sig;
	
	public CadenaDeMando(CadenaDeMando s) {
		sig = s;
	}
	abstract public StringBuffer lectura(String name, JsonReader reader) throws IOException;
	
	
}
