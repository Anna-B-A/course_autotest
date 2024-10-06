package schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(force = true)
@Value
public class Cart {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    @JsonProperty("category")
    String category;

    @JsonProperty("price")
    double price;

    @JsonProperty("discount")
    double discount;

    @JsonProperty("quantity")
    int quantity;

}
