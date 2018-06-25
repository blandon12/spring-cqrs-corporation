package com.tesburys.corporation.configuration.shop;

import com.tesburys.corporation.shop.cashregister.CashRegister;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CashRegisterAxonConfiguration {

    private EventStore eventStore;

    public CashRegisterAxonConfiguration(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Bean
    public Repository<CashRegister> cashRegisterRepository() {
        return new EventSourcingRepository<>(CashRegister.class, eventStore);
    }
}
