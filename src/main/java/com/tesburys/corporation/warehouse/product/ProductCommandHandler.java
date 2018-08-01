package com.tesburys.corporation.warehouse.product;

import com.tesburys.corporation.command.warehouse.product.AcceptDeliveryCommand;
import com.tesburys.corporation.command.warehouse.product.CreateProductCommand;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandHandler {
    private Repository<Product> productRepository;

    public ProductCommandHandler(Repository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    public void handle(CreateProductCommand command) throws Exception {
        productRepository.newInstance(() -> new Product(command.getProductCode()));
    }

    public void handle(AcceptDeliveryCommand command) {
        Aggregate<Product> productAggregate = productRepository.load(command.getProductCode());

        productAggregate.execute(product -> product.acceptDelivery(command.getAmount()));
    }
}
