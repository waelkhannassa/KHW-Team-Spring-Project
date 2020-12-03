package com.sip.ams.service;



import java.util.List;

import org.springframework.stereotype.Service;
import com.sip.ams.entities.Book;
@Service("CommandService")
public class CommandService {

	public static double totalPrice (List <Book> lb)
	{
		double pricet=0;
		for (int i=0; i<lb.size(); i++)
		{
			Book b = lb.get(i);
			
			pricet += b.getPrice(); 
		}
		return pricet; 
	}
	
	
}
