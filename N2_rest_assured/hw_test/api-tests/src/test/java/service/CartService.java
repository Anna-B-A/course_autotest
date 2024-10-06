package service;

import io.restassured.response.Response;
import schema.AddCartRequest;

public class CartService {
    private final static String PATH = "/cart";

    public Response getCart() {
        return Service.prepareGet().get(PATH);
    }

    public Response addCart(AddCartRequest body) {
        return Service.preparePost(body).post(PATH);
    }
}
