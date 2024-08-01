package com.example.shawarmahouse.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="menuItems")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuItem {
    @Id
    private String item_id;
    private String name;
    private String description;
    private long price;
    private String category;
    private String photo; // Storing the photo as binary data
    private String subCategory;

}
