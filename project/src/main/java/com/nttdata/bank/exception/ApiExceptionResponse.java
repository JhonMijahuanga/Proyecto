package com.nttdata.bank.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contiene las variables que se utilizaran en caso que haya una excepcion.
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiExceptionResponse {

  private Date date;
  private String errorMessage;
  private String path;
}
