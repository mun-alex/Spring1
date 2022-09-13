package kz.bitlab.spring.firstproject.models;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProductItem {
    private Long id;
    private String name;
    private String description;
    private double price;

    public ProductItem() {
        System.out.println("new ProductItem is created");
    }
}
