package br.com.exchangeratepersistence.service.dto;

public record ExchangeRateRecord(String name, double bid, double ask, String timestamp) {
}
