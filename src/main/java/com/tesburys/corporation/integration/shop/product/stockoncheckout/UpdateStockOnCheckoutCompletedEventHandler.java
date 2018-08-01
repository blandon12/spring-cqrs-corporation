package com.tesburys.corporation.integration.shop.product.stockoncheckout;

import com.tesburys.corporation.command.shop.product.DecreaseProductStockCommand;
import com.tesburys.corporation.events.shop.cashregister.CheckoutCompletedEvent;
import com.tesburys.corporation.events.shop.cashregister.dto.BasketLine;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateStockOnCheckoutCompletedEventHandler {

    private CommandGateway commandGateway;

    public UpdateStockOnCheckoutCompletedEventHandler(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @EventHandler
    public void on(CheckoutCompletedEvent event) {
        event.getProducts().stream()
                .map(BasketLine::getProductCode)
                .forEach(productCode -> commandGateway.send(
                        new DecreaseProductStockCommand(productCode, 1))
                );
    }
}