package newtest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newtest.InventoryApplication;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = InventoryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }
}
