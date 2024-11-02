package edu.miu.cse.learn101.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "publishers")
public class Publisher {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "publisher_name")
    @NotBlank(message = "Not null, not empty, and trimmed (no whitespace only)")
    private String publisherName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address primaryAddress;
    @OneToMany(mappedBy = "publisher")
    private List<Book> book;//Publisher -||------|<-Book

    public Publisher(String publisherName, Address primaryAddress) {
        this.publisherName = publisherName;
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", primaryAddress=" + primaryAddress +
                '}';
    }
}
