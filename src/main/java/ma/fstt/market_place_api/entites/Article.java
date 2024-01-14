package ma.fstt.market_place_api.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libelle;
//    private String imageUrl;
    private Float pu;

    @ManyToOne
    @JoinColumn(name = "id_store")
    @JsonIgnore
    private Store store;


    @ManyToOne
    @JoinColumn(name = "id_categorie")
    @JsonIgnore
    private Categorie categorie;

}
