package stateMachine.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Order {
    private int id;
    private OrderStatus status;

    @Override
    public String toString() {
        return "订单号：" + id + ", 订单状态：" + status;
    }
}
