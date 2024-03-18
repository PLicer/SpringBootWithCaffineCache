package springBootWithJpa.SpringBootWithJpa.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "Product_Table",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "Name_unique",
                columnNames = "name"
        )
        }
)
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
    private String Sku;
    private String description;
    private int price;


}
