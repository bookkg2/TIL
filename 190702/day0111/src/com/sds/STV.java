package com.sds;

public class STV implements TV{//pojo(�Ϲ� ���� �ڹ� Ŭ����)
	
	private int size;
	private Speaker speaker; //agreegation ����
	
	public STV() {
		System.out.println("STV Construct");
	}
	
	public STV(int size) {
		this.size = size;
	}
	
	
	public STV(Speaker speaker) {
		
		this.speaker = speaker;
	}

	public STV(int size, Speaker speaker) {
		
		this.size = size;
		this.speaker = speaker;
	}

	public void up() {//up�� ������ speaker ��
		speaker.up();
	}
	public void turnOn() {
		System.out.println("STV On");
	}
	public void turnOff() {
		System.out.println("STV Off");
	}

	@Override
	public String toString() {
		return "STV [size=" + size + "]";
	}
	
}