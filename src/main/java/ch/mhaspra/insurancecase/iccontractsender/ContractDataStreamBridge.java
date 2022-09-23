package ch.mhaspra.insurancecase.iccontractsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContractDataStreamBridge {
    private final StreamBridge streamBridge;

    @Autowired
    public ContractDataStreamBridge(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void send(Contract contract){
        var message = MessageBuilder
                .withPayload(contract)
                .setHeader(KafkaHeaders.KEY, contract.contractNr())
                .build();
        streamBridge.send("contract-data-out", message);
    }

}
