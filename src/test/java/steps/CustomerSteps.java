package steps;


import com.google.gson.Gson;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import mock.CustomerFactory;
import utils.GeradorCPFUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CustomerSteps {

    Gson gson = new Gson();
    Response response;
    String customerData;
    String documento = GeradorCPFUtils.gerarCPF();

    @Dado("que queira registrar um cliente")
    public void que_queira_registrar_um_cliente() {
        var customerRequest = CustomerFactory.getCustomerRequest(documento);
        this.customerData = gson.toJson(customerRequest);
    }

    @Quando("submeter um novo cliente")
    public void submeter_um_novo_cliente() {
        response = given().contentType("application/json")
                .body(customerData)
                .when()
                .post("https://c4i60ds8a5.execute-api.us-east-1.amazonaws.com/application--deliverynow-user/customer");
    }

    @Então("o usuario é registrado")
    public void o_usuario_é_registrado() {
        response.then().statusCode(200);
    }

    @Dado("que eu tenho o documento do cliente {string}")
    public void que_eu_tenho_o_documento_do_cliente(String documento) {
        this.documento = documento;
    }

    @Quando("eu envio uma solicitação GET para o endpoint do cliente")
    public void eu_envio_uma_solicitacao_get_para_o_endpoint_do_cliente() {
        response = given()
//                .log().all()
                .queryParam("document", documento)
                .when()
                .get("https://c4i60ds8a5.execute-api.us-east-1.amazonaws.com/application--deliverynow-user/customer");
    }

    @Então("a resposta deve conter os detalhes do cliente")
    public void a_resposta_deve_conter_os_detalhes_do_cliente() {
        response.then().body("data.name", equalTo("Mario Word"))
                .body("data.document", equalTo("08197588471"))
                .body("data.email", equalTo("mario.word@example.com"))
                .body("data.phone", equalTo("1234567890"))
                .body("data.address.city", equalTo("Curitiba"))
                .body("data.address.state", equalTo("PR"))
                .body("data.address.street", equalTo("Rua Oziel Fonseca de Souza"))
                .body("data.address.numberAddress", equalTo("1457"))
                .body("data.address.postalCode", equalTo("81265-228"));
    }

    @Então("a resposta deve ter o código de status 200")
    public void a_resposta_deve_ter_o_codigo_de_status() {
        response.then().statusCode(200);
    }

//    @Dado("que eu tenho o documento do cliente {string}")
//    public void que_eu_tenho_o_documento_do_cliente(String documento) {
//        this.documento = documento;
//    }

    @Quando("eu envio uma solicitação GET para o endpoint de sessão do cliente")
    public void eu_envio_uma_solicitacao_get_para_o_endpoint_de_sessao_do_cliente() {
        response = given()
                .queryParam("document", documento)
                .when()
                .get("https://c4i60ds8a5.execute-api.us-east-1.amazonaws.com/application--deliverynow-user/customer/session");
    }

    @Entao("a resposta deve ter o código de status")
    public void a_resposta_deve_ter_o_codigo_de_status_ok() {
        response.then().statusCode(200);
    }

    @Entao("a resposta deve conter o ID da sessão do cliente")
    public void a_resposta_deve_conter_o_id_da_sessao_do_cliente() {
        response
                .then()
                .body("data", notNullValue());

    }


}
