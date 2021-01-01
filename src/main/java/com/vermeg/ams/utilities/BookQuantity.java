package com.vermeg.ams.utilities;

public class BookQuantity {
	long idbook;
	int quantiy;
	
	@Override
	public String toString() {
		return "BookQuantity [idbook=" + idbook + ", quantiy=" + quantiy + "]";
	}

	public BookQuantity(long idbook, int quantiy) {
		this.idbook = idbook;
		this.quantiy = quantiy;
	}

	public long getIdbook() {
		return idbook;
	}

	public void setIdbook(long idbook) {
		this.idbook = idbook;
	}

	public int getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}

	
}
