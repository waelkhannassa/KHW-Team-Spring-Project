package com.vermeg.ams.utilities;

import java.util.List;

import com.vermeg.ams.entities.Command;

public class CommandRequest {
	Command command;
	List<BookQuantity> bookInCart;
	
	@Override
	public String toString() {
		return "CommandRequest [command=" + command + ", BookInCart=" + bookInCart + "]";
	}

	public CommandRequest(Command command, List<BookQuantity> bookInCart) {
		this.command = command;
		this.bookInCart = bookInCart;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public List<BookQuantity> getBookInCart() {
		return bookInCart;
	}

	public void setBookInCart(List<BookQuantity> bookInCart) {
		this.bookInCart = bookInCart;
	}
	
	
}
