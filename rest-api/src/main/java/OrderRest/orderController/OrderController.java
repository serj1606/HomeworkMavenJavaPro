package OrderRest.orderController;

import OrderRest.entity.Order;
import OrderRest.service.OrderService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/orders")
public class OrderController {
  OrderService orderService = new OrderService();


  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response add(Order order) {
    return Response.ok(orderService.addOrder(order)).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOrder(@PathParam("id") int id) {
    return Response.ok(orderService.getOrderId(id)).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOrders() {
    return Response.ok(orderService.getAllOrders()).build();
  }

}

