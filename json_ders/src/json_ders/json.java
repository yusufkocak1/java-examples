package json_ders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class json {
	
	public JSONArray create_json(){
		
		//ArrayList<JSONArray> list=new ArrayList<>();
		JSONArray array=new JSONArray();
		for (int i=0;i<10;i++){			
		JSONObject obj=new JSONObject();
        obj.put("name", "ayþe"+i);	
        obj.put("surname", "Burak"+i);
        array.add(obj);		
		}
	
		
		return array;
		
	}
	
	public void json_parser(){
		JSONParser parser=new JSONParser();
		
		
		try {
			
			JSONArray array=(JSONArray)parser.parse(getjsonstring());
			JSONObject jsonObject= (JSONObject) array.get(0);
			System.out.println(jsonObject.get("kullanici_adi"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getjsonstring(){
		String myURL = "http://localhost/kullanici_select";
		
		URLConnection urlConn=null;
		InputStreamReader is=null;
		
		String text="";
		try {
			
			URL url=new URL(myURL);
			urlConn = url.openConnection();
			
			is=new InputStreamReader(urlConn.getInputStream());
			BufferedReader br=new BufferedReader(is);
			if(br!=null){
				String line;
				while((line=br.readLine()) != null){
					
				text+=line;
				}
				br.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(text);
		
		return text;
		
	}
	

}
