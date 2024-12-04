package mock;

import com.google.gson.Gson;
import request.ProductRequest;
import utils.JsonUtils;

public class ProductFactory {

    static Gson gson = new Gson();
    public static ProductRequest criarProdutoRequest(){
        var json = JsonUtils.parseJSONFile("produto_request");

        return gson.fromJson(json, ProductRequest.class);
    }
}
