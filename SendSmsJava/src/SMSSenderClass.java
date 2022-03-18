import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class SMSSenderClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String apikey="apikey="+"NTIzNzRlNTczMDM4NzAzODZhNjY2NTU2NTg3ODU4Nzk";
			String message="&message"+"message java application";
//		String senfder=""+TXTCL";
			String numbers="&numbers"+"+21651519852";
			HttpURLConnection conn=(HttpURLConnection) new URL("https://api.textLocal.In/send/").openConnection();
			String data=apikey+numbers+message;
			
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			conn.setRequestProperty("Content-length", Integer.toString(data.length()));
			
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			
			BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer stringBuffer=new StringBuffer();
			
			
			String line;
			while ((line=rd.readLine())!=null) {
				stringBuffer.append(line).append("/n");
			}
			System.out.print(stringBuffer.toString());
			rd.close();}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
