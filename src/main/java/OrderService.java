import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * {@code OrderService} Order relate service.
 *
 * <p> order create, cancel
 *
 * @see Order
 * @author sunbird
 * @since 2019/12/21
 */
public class OrderService {

    /** default value {@value} */
    private static final Integer QUANTITY = 1;

    /**
     * order create.
     *
     * <p> use user id and goods list to create order.
     *
     * <p><pre>{@code
     *  demo on how to use it
     *  List<Goods> items = new ArrayList<>();
     *  Goods goods = new Goods(1L, BigDecimal.ONE);
     *  Goods goods2 = new Goods(2L, BigDecimal.TEN);
     *  items.add(goods);
     *  items.add(goods2);
     *
     *  Order order1 = new Order();
     *  order.setUserId("1");
     *  order.setItems(items);
     *  OrderService#createOrder(order);
     * }
     * </pre>
     *
     * @param order order info
     * @throws NullPointerException parameter is null
     * @exception IllegalArgumentException  invalid count
     * @return if create successfully
     * @see Order
     */
    public boolean createOrder(Order order) throws IllegalArgumentException{
        Objects.requireNonNull(order);

        List<Goods> items = order.getItems();
        items.forEach(goods -> {
            BigDecimal quantity = goods.getQuantity();
            if (quantity == null || BigDecimal.ZERO.compareTo(quantity) == 0) {
                throw new IllegalArgumentException();
            }
        });

        System.out.println("create order...");

        return true;
    }
}