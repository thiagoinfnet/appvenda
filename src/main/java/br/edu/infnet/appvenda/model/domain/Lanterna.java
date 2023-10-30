package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TLanterna")
public class Lanterna extends Produto {
	private String led;
	private Integer bateria;
	
	public String getLed() {
		return led;
	}
	public void setLed(String led) {
		this.led = led;
	}
	public Integer getBateria() {
		return bateria;
	}
	public void setBateria(Integer bateria) {
		this.bateria = bateria;
	}
	
	@Override
	public String toString() {
	    return String.format("%s - %s - %s", super.toString(), led, bateria);
	}

}
