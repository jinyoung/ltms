package newtest.infra;

import java.io.IOException;
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
        try {
            if (!produced.validate()) return;

            // view 객체 생성
            ProductionByMonth productionByMonth = new ProductionByMonth();
            // view 객체에 이벤트의 Value 를 set 함
            productionByMonth.setAmount(
                productionByMonth.getAmount() +
                Long.valueOf(produced.getSalesItems())
            );
            // view 레파지 토리에 save
            productionByMonthRepository.save(productionByMonth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenProduced_then_UPDATE_1(@Payload Produced produced) {
        try {
            if (!produced.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
