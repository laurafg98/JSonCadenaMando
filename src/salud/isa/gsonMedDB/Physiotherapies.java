package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Physiotherapies extends CadenaDeMando {
	private static final String PHYSIO_TAGNAME = "physiotherapies";
	private static final String NPHYSIO_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";
	
	public Physiotherapies(CadenaDeMando cm) {
		super(cm);
	}
	private StringBuffer readPhysiotherapies(JsonReader reader) throws IOException {
		StringBuffer physioData = new StringBuffer();
		reader.beginArray();
		while (reader.hasNext()) {
			reader.beginObject();
			physioData.append(readPhysioEntry(reader)).append("\n");
			reader.endObject();
		}
		physioData.append("\n");
		reader.endArray();
		return physioData;
	}
	private String readPhysioEntry(JsonReader reader) throws IOException {
		// reader.require(XmlPullParser.START_TAG, ns, SINGLE_ELEMENT_TAGNAME);
				String phyName = null;
				String imName= null;
				while (reader.hasNext()) {
					String name = reader.nextName();
					if (name.equals(NPHYSIO_FIELD_TAGNAME)) {
						phyName = reader.nextString();
					} else if(name.equals(IMAGE_FIELD_TAGNAME)){
						imName=reader.nextString();	
					} else {
						reader.skipValue();
					}
				}

				return phyName + FIELD_SEPARATOR + imName + "\n";
	}
	public StringBuffer lectura(String name, JsonReader reader) throws IOException {
		StringBuffer readData = new StringBuffer();
		
		
		if(name.equals(PHYSIO_TAGNAME)){
			readData.append(readPhysiotherapies(reader)).append("\n");
			
		}else if(sig != null){
			readData.append(sig.lectura(name, reader));
		}else{
			reader.skipValue();
			System.err.println("Category " + name + " not processed.");
			
		}
		
		
		return readData;
	}

}
