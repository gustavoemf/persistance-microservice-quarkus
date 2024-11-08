package br.com.exchangeratepersistence.repository;

import br.com.exchangeratepersistence.entity.ExchangeRateEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExchangeRateRepository implements PanacheRepository<ExchangeRateEntity> {
}
