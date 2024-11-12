package br.com.exchangeratepersistence.config;

import br.com.exchangeratepersistence.service.dto.ExchangeRateRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * Deserializa objetos {@link ExchangeRateRecord} a partir de uma representação em byte[].
 *
 * Esta classe implementa a interface {@link Deserializer} do Kafka, que define como
 * os dados recebidos em uma mensagem Kafka são convertidos de volta para objetos Java.
 *
 * A deserialização é realizada utilizando a biblioteca Jackson, que converte os dados
 * JSON em um objeto {@link ExchangeRateRecord}.
 */
public class ExchangeRateRecordDeserializer implements Deserializer<ExchangeRateRecord> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ExchangeRateRecord deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, ExchangeRateRecord.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing ExchangeRateRecord", e);
        }
    }
}