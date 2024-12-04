package mock;


import entity.Address;
import entity.Customer;
import request.CustomerRequest;

public class CustomerFactory {

    public static CustomerRequest getCustomerRequest(String document){

        return new CustomerRequest("Mario", "9999-9999", "word@example.com",
                document, "CPF", true, "81265-228", "1457", "password");
    }

    public static Customer getCustomerEntity(){
        return Customer.builder()
                .name("Mario")
                .phone("9999-9999")
                .email("word@example.com")
                .document("08197588974")
                .documentType("CPF")
                .allowNotification(true)
                .address(getAddress())
                .build();
    }

    public static Address getAddress(){
        return Address.builder()
                .city("Curitiba")
                .state("PR")
                .postalCode("81265-228")
                .numberAddress("1457")
                .build();
    }
}
