import javax.xml.ws.Endpoint;

import ws.BanqueService;

public class ServeurJaxWS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://0.0.0.0:8686/";
		Endpoint.publish(url,new BanqueService());
		System.out.println("web s dep sur"+url);
	}
	

}
