package ma.fstt.market_place_api.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @OneToOne
    @JoinColumn(name = "id_fournissuer")
    @JsonIgnore
    private Fournisseur fournisseur;


    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();
}
