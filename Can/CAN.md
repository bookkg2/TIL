## CAN 통신

- can 하나로는 IoT 데이터를 받아서 동작을 할 수 가 없다. 

- RT : 접지를 나타낸다. 

  > 접지란 ? 접지는 전기회로 또는 전기 장비의 한 부분을 도체를 이용하여 땅(ground)에 연결하는 것을 뜻한다.

- 실제로 IoT와 자동차랑 연결할 때는 시리얼 포트로 통신한다. 
- Can은 두개의 드라이버가 설치 된다. (1. USB 드라이버, 2. 시리얼 포트)
- Can 프로토콜은 명령부/데이터 부로 나눠서 정한다. (무엇을 할지는 각기 다르게 정한다.)
  - Hex 가 명령부 (Hex 는 8진수로 받아서 -> 10진수 -> 2진수로)
  - Bit 가 데이터부

## CAN 프로그래밍

- can 통신을 위한 RXTX 라이브러리를 넣어야한다.

- 그리고 Serial 포트와 연결하기 위한 dll 파일도 넣어주여야 한다.

-    Eclipse를 실행해 테스트용 소스코드를 확인
     -> RXTXcomm.jar를 프로젝트 build path에 추가

     실행시 하나의 dll이 필요한데 
     제공된 rxtxSerial.dll 파일을 Java library path에
     등록해야 한다. VM 인자로 -Djava.library.path에
     해당 파일의 경로를 넣어주면 된다. 혹은 
     파일을 <JAVA_HOME>/jre/bin에 복사해도 된다.

- COM 포트에는 serial(Data를 주고 받기 위한) 과 페러럴(복사기)이 있다.

- 애플리케이션은 Serial과 통신 하여서 Can을 모른다. Serial이 Can이랑 통신한다. 

- 애플리케이션에서 Serial 한테 데이터를 보낼 때는 시작과 끝을 주고 보낸다.( 왜냐하면 Serial은 막무가내로 Can 한테 보내기 때문에 !!)

- Serial은 애플리케이션과 계속해서 Stream이 연결되어 있는게 아니다 !  데이터가 들어올 때 마다 물어 본다. 그래서  를 사용해서 데이터가 들어 왔음을 알려준다. 

- 데이터 구조 ) U28 보내겠다. 뒤에 문자 두개는 CheckSum 데이터가 맞는지 아닌지 확인!!  

  - ex) U2800000001000000000000000141
  - HEAD : U28 은 데이터를 보내겠 다.
  - HaX : 00000001는 아이디
  - Data : 0000000000000001 데이터
  - CheakSum : 41



###### 자바  코드 이클립스 

```jade
package can;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialTest implements SerialPortEventListener {
	private BufferedInputStream bin;
	private InputStream in;
	private OutputStream out;// 보낼때는 상대가 자바가 아닐 수 있으니 out은 buffer 없이 보낸다.
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;

	public SerialTest() {

	}

	public SerialTest(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);// 살아있는지 검증
		System.out.println("Connect Com Port!");// 정상이면
		try {
			connectSerial();// 연결해라
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start();//Can버스에 들어간다고 알리기
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}
	}
	private class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			this.data = ":G11A9\r";//can 버스에 들어갈게 !! 참가의사 보내기
		}

		public SerialWriter(String serialData) {
			// W28 00000000 000000000000 -> 들어온 메세지, W28은 보내겠다.
			// :W28 00000000 00000000000000 53 \r ->보낼때 메세지 (:시작 \r은 끝났다.)
			String sdata = sendDataFormat(serialData);
			System.out.println(sdata);
			this.data = sdata;
		}

		public String sendDataFormat(String serialData) {//보낼 때 데이터 구조 잡는 법 ! -> :W28 00000000 000000000000 53 형식으로 만들기 위해
			serialData = serialData.toUpperCase();
			char c[] = serialData.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}
			cdata = (cdata & 0xFF);
			String returnData = ":";
			returnData += serialData + Integer.toHexString(cdata).toUpperCase();//Integer.toHexString(cdata).toUpperCase() : Cheksum 형식을 지정(8진수로)
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

		if (portIdentifier.isCurrentlyOwned()) {//만약 다른사람이 쓰고 있다면. (COM 포트는 한명만 사용 가능)
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 5000);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // 통신속도
						SerialPort.DATABITS_8, // 데이터 비트
						SerialPort.STOPBITS_1, // stop 비트
						SerialPort.PARITY_NONE); // 패리티, 전송할 포트를 검증하겠다.
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
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
		try {
			SerialTest st = new SerialTest("COM6");
			//st.sendData("W28000000010000000000000001");
		} catch (NoSuchPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public void serialEvent(SerialPortEvent event) {//데이터가 들어오면 Event가 알려주고 함수가 동작한다. 
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
			byte[] readBuffer = new byte[128];//128byte

			try {

				while (bin.available() > 0) {
					int numBytes = bin.read(readBuffer);//Serial 에서
				}

				String ss = new String(readBuffer);//데이터 받기
				boolean result = checkSerialData(ss); // checksum 검증 단계 
				System.out.println("Result : " + result);
				System.out.println("Receive Low Data:" + ss + "||");

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}
	public boolean checkSerialData(String data) {//Checksum 체크 
		boolean check = false;
		// :U2800000050000000000000002046
		String checkData = data.substring(4, 28);
		String checkSum = data.substring(28, 30);
		
		char c[] = checkData.toCharArray();
		int cdata = 0;
		for (char cc : c) {
			cdata += cc;
		}
		cdata = (cdata & 0xFF);
		String serialCheckSum = Integer.toHexString(cdata).toUpperCase();
		if (serialCheckSum.trim().equals(checkSum)) {//checksum 비교
			check = true;
		}
		return check;
	}


}

```
