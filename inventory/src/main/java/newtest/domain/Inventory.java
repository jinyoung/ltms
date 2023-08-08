package newtest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.*;
import lombok.Data;
import newtest.InventoryApplication;

@Entity
@Table(name = "Inventory_table")
@Data
public class Inventory {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    private ProductId productId; //   private Long id;

    private Long stock;

    


    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    public static void updateInventory(Produced produced) {



        //implement business logic here:

        produced.getSalesItems().forEach(item -> {

            Inventory inventory = new Inventory();
            inventory.setStock(0L);

            Map productIdMap = (Map)item.get("productId");

            ProductId id = new ProductId((Long)productIdMap.get("id"));
            Optional<Inventory> finding = repository().findById(id);
            if(finding.isPresent()){
                inventory = finding.get();
            }

            inventory.setStock(inventory.getStock() + (Long)item.get("qty"));
            repository().save(inventory);
    
        });


        /** Example 2:  finding and process
        
        repository().findById(produced.get???()).ifPresent(inventory->{
            
            inventory // do something
            repository().save(inventory);


         });
        */

    }
}
