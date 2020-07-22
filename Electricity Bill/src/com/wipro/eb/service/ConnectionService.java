package com.wipro.eb.service;


import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException{
		if(currentReading<previousReading || currentReading<0 || previousReading<0){
			throw new InvalidReadingException();
		}
		if(!type.equals("Domestic") && !type.equals("Commercial")) {
			throw new InvalidConnectionException();
		}
		return true;
	}
	public float calculateBillAmt(int currentReading, int previousReading, String type) {
		
	    
		try {
			boolean flag = validate(currentReading, previousReading, type);
			float bill=0.0f;
			float ans=0.0f;
			if(flag) {
				if(type.equals("Domestic")) {
					float slabs[]= {2.3f,4.2f, 5.5f};
					Domestic c=new Domestic(currentReading, previousReading, slabs);
					ans=c.computeBill();
				}
				if(type.equals("Commercial")) {
					float slabs[]= {5.2f,6.8f,8.3f};
					Commercial c=new Commercial(currentReading, previousReading, slabs);
					ans=c.computeBill();
					if(ans>=10000) {
			            bill=(float) (ans*0.09);
			          }
			          if(ans>=5000) {
			            bill=(float) (ans*0.06);
			          }
			          if(ans<5000) {
			            bill=(float) (ans*0.02);
			          }
					ans=ans+bill;
				}
			}
				return ans; 
		}
		catch (InvalidReadingException e) {
			return (float) -1.0;
		} 
		catch (InvalidConnectionException e) {
			return (float) -2.0;
		}
	}
	public String generateBill(int currentReading, int previousReading, String type) {
		float fiAns=calculateBillAmt(currentReading, previousReading, type);
		if(fiAns==-1.0) {
			return "Incorrect Reading";
		}
		else if(fiAns==-2.0) {
			return "Invalid ConnectionType";
		}
		else {
			return "Amount to be paid:"+fiAns;
		}
	}
}
