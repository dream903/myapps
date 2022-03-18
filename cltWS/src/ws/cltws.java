package ws;

import javax.xml.rpc.ServiceException;

public class cltws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	BanqueService proxy=new BanqueWSLocator().getBanqueServicePort();
	System.out.println(proxy.conversionEuroToDH(1000));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
