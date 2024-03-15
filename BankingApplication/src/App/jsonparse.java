package App;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map; 

public class jsonparse {
	
	public static Map<String, String> countries(String file_path) {
		try(FileReader reader = new FileReader(file_path)){
			Type listType = new TypeToken<Map<String, String>>(){}.getType();
			Gson gson = new Gson();
			return gson.fromJson(reader, listType);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
