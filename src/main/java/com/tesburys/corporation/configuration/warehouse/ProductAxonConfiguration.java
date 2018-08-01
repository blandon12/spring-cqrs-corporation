package com.tesburys.corporation.configuration.warehouse;

import com.tesburys.corporation.warehouse.product.Product;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductAxonConfiguration {

    private EventStore eventStore;

    public ProductAxonConfiguration(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Bean
    public Repository<Product> productRepository() {
        return new EventSourcingRepository<>(Product.class, eventStore);
    }
}
