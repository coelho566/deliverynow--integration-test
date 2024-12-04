package request;



import java.util.List;

public record ProductRequest(
        String name,

        String description,

        String category,
        Double price,
        String image,

        Boolean availability,

        List<String> ingredients,

        String breadType,
        String dessertType,

        String beverageType,

        String portionSize,

        Double weight,

        Integer calories,

        Integer volume
) { }
