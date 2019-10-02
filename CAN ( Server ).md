- Can 통신 Server 측

```java
package server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialTest implements SerialPortEventListener {
	public static String ss;
	public static DataOutputStream bos= null;
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private BufferedInputStream bin;
	private InputStream in;
	private OutputStream out;
	// 들어올 때는 버퍼드 써도 되는데
	// 나갈 떄 OutputStream을 쓰는 이유는
	// 상대는 자바 환경이 아닐 수도 있어서임.
	Socket socket;
	boolean rflag = true;
	
	static SerialTest st;
	
	public SerialTest() {
	}
	public SerialTest(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("Connect ComPort!");
		try {
			connectSerial();
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start();
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}

	}
	public SerialTest(String ip, int port, String portName) throws Exception {
		
		setPort(portName);
		setSocket(ip, port);
	}
	
	public void setSocket(String ip, int port) throws Exception {
		boolean flag = true;
		while (flag) {
			try {
				socket = new Socket(ip, port);
				if (socket != null && socket.isConnected()) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Re-Try");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		new Receiver(socket).start();
	}
	
	public void setPort(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("Connect ComPort!");
		try {
			connectSerial();
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start();
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) throws IOException {
		Sender sender = null;

		sender = new Sender(socket);
		
		sender.setMsg(msg);
		sender.start();
	}
	
	class Sender extends Thread{
		
		OutputStream out;
		DataOutputStream dout;
		String msg;
		String nick;
		
		
		public Sender(Socket socket) throws IOException {
			out = socket.getOutputStream();
			dout = new DataOutputStream(out);
		}
		
		public void setMsg(String msg) {
			this.msg = msg;
			
		}
		
		public void run() {
			if(dout != null) {
				try {
					System.out.println(msg);
					dout.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class Receiver extends Thread{
		Socket socket;
		InputStream in;
		DataInputStream din;
		
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			din = new DataInputStream(bin);//데이터 받기 위한 Stream
		}
		
		public void run() {
			try {
				while(rflag) {
					String str = 
							din.readUTF();
					System.out.println(str);
				}
			}catch(Exception e) {
				
			}
		}
	}

	private class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			// 나 참가할게 메세지임.
			// 이걸 안 해주면 안 됨.
			this.data = ":G11A9\r";
		}

		public SerialWriter(String serialData) {
			/*
			 * W28: 데이터를 쏘겠다는 뜻 W28 00000000 000000000000 id data :W28 00000000 000000000000
			 * 53 \r
			 */
			String sdata = sendDataFormat(serialData);
			System.out.println(sdata);
			this.data = sdata;
		}

		public String sendDataFormat(String serialData) {
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}

			// 비트연산
			System.out.println("before 0xff : " + cdata);
			cdata = (cdata & 0xFF);
			System.out.println("after 0xff : " + cdata);

			String returnData = ":";
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {
				byte[] inputData = data.getBytes();
				out.write(inputData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void connectSerial() throws Exception {

		// 다른 아이가 쓰고 있다.

		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 100);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // 통신속도(Serial 속도) 서로 달라도 상관 없음.
						SerialPort.DATABITS_8, // 데이터 비트
						SerialPort.STOPBITS_1, // stop 비트
						SerialPort.PARITY_NONE); // 패리티
				// 전송하는 데이터를 검증하겠다는 뜻임.
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				// 데이터를 Serial로 쏠 수 있음.
				out = serialPort.getOutputStream();
				
				
				
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	public void sendData(String data) {
		SerialWriter sw = new SerialWriter(data);
		new Thread(sw).start();
	}

	public static void main(String[] args) {
			// client.start();
			try {
				st = new SerialTest("70.12.227.219",7777,"COM4");
				//st.sendData("W28000000010000000000000002");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128];
			
			try {

				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer);
				}

				ss = new String(readBuffer);
				System.out.println("Receive Low Data:" + ss + "||");
				
				if (ss.charAt(1) == 'U') {
					boolean result = checkSerialData(ss);
					System.out.println("Result : " + result);
					System.out.println("Receive Low Data:" + ss + "||");
					st.sendMsg(ss);
				}
				
				else if (ss.charAt(1) == 'W') {	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	public boolean checkSerialData(String data) {
		boolean check = false;
		// :U2800000050000000000000002046
		String checkData = data.substring(1, 28);
		String checkSum = data.substring(28, 30);

		char c[] = checkData.toCharArray();
		int cdata = 0;
		for (char cc : c) {
			cdata += cc;
		}
		cdata = (cdata & 0xFF);
		String serialCheckSum = Integer.toHexString(cdata).toUpperCase();
		if (serialCheckSum.trim().equals(checkSum)) {
			check = true;
		}
		return check;
	}

}

```

