package br.com.exchangeratepersistence.service;

import br.com.exchangeratepersistence.entity.ExchangeRateEntity;
import br.com.exchangeratepersistence.repository.ExchangeRateRepository;
import br.com.exchangeratepersistence.service.dto.ExchangeRateRecord;
import br.com.exchangeratepersistence.service.mapper.ExchangeRateMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

/**
 * Serviço responsável pela persistência das taxas de câmbio.
 *
 * Ele utiliza o repositório {@link ExchangeRateRepository} e o mapeador {@link ExchangeRateMapper} para realizar
 * a conversão de dados e a persistência das entidades.
 */
@ApplicationScoped
public class ExchangeRatePersistenceService {
    @Inject
    ExchangeRateRepository repository;

    @Transactional
    @Incoming("exchange-rates")
    public ExchangeRateEntity createExchangeRate(ExchangeRateRecord exchangeRateRecord) {
        ExchangeRateEntity exchangeRateEntity = ExchangeRateMapper.toEntity(exchangeRateRecord);

        repository.persist(exchangeRateEntity);

        return exchangeRateEntity;
    }
}
