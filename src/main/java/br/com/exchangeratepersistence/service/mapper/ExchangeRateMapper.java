package br.com.exchangeratepersistence.service.mapper;

import br.com.exchangeratepersistence.entity.ExchangeRateEntity;
import br.com.exchangeratepersistence.service.dto.ExchangeRateRecord;

/**
 * Classe de mapeamento para converter entre {@link ExchangeRateRecord} e {@link ExchangeRateEntity}.
 */
public class ExchangeRateMapper {
    public static ExchangeRateEntity toEntity(ExchangeRateRecord record){
        ExchangeRateEntity entity = new ExchangeRateEntity();
        entity.setEr_name(record.name());
        entity.setEr_bid(record.bid());
        entity.setEr_ask(record.ask());
        entity.setEr_timestamp(record.timestamp());
        return entity;
    }
}
