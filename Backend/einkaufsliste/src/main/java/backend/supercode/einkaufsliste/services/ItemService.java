package backend.supercode.einkaufsliste.services;

import backend.supercode.einkaufsliste.entitites.Item;
import backend.supercode.einkaufsliste.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void deleteItem(long id){
        itemRepository.deleteById(id);
    }


    public Item updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setGekauft(updatedItem.isGekauft());
                    return itemRepository.save(item);
                })
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));
    }
}