package kz.bitlab.spring.firstproject.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    private Long id;
    private String name;
    private String description;
    private double price;
}
