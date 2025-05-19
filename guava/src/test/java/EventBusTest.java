import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * @author  CarpCap
 */
public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
        eventBus.register(new OrderEventListener());
        eventBus.register(new OrderEventListener2());
        eventBus.post(new OrderMessage("csc"));
        System.out.println("完成");
    }
}


class OrderMessage {
    private String message;

    public OrderMessage(String csc) {
        message=csc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class OrderEventListener {
    @Subscribe
    public void dealWithEvent(OrderMessage event) {
        System.out.println("内容：" + event.getMessage());
    }
}

class OrderEventListener2 {
    @Subscribe
    public void dealWithEvent(OrderMessage event) {
        System.out.println("内容2：" + event.getMessage());
    }
}