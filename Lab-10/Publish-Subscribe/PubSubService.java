import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PubSubService {
    @WebMethod
    void publish(String message);
}