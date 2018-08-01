package com.tesburys.corporation.shop.product;

import com.tesburys.corporation.command.shop.product.AddProductWithPriceCommand;
import com.tesburys.corporation.command.shop.product.ChangeProductPriceCommand;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandHandler {

    private Repository<Product> productRepository;


    public ProductCommandHandler(Repository<Product> productRepository) {
        this.productRepository = productRepository;
    }

    public void handle(AddProductWithPriceCommand command) throws Exception {
        productRepository.newInstance(() ->
            new Product(command.getProductCode(), command.getPrice())
        );
    }

    public void handle(ChangeProductPriceCommand command) {
        Aggregate<Product> productAggregate = productRepository.load(command.getProductCode());

        productAggregate.execute(product -> product.changePrice(command.getPrice()));
    }
}
