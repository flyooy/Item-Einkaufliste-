package backend.supercode.einkaufsliste.repositories;


import backend.supercode.einkaufsliste.entitites.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
