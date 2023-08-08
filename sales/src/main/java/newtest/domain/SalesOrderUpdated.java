package newtest.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import newtest.domain.*;
import newtest.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SalesOrderUpdated extends AbstractEvent {

    private String salesOrderNumber;

    public SalesOrderUpdated(SalesOrder aggregate) {
        super(aggregate);
    }

    public SalesOrderUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
