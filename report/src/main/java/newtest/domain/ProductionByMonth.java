package newtest.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ProductionByMonth_table")
@Data
public class ProductionByMonth {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String yymm;

    private Long amount;
}
