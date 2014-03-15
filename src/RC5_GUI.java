import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import jssc.SerialPort;
import jssc.SerialPortException;

import jssc.SerialPortList;


public class RC5_GUI extends JFrame implements FocusListener {
	
	 public void focusLost(FocusEvent e) {
		 
		 if(inAddrA.getText().length() < 2) {inAddrA.setText("0"+inAddrA.getText());}
		 if(inAddrStop.getText().length() < 2) {inAddrStop.setText("0"+inAddrStop.getText());}
		 if(inAddrStart.getText().length() < 2) {inAddrStart.setText("0"+inAddrStart.getText());}
		 if(inAddrB.getText().length() < 2) {inAddrB.setText("0"+inAddrB.getText());}
		 if(inAddrC.getText().length() < 2) {inAddrC.setText("0"+inAddrC.getText());}
		 if(inAddrD.getText().length() < 2) {inAddrD.setText("0"+inAddrD.getText());}
		 if(inAddrE.getText().length() < 2) {inAddrE.setText("0"+inAddrE.getText());}
		 if(inAddrF.getText().length() < 2) {inAddrF.setText("0"+inAddrF.getText());}
		 if(inCmdStart.getText().length() < 2) {inCmdStart.setText("0"+inCmdStart.getText());}
		 if(inCmdStop.getText().length() < 2) {inCmdStop.setText("0"+inCmdStop.getText());}
		 if(inCmdA.getText().length() < 2) {inCmdA.setText("0"+inCmdA.getText());}
		 if(inCmdB.getText().length() < 2) {inCmdB.setText("0"+inCmdB.getText());}
		 if(inCmdC.getText().length() < 2) {inCmdC.setText("0"+inCmdC.getText());}
		 if(inCmdD.getText().length() < 2) {inCmdD.setText("0"+inCmdD.getText());}
		 if(inCmdE.getText().length() < 2) {inCmdE.setText("0"+inCmdE.getText());}
		 if(inCmdF.getText().length() < 2) {inCmdF.setText("0"+inCmdF.getText());}

		 
		 if(inModeStart.getText().isEmpty()) {inModeStart.setText("0");}
		 if(inModeStop.getText().isEmpty()) {inModeStop.setText("0");}
		 if(inModeA.getText().isEmpty()) {inModeA.setText("0");}
		 if(inModeB.getText().isEmpty()) {inModeB.setText("0");}
		 if(inModeC.getText().isEmpty()) {inModeC.setText("0");}
		 if(inModeD.getText().isEmpty()) {inModeD.setText("0");}
		 if(inModeE.getText().isEmpty()) {inModeE.setText("0");}
		 if(inModeF.getText().isEmpty()) {inModeF.setText("0");}
		 
		 if(inAddrA.getText().isEmpty()) {inAddrA.setText("00");}
		 if(inAddrStop.getText().isEmpty()) {inAddrStop.setText("00");}
		 if(inAddrStart.getText().isEmpty()) {inAddrStart.setText("00");}
		 if(inAddrB.getText().isEmpty()) {inAddrB.setText("00");}
		 if(inAddrC.getText().isEmpty()) {inAddrC.setText("00");}
		 if(inAddrD.getText().isEmpty()) {inAddrD.setText("00");}
		 if(inAddrE.getText().isEmpty()) {inAddrE.setText("00");}
		 if(inAddrF.getText().isEmpty()) {inAddrF.setText("00");}
		 if(inCmdStart.getText().isEmpty()) {inCmdStart.setText("00");}
		 if(inCmdStop.getText().isEmpty()) {inCmdStop.setText("00");}
		 if(inCmdA.getText().isEmpty()) {inCmdA.setText("00");}
		 if(inCmdB.getText().isEmpty()) {inCmdB.setText("00");}
		 if(inCmdC.getText().isEmpty()) {inCmdC.setText("00");}
		 if(inCmdD.getText().isEmpty()) {inCmdD.setText("00");}
		 if(inCmdE.getText().isEmpty()) {inCmdE.setText("00");}
		 if(inCmdF.getText().isEmpty()) {inCmdF.setText("00");}

		 if(Integer.decode("0x"+inModeStart.getText()) > 7) {inModeStart.setText("7");}
		 if(Integer.decode("0x"+inModeStop.getText()) > 7) {inModeStop.setText("7");}
		 if(Integer.decode("0x"+inModeA.getText()) > 7) {inModeA.setText("7");}
		 if(Integer.decode("0x"+inModeB.getText()) > 7) {inModeB.setText("7");}
		 if(Integer.decode("0x"+inModeC.getText()) > 7) {inModeC.setText("7");}
		 if(Integer.decode("0x"+inModeD.getText()) > 7) {inModeD.setText("7");}
		 if(Integer.decode("0x"+inModeE.getText()) > 7) {inModeE.setText("7");}
		 if(Integer.decode("0x"+inModeF.getText()) > 7) {inModeF.setText("7");}
		 if(Integer.decode("0x"+inAddrA.getText()) > 31) {inAddrA.setText("1F");}
		 if(Integer.decode("0x"+inAddrStop.getText()) > 31) {inAddrStop.setText("1F");}
		 if(Integer.decode("0x"+inAddrStart.getText()) > 31) {inAddrStart.setText("1F");}
		 if(Integer.decode("0x"+inAddrB.getText()) > 31) {inAddrB.setText("1F");}
		 if(Integer.decode("0x"+inAddrC.getText()) > 31) {inAddrC.setText("1F");}
		 if(Integer.decode("0x"+inAddrD.getText()) > 31) {inAddrD.setText("1F");}
		 if(Integer.decode("0x"+inAddrE.getText()) > 31) {inAddrE.setText("1F");}
		 if(Integer.decode("0x"+inAddrF.getText()) > 31) {inAddrF.setText("1F");}
		 if(Integer.decode("0x"+inCmdStart.getText()) > 63) {inCmdStart.setText("3F");}
		 if(Integer.decode("0x"+inCmdStop.getText()) > 63) {inCmdStop.setText("3F");}
		 if(Integer.decode("0x"+inCmdA.getText()) > 63) {inCmdA.setText("3F");}
		 if(Integer.decode("0x"+inCmdB.getText()) > 63) {inCmdB.setText("3F");}
		 if(Integer.decode("0x"+inCmdC.getText()) > 63) {inCmdC.setText("3F");}
		 if(Integer.decode("0x"+inCmdD.getText()) > 63) {inCmdD.setText("3F");}
		 if(Integer.decode("0x"+inCmdE.getText()) > 63) {inCmdE.setText("3F");}
		 if(Integer.decode("0x"+inCmdF.getText()) > 63) {inCmdF.setText("3F");}
	 }

	private JFrame frame;
	public SerialPort serialPort;
	public boolean connected = false;
	final JButton btnConnect = new JButton("Connect");
	JButton btnRead = new JButton("Read");
	JButton btnWrite = new JButton("Write");
	final JComboBox serialList = new JComboBox();
	JTextField inModeStart = new JTextField();
	JLabel lblStart = new JLabel("Start");
	JLabel lblStop = new JLabel("Stop");
	JLabel lblA = new JLabel("A");
	JLabel lblB = new JLabel("B");
	JLabel lblC = new JLabel("C");
	JLabel lblD = new JLabel("D");
	JLabel lblE = new JLabel("E");
	JLabel lblF = new JLabel("F");
	JLabel lblMode = new JLabel("Mode");
	JLabel lblAddress = new JLabel("Address");
	JFormattedTextField inModeStop;
	JFormattedTextField inModeA;
	JFormattedTextField inModeB;
	JFormattedTextField inModeC;
	JFormattedTextField inModeD;
	JFormattedTextField inModeE;
	JFormattedTextField inModeF;
	JFormattedTextField inAddrA;
	JFormattedTextField inAddrStop;
	JFormattedTextField inAddrStart;
	JFormattedTextField inAddrB;
	JFormattedTextField inAddrC;
	JFormattedTextField inAddrD;
	JFormattedTextField inAddrE;
	JFormattedTextField inAddrF;
	JFormattedTextField inCmdStart;
	JFormattedTextField inCmdStop;
	JFormattedTextField inCmdA;
	JFormattedTextField inCmdB;
	JFormattedTextField inCmdC;
	JFormattedTextField inCmdD;
	JFormattedTextField inCmdE;
	JFormattedTextField inCmdF;
	
	JLabel jImage;
	JSeparator separator = new JSeparator();
	JLabel lblBattery = new JLabel("Battery:");
	JLabel lbVoltage = new JLabel("0.00V");
	
	MaskFormatter formatter = null;
	MaskFormatter formatterShort = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RC5_GUI window = new RC5_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RC5_GUI() {
		initialize();
	}
	
	public String removeLast(String str) {
		  if (str.length() > 0 && str.charAt(str.length()-1)=='x') {
		    str = str.substring(0, str.length()-1);
		  }
		  return str;
		}
	
	public void RC5_Read() {
		try {
			serialPort.writeByte((byte) 0xAA);
			serialPort.writeByte((byte) 0x02);
			// Wait for data			
			byte buffer[] = serialPort.readBytes(35);
			
			for(int i=0;i<16;i+=2) {
				String mode = Integer.toHexString((buffer[i] & 0b11100000) >> 5).toUpperCase();
				String address = Integer.toHexString(buffer[i] & 0b00011111).toUpperCase();
				String command = Integer.toHexString(buffer[i+1] & 0x3F).toUpperCase();
				
				switch (i) {
					case 0: inModeStart.setText(mode); inAddrStart.setText(address); inCmdStart.setText(command); break;
					case 2: inModeStop.setText(mode); inAddrStop.setText(address); inCmdStop.setText(command); break;
					case 4: inModeA.setText(mode); inAddrA.setText(address); inCmdA.setText(command); break;
					case 6: inModeB.setText(mode); inAddrB.setText(address); inCmdB.setText(command); break;
					case 8: inModeC.setText(mode); inAddrC.setText(address); inCmdC.setText(command); break;
					case 10: inModeD.setText(mode); inAddrD.setText(address); inCmdD.setText(command); break;
					case 12: inModeE.setText(mode); inAddrE.setText(address); inCmdE.setText(command); break;
					case 14: inModeF.setText(mode); inAddrF.setText(address); inCmdF.setText(command); break;
				}
			}
			
			
			//int axx = byte[32].intValue();
			
			String voltage = "";
			voltage += buffer[32] + "." + buffer[33] + buffer[34] + "V";
			
			lbVoltage.setText(voltage);
		}
		catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			formatter = new MaskFormatter("HH");
			formatterShort = new MaskFormatter("H");

		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		inModeStart = new JFormattedTextField(formatterShort);
		inModeStop = new JFormattedTextField(formatterShort);
		inModeA = new JFormattedTextField(formatterShort);
		inModeB = new JFormattedTextField(formatterShort);
		inModeC = new JFormattedTextField(formatterShort);
		inModeD = new JFormattedTextField(formatterShort);
		inModeE = new JFormattedTextField(formatterShort);
		inModeF = new JFormattedTextField(formatterShort);
		inAddrA = new JFormattedTextField(formatter);
		inAddrStop = new JFormattedTextField(formatter);
		inAddrStart = new JFormattedTextField(formatter);
		inAddrB = new JFormattedTextField(formatter);
		inAddrC = new JFormattedTextField(formatter);
		inAddrD = new JFormattedTextField(formatter);
		inAddrE = new JFormattedTextField(formatter);
		inAddrF = new JFormattedTextField(formatter);
		inCmdStart = new JFormattedTextField(formatter);
		inCmdStop = new JFormattedTextField(formatter);
		inCmdA = new JFormattedTextField(formatter);
		inCmdB = new JFormattedTextField(formatter);
		inCmdC = new JFormattedTextField(formatter);
		inCmdD = new JFormattedTextField(formatter);
		inCmdE = new JFormattedTextField(formatter);
		inCmdF = new JFormattedTextField(formatter);
		
		inModeStart.addFocusListener(this);
		inModeStop.addFocusListener(this);
		inModeA.addFocusListener(this);
		inModeB.addFocusListener(this);
		inModeC.addFocusListener(this);
		inModeD.addFocusListener(this);
		inModeE.addFocusListener(this);
		inModeF.addFocusListener(this);
		inAddrA.addFocusListener(this);
		inAddrStop.addFocusListener(this);
		inAddrStart.addFocusListener(this);
		inAddrB.addFocusListener(this);
		inAddrC.addFocusListener(this);
		inAddrD.addFocusListener(this);
		inAddrE.addFocusListener(this);
		inAddrF.addFocusListener(this);
		inCmdStart.addFocusListener(this);
		inCmdStop.addFocusListener(this);
		inCmdA.addFocusListener(this);
		inCmdB.addFocusListener(this);
		inCmdC.addFocusListener(this);
		inCmdD.addFocusListener(this);
		inCmdE.addFocusListener(this);
		inCmdF.addFocusListener(this);
		
		
		BufferedImage wPic = null;
		try {
			wPic = ImageIO.read(new File("rev1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame("RC5 GUI v1.0");
		frame.setBounds(100, 100, 640, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		btnConnect.setBounds(426, 11, 105, 23);
		frame.getContentPane().add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(connected) {
					try {
						serialPort.closePort();
					} catch (SerialPortException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//Close serial port
					btnConnect.setLabel("Connect");
		            btnConnect.setBackground(new Color(240,240,240));
		            connected = false;
		            disableInputs();
				}
				else {
					serialPort = new SerialPort(String.valueOf(serialList.getSelectedItem()));
			        try {
			            serialPort.openPort();//Open serial port
			            serialPort.setParams(SerialPort.BAUDRATE_9600, 
			                                 SerialPort.DATABITS_8,
			                                 SerialPort.STOPBITS_1,
			                                 SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
			            btnConnect.setLabel("Disconnect");
			            btnConnect.setBackground(new Color(50,230,50));
			            connected = true;
			            enableInputs();
			            RC5_Read();
			        }
			        catch (SerialPortException ex) {
			            System.out.println(ex);
			        }
				}
			}
        });
		
		jImage = new JLabel(new ImageIcon(wPic));
		
		btnRead.setBounds(57, 299, 73, 23);
		frame.getContentPane().add(btnRead);
		
		btnWrite.setBounds(160, 299, 73, 23);
		frame.getContentPane().add(btnWrite);
		
		serialList.setBounds(541, 12, 73, 20);
		frame.getContentPane().add(serialList);
		
		inModeStart.setBounds(57, 40, 42, 20);
		frame.getContentPane().add(inModeStart);
		
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		lblStart.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblStart.setBounds(10, 43, 37, 14);
		frame.getContentPane().add(lblStart);
		
		lblStop.setHorizontalAlignment(SwingConstants.CENTER);
		lblStop.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblStop.setBounds(10, 74, 37, 14);
		frame.getContentPane().add(lblStop);
		
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblA.setBounds(10, 116, 37, 14);
		frame.getContentPane().add(lblA);
		
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblB.setBounds(10, 147, 37, 14);
		frame.getContentPane().add(lblB);
		
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblC.setBounds(10, 178, 37, 14);
		frame.getContentPane().add(lblC);
		
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblD.setBounds(10, 209, 37, 14);
		frame.getContentPane().add(lblD);
		
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblE.setBounds(10, 240, 37, 14);
		frame.getContentPane().add(lblE);
		
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblF.setBounds(10, 271, 37, 14);
		frame.getContentPane().add(lblF);
		
		lblMode.setBounds(57, 15, 42, 14);
		frame.getContentPane().add(lblMode);
		
		lblAddress.setBounds(109, 15, 57, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCommand = new JLabel("Command");
		lblCommand.setBounds(176, 15, 73, 14);
		frame.getContentPane().add(lblCommand);
		
		
		inModeStop.setBounds(57, 71, 42, 20);
		inModeStop.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) { }

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				String text = inModeStop.getText();
				if(text.length()>2) {inModeStop.setText(removeLast(text));}
				System.out.println(inModeStop.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) { }
		});
		frame.getContentPane().add(inModeStop);
		
		inModeA.setBounds(57, 113, 42, 20);
		frame.getContentPane().add(inModeA);
		
		inModeB.setBounds(57, 144, 42, 20);
		frame.getContentPane().add(inModeB);
		
		inModeC.setBounds(57, 175, 42, 20);
		frame.getContentPane().add(inModeC);
		
		inModeD.setBounds(57, 206, 42, 20);
		frame.getContentPane().add(inModeD);
		
		inModeE.setBounds(57, 237, 42, 20);
		frame.getContentPane().add(inModeE);
		
		inModeF.setBounds(57, 268, 42, 20);
		frame.getContentPane().add(inModeF);
		
		inAddrStop.setBounds(109, 71, 57, 20);
		frame.getContentPane().add(inAddrStop);
		
		inAddrStart.setBounds(109, 40, 57, 20);
		frame.getContentPane().add(inAddrStart);
		
		inAddrA.setBounds(109, 113, 57, 20);
		frame.getContentPane().add(inAddrA);
		
		inAddrB.setBounds(109, 144, 57, 20);
		frame.getContentPane().add(inAddrB);
		
		frame.getContentPane().add(inAddrC);
		inAddrC.setBounds(109, 175, 57, 20);
		
		inAddrD.setBounds(109, 206, 57, 20);
		frame.getContentPane().add(inAddrD);
		
		inAddrE.setBounds(109, 237, 57, 20);
		frame.getContentPane().add(inAddrE);
		
		inAddrF.setBounds(109, 270, 57, 20);
		frame.getContentPane().add(inAddrF);
		
		inCmdStart.setBounds(176, 40, 57, 20);
		frame.getContentPane().add(inCmdStart);
		
		inCmdStop.setBounds(176, 71, 57, 20);
		frame.getContentPane().add(inCmdStop);
		
		inCmdA.setBounds(176, 113, 57, 20);
		frame.getContentPane().add(inCmdA);
		
		inCmdB.setBounds(176, 144, 57, 20);
		frame.getContentPane().add(inCmdB);
		
		inCmdC.setBounds(176, 175, 57, 20);
		frame.getContentPane().add(inCmdC);
		
		inCmdD.setBounds(176, 206, 57, 20);
		frame.getContentPane().add(inCmdD);
		
		inCmdE.setBounds(176, 237, 57, 20);
		frame.getContentPane().add(inCmdE);
		
		inCmdF.setBounds(176, 268, 57, 20);
		frame.getContentPane().add(inCmdF);
		
		jImage.setBounds(436, 48, 176, 310);
		frame.getContentPane().add(jImage);
		
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(412, 0, 4, 382);
		frame.getContentPane().add(separator);
		
		lblBattery.setHorizontalAlignment(SwingConstants.LEFT);
		lblBattery.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblBattery.setBounds(10, 344, 57, 14);
		frame.getContentPane().add(lblBattery);
		
		lbVoltage.setHorizontalAlignment(SwingConstants.LEFT);
		lbVoltage.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lbVoltage.setBounds(73, 344, 57, 14);
		frame.getContentPane().add(lbVoltage);
		
		String[] portNames = SerialPortList.getPortNames();
        for(int i = 0; i < portNames.length; i++){
        	serialList.addItem(portNames[i]);
        }
        
        disableInputs();
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void disableInputs() {
		inModeStart.setEnabled(false);
		inModeStop.setEnabled(false);
		inModeA.setEnabled(false);
		inModeB.setEnabled(false);
		inModeC.setEnabled(false);
		inModeD.setEnabled(false);
		inModeE.setEnabled(false);
		inModeF.setEnabled(false);
		inAddrA.setEnabled(false);
		inAddrStop.setEnabled(false);
		inAddrStart.setEnabled(false);
		inAddrB.setEnabled(false);
		inAddrC.setEnabled(false);
		inAddrD.setEnabled(false);
		inAddrE.setEnabled(false);
		inAddrF.setEnabled(false);
		inCmdStart.setEnabled(false);
		inCmdStop.setEnabled(false);
		inCmdA.setEnabled(false);
		inCmdB.setEnabled(false);
		inCmdC.setEnabled(false);
		inCmdD.setEnabled(false);
		inCmdE.setEnabled(false);
		inCmdF.setEnabled(false);	
		btnWrite.setEnabled(false);
		btnRead.setEnabled(false);	
	}
	
	public void enableInputs() {
		inModeStart.setEnabled(true);
		inModeStop.setEnabled(true);
		inModeA.setEnabled(true);
		inModeB.setEnabled(true);
		inModeC.setEnabled(true);
		inModeD.setEnabled(true);
		inModeE.setEnabled(true);
		inModeF.setEnabled(true);
		inAddrA.setEnabled(true);
		inAddrStop.setEnabled(true);
		inAddrStart.setEnabled(true);
		inAddrB.setEnabled(true);
		inAddrC.setEnabled(true);
		inAddrD.setEnabled(true);
		inAddrE.setEnabled(true);
		inAddrF.setEnabled(true);
		inCmdStart.setEnabled(true);
		inCmdStop.setEnabled(true);
		inCmdA.setEnabled(true);
		inCmdB.setEnabled(true);
		inCmdC.setEnabled(true);
		inCmdD.setEnabled(true);
		inCmdE.setEnabled(true);
		inCmdF.setEnabled(true);	
		btnWrite.setEnabled(true);
		btnRead.setEnabled(true);	
	}
}
