package com.wb.modelo;

import java.time.LocalDate;

public class RG {
	private LocalDate dataEmissaorg;
	private String rgcodigo;

	public RG(LocalDate dataEmissaorg, String rgcodigo) {
		this.dataEmissaorg = dataEmissaorg;
		this.rgcodigo = rgcodigo;
	}

	public LocalDate getDataEmissao() {
		return dataEmissaorg;
	}

	public String getRgcodigo() {
		return rgcodigo;
	}

	public void setRg(LocalDate dataEmissaorg, String rgcodigo) {
		this.dataEmissaorg = dataEmissaorg;
		this.rgcodigo = rgcodigo;
		
	}
}