package com.example.gestindeproductosapi.business.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessErrorCodes {

  GENERIC_ERROR("GENERIC_001", "Error de negocio", "Ocurrió un error de negocio inesperado"),
  EXTERNAL_API_ERROR("EXT_001", "Error de integración", "Ocurrió un error al comunicarse con un servicio externo");

  private final String code;
  private final String title;
  private final String description;

}
