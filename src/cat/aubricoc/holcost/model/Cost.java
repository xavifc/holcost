package cat.aubricoc.holcost.model;

import java.util.Date;
import java.util.List;

public class Cost {

	private Long id;
	
	private String name;
	
	private Double amount;
	
	private Date date;
	
	private Dude payer;
	
	private Long holcostId;
	
	private List<Dude> participants;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Dude getPayer() {
		return payer;
	}

	public void setPayer(Dude payer) {
		this.payer = payer;
	}

	public Long getHolcostId() {
		return holcostId;
	}

	public void setHolcostId(Long holcostId) {
		this.holcostId = holcostId;
	}
	
	public List<Dude> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Dude> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return this.name + " ::: " + this.amount;
	}
}
