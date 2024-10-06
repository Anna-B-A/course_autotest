package schema;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class GetProductResponse {
    List<Cart> carts;
}
