package OrderRest;

import OrderRest.orderController.OrderController;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;




@ApplicationPath("/rest")
public class AppOrder extends Application {

  private final Set<Object> singletons = new HashSet<>();


  public AppOrder(){
    singletons.add(new OrderController());
  }

  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }
}
