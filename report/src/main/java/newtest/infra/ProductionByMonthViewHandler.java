package newtest.infra;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import newtest.config.kafka.KafkaProcessor;
import newtest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ProductionByMonthViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ProductionByMonthRepository productionByMonthRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProduced_then_CREATE_1(@Payload Produced produced) {
        //try {
            if (!produced.validate()) return;

            // view 객체 생성
            ProductionByMonth productionByMonth = new ProductionByMonth();
            // view 객체에 이벤트의 Value 를 set 함
            SimpleDateFormat formatter = new SimpleDateFormat("yyMM");

            productionByMonth.setYymm(formatter.format(produced.getProductionDate()));
            productionByMonth.setYear(produced.getProductionDate().getYear()+1900);
            productionByMonth.setMonth(produced.getProductionDate().getMonth()+1);

            if(produced.getSalesItems()!=null){
                long sumOfProductionQty = produced.getSalesItems().stream().map(a->((Number)a.get("qty")).longValue()).reduce(0L, (a,b)-> a+b);

                productionByMonth.setAmount(
                    (productionByMonth.getAmount()!=null ? productionByMonth.getAmount().longValue() : 0L) +
                    (produced.getSalesItems()!=null ? sumOfProductionQty : 0L)
                );
            }
            // view 레파지 토리에 save
            productionByMonthRepository.save(productionByMonth);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

}
