package br.com.exchangeratepersistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_exchangeRates")
public class ExchangeRateEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID er_id;
    private String er_name;
    private double er_bid;
    private double er_ask;
    private String er_timestamp;

    public UUID getEr_id() { return er_id; }

    public void setEr_id(UUID er_id) { this.er_id = er_id; }

    public String getEr_name() { return er_name; }

    public void setEr_name(String er_name) { this.er_name = er_name; }

    public double getEr_bid() { return er_bid; }

    public void setEr_bid(double er_bid) { this.er_bid = er_bid; }

    public double getEr_ask() { return er_ask; }

    public void setEr_ask(double er_ask) { this.er_ask = er_ask; }

    public String getEr_timestamp() { return er_timestamp; }

    public void setEr_timestamp(String er_timestamp) { this.er_timestamp = er_timestamp; }
}
