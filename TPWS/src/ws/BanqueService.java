package ws;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="BanqueWS")
public class BanqueService {
	
@WebMethod(operationName="ConversionEuroToDH")
public double conversion(double mt) {
	return mt*10.6;
}
	
}
