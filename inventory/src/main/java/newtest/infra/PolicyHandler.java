package newtest.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import newtest.config.kafka.KafkaProcessor;
import newtest.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}


    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Produced'")
    public void wheneverProduced_updateStock(@Payload Produced produced){

        Inventory.addToInventory(produced);


    }

}
//>>> Clean Arch / Inbound Adaptor
