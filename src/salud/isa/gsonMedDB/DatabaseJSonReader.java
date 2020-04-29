package salud.isa.gsonMedDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

/**
 * Created by jmalvarez on 11/5/16.
 * http://developer.android.com/intl/es/training/basics/network-ops/xml.html
 */
public class DatabaseJSonReader {

	CadenaDeMando cadenademando;
	JsonReader reader;
	
	public void CadenaMando(CadenaDeMando cm){
		cadenademando= cm;
	}
	
	public DatabaseJSonReader(JsonReader jr){
		reader=jr;
	}

	public String parse() throws IOException {

		
		reader.beginObject();
		
		StringBuffer readData = new StringBuffer();
		
		while (reader.hasNext()) {
			String name=reader.nextName();
			readData.append(cadenademando.lectura(name, reader)).append("\n");

			
		}

		reader.endObject();
		reader.close();
		
		
		
		
		return readData.toString();
		//return readData.toString();
	}


	

}
