package com.tesburys.corporation.shop.cashregister;

import com.tesburys.corporation.command.shop.cashregister.RegisterCashRegisterCommand;
import com.tesburys.corporation.command.shop.cashregister.StartAcceptingProductsCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CashRegisterCommandHandler {

    private static Logger logger = LoggerFactory.getLogger(CashRegisterCommandHandler.class);
    private Repository<CashRegister> cashRegisterRepository;

    public CashRegisterCommandHandler(Repository<CashRegister> cashRegisterRepository) {
        this.cashRegisterRepository = cashRegisterRepository;
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
}
