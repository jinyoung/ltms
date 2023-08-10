package newtest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import newtest.infra.AbstractEvent;

@Data
public class Produced extends AbstractEvent {

    private String salesOrderNumber;
    private String salesPerson;
    private String salesType;
    private List<Map> salesItems;
}
