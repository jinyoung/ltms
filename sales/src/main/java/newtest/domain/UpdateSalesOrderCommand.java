package newtest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateSalesOrderCommand {

    private String salesOrderNumber;
    private String salesPerson;
    private String companyId;
    private SalesType salesType;
    private List<SalesItem> salesItems;
}
