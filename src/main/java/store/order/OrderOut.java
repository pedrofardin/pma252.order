package store.order;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder
public record OrderOut(
    String id,
    LocalDateTime date,
    List<ItemOut> items,
    Double total
) {

    @Builder
    public record ItemOut(
        String id,
        ProductId product,
        int quantity,
        double total
    ) {
    }

    @Builder
    public record ProductId(
        String id
    ) {
    }

}