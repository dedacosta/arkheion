package net.mephys.arkheion.xml.db.component;

import jakarta.annotation.PostConstruct;
import net.mephys.arkheion.xml.db.model.BaseItem;
import net.mephys.arkheion.xml.db.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlDatabase {

    private List<BaseItem> db;

    @PostConstruct
    public void init() {
        db = new ArrayList<>();
    }

    public void insert(BaseItem item) {
        String uniqueId = item.getUniqueId();
        if (uniqueId == null || uniqueId.isEmpty() || uniqueId.isBlank()) {
            item.updateUniqueId();
            item.updateModificationTime();
        }
        db.add(item);
    }

    public List<BaseItem> getDatabase() {
        return db;
    }

    public BaseItem getItemById(int id){
        return db.get(id);
    }

    public void deleteItem(int id){
      db.remove(id);
    }

    public void deleteAll(){
        db.clear();
    }

    public void updateItem(int id, BaseItem other){
        BaseItem item = getItemById(id);
        item.updateFrom(other);
    }

}
