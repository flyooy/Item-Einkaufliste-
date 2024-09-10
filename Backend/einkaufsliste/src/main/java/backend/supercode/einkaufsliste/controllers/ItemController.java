package backend.supercode.einkaufsliste.controllers;

import backend.supercode.einkaufsliste.entitites.Item;
import backend.supercode.einkaufsliste.repositories.ItemRepository;
import backend.supercode.einkaufsliste.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
       itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        Item updated = itemService.updateItem(id, updatedItem);
        return ResponseEntity.ok(updated);
    }
}