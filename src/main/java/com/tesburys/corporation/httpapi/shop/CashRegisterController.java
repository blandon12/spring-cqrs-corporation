package com.tesburys.corporation.httpapi.shop;

import com.tesburys.corporation.command.shop.cashregister.RegisterCashRegisterCommand;
import com.tesburys.corporation.command.shop.cashregister.StartAcceptingProductsCommand;
import com.tesburys.corporation.httpapi.shop.contract.CashRegisterRegisteredResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/shop/cash-register")
public class CashRegisterController {

    private CommandGateway commandGateway;

    public CashRegisterController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CashRegisterRegisteredResponse register() {
        String cashRegisterId = UUID.randomUUID().toString();

        commandGateway.send(new RegisterCashRegisterCommand(cashRegisterId));

        return new CashRegisterRegisteredResponse(cashRegisterId);
    }

    @PostMapping("/start/{cashRegisterId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void startAcceptingProducts(@PathVariable("cashRegisterId") String cashRegisterId) {
        commandGateway.send(new StartAcceptingProductsCommand(cashRegisterId));
    }
}
