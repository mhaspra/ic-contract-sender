package ch.mhaspra.insurancecase.iccontractsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class ContractDataGenerator {
    private final ContractDataStreamBridge contractDataStreamBridge;

    @Autowired
    public ContractDataGenerator(ContractDataStreamBridge contractDataStreamBridge) {
        this.contractDataStreamBridge = contractDataStreamBridge;
    }

    @Scheduled(initialDelay = 5000L, fixedRate = 1000L)
    void send(){
        var partnerNr = ThreadLocalRandom.current().nextLong(1, 21);
        var contractNr = partnerNr * 100 + ThreadLocalRandom.current().nextLong(1, 6);
        var active = ThreadLocalRandom.current().nextBoolean();

        var contract = new Contract(contractNr, partnerNr, "Policy-" + contractNr, active);

        contractDataStreamBridge.send(contract);
    }
}
