package request;


public record CustomerRequest(


        String name,

        String phone,

        String email,

        String document,

        String documentType,

        boolean allowNotification,

        String postalCode,

        String numberAddress,

        String password
) {
}
