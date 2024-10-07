package net.mephys.arkheion.catalog.component;

import jakarta.annotation.PostConstruct;
import net.mephys.arkheion.catalog.exception.CatalogItemNotFoundException;
import net.mephys.arkheion.catalog.model.CatalogBaseItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Catalog {

    private static Integer idCounter = 0;

    public static Integer getIdCounter() {
        return ++idCounter;
    }

    private final ModelMapper modelMapper;

    private List<CatalogBaseItem> db;

    public Catalog(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        db = new ArrayList<>();
    }

    public void insert(CatalogBaseItem item) {
        if (item != null) db.add(item);
    }

    public List<CatalogBaseItem> getDatabase() {
        return db;
    }

    public CatalogBaseItem getItemById(int id) {
        for (CatalogBaseItem item : db) {
            if (item.getUniqueId() == id) {
                return item;
            }
        }
        return null;
    }

    public void deleteItem(int id) {
        CatalogBaseItem item = getItemById(id);
        if (item == null) throw new CatalogItemNotFoundException(id);
        db.remove(item);
    }

    public void deleteAll() {
        db.clear();
        idCounter = 0;
    }

}
