package com.store.api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Purchaseprice
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-11T09:30:03.205722600+05:30[Asia/Calcutta]")
public class Purchaseprice {

  private Long stockId;

  private Float priceperUnit;

  public Purchaseprice() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Purchaseprice(Long stockId, Float priceperUnit) {
    this.stockId = stockId;
    this.priceperUnit = priceperUnit;
  }

  public Purchaseprice stockId(Long stockId) {
    this.stockId = stockId;
    return this;
  }

  /**
   * Unique identifier
   * @return stockId
  */
  @NotNull 
  @Schema(name = "stockId", description = "Unique identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stockId")
  public Long getStockId() {
    return stockId;
  }

  public void setStockId(Long stockId) {
    this.stockId = stockId;
  }

  public Purchaseprice priceperUnit(Float priceperUnit) {
    this.priceperUnit = priceperUnit;
    return this;
  }

  /**
   * Unit price of the product
   * @return priceperUnit
  */
  @NotNull 
  @Schema(name = "priceperUnit", description = "Unit price of the product", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("priceperUnit")
  public Float getPriceperUnit() {
    return priceperUnit;
  }

  public void setPriceperUnit(Float priceperUnit) {
    this.priceperUnit = priceperUnit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Purchaseprice purchaseprice = (Purchaseprice) o;
    return Objects.equals(this.stockId, purchaseprice.stockId) &&
        Objects.equals(this.priceperUnit, purchaseprice.priceperUnit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stockId, priceperUnit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Purchaseprice {\n");
    sb.append("    stockId: ").append(toIndentedString(stockId)).append("\n");
    sb.append("    priceperUnit: ").append(toIndentedString(priceperUnit)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

