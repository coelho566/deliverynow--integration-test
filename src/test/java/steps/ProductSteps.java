package steps;

import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mock.ProductFactory;
import request.ProductRequest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductSteps {

    Gson gson = new Gson();
    Response response;
    ProductRequest productRequest;
    String produtoId;

    @Dado("que eu tenho os dados do produto")
    public void que_eu_tenho_os_dados_do_produto() {
       this.productRequest = ProductFactory.criarProdutoRequest();
    }

    @Quando("eu envio uma solicitação POST para o endpoint de produto")
    public void eu_envio_uma_solicitacao_post_para_o_endpoint_de_produto() {
        String jsonBody = gson.toJson(productRequest) ;

        response = given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("https://c4i60ds8a5.execute-api.us-east-1.amazonaws.com/application--deliverynow-product/product");
    }

    @Então("a resposta da api deve ter o código de status {int}")
    public void a_resposta_deve_ter_o_codigo_de_status(Integer codigoStatus) {
        assertEquals(codigoStatus, response.statusCode(), "Status code diferente do esperado!");
    }

    @Dado("que eu tenho o ID do produto {string}")
    public void que_eu_tenho_o_id_do_produto(String produtoId) {
        this.produtoId = produtoId;
    }

    @Quando("eu envio uma solicitação DELETE para o endpoint de produto")
    public void eu_envio_uma_solicitacao_delete_para_o_endpoint_de_produto() {
        response = given()
                .when()
                .delete("https://c4i60ds8a5.execute-api.us-east-1.amazonaws.com/application--deliverynow-product/product/" + produtoId);
    }

}
