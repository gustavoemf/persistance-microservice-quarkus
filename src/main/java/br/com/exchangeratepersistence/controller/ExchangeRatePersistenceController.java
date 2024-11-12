package br.com.exchangeratepersistence.controller;

import br.com.exchangeratepersistence.service.ExchangeRatePersistenceService;
import br.com.exchangeratepersistence.service.dto.ExchangeRateRecord;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * Controlador REST para persistir taxas de câmbio no banco de dados.
 *
 * O controlador usa o {@link ExchangeRatePersistenceService} para realizar a persistência dos dados.
 */
@Path("/api/exchange-rate")
public class ExchangeRatePersistenceController {

    @Inject
    private ExchangeRatePersistenceService persistenceService;

    @POST
    @Transactional
    public Response createExchangeRate(ExchangeRateRecord exchangeRateRecord) {
        return Response.ok(persistenceService.createExchangeRate(exchangeRateRecord)).build();
    }
}
