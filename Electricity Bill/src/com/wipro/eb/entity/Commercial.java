package com.wipro.eb.entity;

public class Commercial extends Connection{
	int currentReading;
	int previousReading;
	float slabs[];
	public Commercial(int currentReading, int previousReading,float slabs[]) {
		this.currentReading=currentReading;
		this.previousReading=previousReading;
		this.slabs=slabs;
	}
	public float computeBill() {
		float bill=0.0f;
		if(currentReading>50) {
			bill+=50*slabs[0];
			currentReading-=50;
		}
		else {
			return (float) (currentReading*slabs[0]);
		}
		if(currentReading>50) {
			bill+=50*slabs[1];
			currentReading-=50;
		}else {
			return bill+(float) (currentReading*slabs[1]);
		}
		if(currentReading>0) {
			bill+=currentReading*slabs[2];
			return bill;
		}
		return bill;
	}
}
