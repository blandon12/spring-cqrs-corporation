package com.tesburys.corporation.shop.cashregister;

import com.tesburys.corporation.command.shop.cashregister.AddProductCommand;
import com.tesburys.corporation.command.shop.cashregister.RegisterCashRegisterCommand;
import com.tesburys.corporation.command.shop.cashregister.ResolveCurrentErrorCommand;
import com.tesburys.corporation.command.shop.cashregister.StartAcceptingProductsCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CashRegisterCommandHandler {

    private static Logger logger = LoggerFactory.getLogger(CashRegisterCommandHandler.class);

    private ProductPriceLookup productPriceLookup;

    private Repository<CashRegister> cashRegisterRepository;

    public CashRegisterCommandHandler(Repository<CashRegister> cashRegisterRepository, ProductPriceLookup productPriceLookup) {
        this.cashRegisterRepository = cashRegisterRepository;
        this.productPriceLookup = productPriceLookup;
    }

    @CommandHandler
    public void handle(RegisterCashRegisterCommand command) throws Exception {
        cashRegisterRepository.newInstance(() -> new CashRegister(command.getId())); // lambda expression
    }

    @CommandHandler
    public void handle(StartAcceptingProductsCommand command) {
        Aggregate<CashRegister> cashRegisterAggregate = cashRegisterRepository.load(command.getCashRegisterId());

        cashRegisterAggregate.execute(cashRegister -> {
            try {
                cashRegister.startAcceptingProducts();
            } catch (Exception e) {
                logger.error("Couldn't start accepting products");
            }
        });
    }

    @CommandHandler
    public void handle(AddProductCommand command) {
        Aggregate<CashRegister> cashRegisterAggregate = cashRegisterRepository.load(command.getCashRegisterId());

        Optional<BigDecimal> optionalProductPrice = productPriceLookup.findPriceForProductCode(command.getProductCode());

        if (optionalProductPrice.isPresent()) {
            cashRegisterAggregate.execute(cashRegister -> {
                try {
                    cashRegister.addProduct(command.getProductCode(), optionalProductPrice.get());
                } catch (Exception e) {
                    logger.error(String.format("Couldn't start accepting products %s", command.getProductCode()));
                }
            });
        } else {
            cashRegisterAggregate.execute(cashRegister -> {
                cashRegister.changeToErrorProductPriceNotFound(command.getProductCode());
            });
        }
    }

    @CommandHandler
    public void handle(ResolveCurrentErrorCommand command) {

        Aggregate<CashRegister> cashRegisterAggregate = cashRegisterRepository.load(command.getCashRegisterId());

        cashRegisterAggregate.execute(CashRegister::resolveCurrentError);
    }
}
