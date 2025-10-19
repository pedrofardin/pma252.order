package store.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "order", url = "http://order:8080")
public interface OrderController {

    @PostMapping("/order")
    public ResponseEntity<OrderOut> create(
        @RequestHeader("Authorization") String token,
        @RequestHeader(value = "id-account", required = true) String accountId,
        @RequestBody OrderIn in
    );

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderOut> findById(
        @RequestHeader("Authorization") String token,
        @RequestHeader(value = "id-account", required = true) String accountId,
        @PathVariable("id") String id
    );

    @GetMapping("/order")
    public ResponseEntity<List<OrderOut>> findAll(
        @RequestHeader("Authorization") String token,
        @RequestHeader(value = "id-account", required = true) String accountId
    );

}
