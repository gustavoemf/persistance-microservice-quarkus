package br.com.exchangeratepersistence.service;

import br.com.exchangeratepersistence.entity.ExchangeRateEntity;
import br.com.exchangeratepersistence.repository.ExchangeRateRepository;
import br.com.exchangeratepersistence.service.dto.ExchangeRateRecord;
import br.com.exchangeratepersistence.service.mapper.ExchangeRateMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ExchangeRatePersistenceService {
    @Inject
    ExchangeRateRepository repository;

    @Transactional
    @Incoming("exchange-rates")
    public ExchangeRateEntity createExchangeRate(ExchangeRateRecord exchangeRateRecord) {
        ExchangeRateEntity exchangeRateEntity = ExchangeRateMapper.toEntity(exchangeRateRecord);

        repository.persist(exchangeRateEntity);

        System.out.println(exchangeRateEntity.getEr_name());
        System.out.println(exchangeRateEntity.getEr_bid());
        System.out.println(exchangeRateEntity.getEr_ask());
        System.out.println(exchangeRateEntity.getEr_timestamp());

        return exchangeRateEntity;
    }
}
