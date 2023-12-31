package newtest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CreateSalesOrderCommand {

    private String salesPerson;
    private String companyId;
    private String salesType;
    private List<SalesItem> salesItems;
}
