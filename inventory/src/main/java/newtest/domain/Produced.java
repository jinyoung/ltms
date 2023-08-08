package newtest.domain;

import java.util.*;
import lombok.*;
import newtest.domain.*;
import newtest.infra.AbstractEvent;

@Data
@ToString
public class Produced extends AbstractEvent {

    private String salesOrderNumber;
    private String salesPerson;
    private String salesType;
    private Object salesItems;
    private Object companyId;
}
