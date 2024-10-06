package schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

@Value
public class AddCartRequest implements Schema{

    @JsonProperty("product_id")
    int productId;

    @JsonProperty("quantity")
    int quantity;

    public AddCartRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
