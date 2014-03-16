import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

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
	
	public String fixHex(String in) {
		String out = in;
		out = out.toUpperCase();
		out = out.replaceAll("[[^0-9A-F]]","");

		if(out.isEmpty()) { out = "00";}
		if(out.length() < 2) { out = "0"+out;}
		return out;
	}
	
	public void validete() {
		inModeStop.setText(fixHex(inModeStop.getText()));
		inModeStart.setText(fixHex(inModeStart.getText()));
		inModeA.setText(fixHex(inModeA.getText()));
		inModeB.setText(fixHex(inModeB.getText()));
		inModeC.setText(fixHex(inModeC.getText()));
		inModeD.setText(fixHex(inModeD.getText()));
		inModeE.setText(fixHex(inModeE.getText()));
		inModeF.setText(fixHex(inModeF.getText()));

		inAddrStop.setText(fixHex(inAddrStop.getText()));
		inAddrStart.setText(fixHex(inAddrStart.getText()));
		inAddrA.setText(fixHex(inAddrA.getText()));
		inAddrB.setText(fixHex(inAddrB.getText()));
		inAddrC.setText(fixHex(inAddrC.getText()));
		inAddrD.setText(fixHex(inAddrD.getText()));
		inAddrE.setText(fixHex(inAddrE.getText()));
		inAddrF.setText(fixHex(inAddrF.getText()));

		inCmdStart.setText(fixHex(inCmdStart.getText()));
		inCmdStop.setText(fixHex(inCmdStop.getText()));
		inCmdA.setText(fixHex(inCmdA.getText()));
		inCmdB.setText(fixHex(inCmdB.getText()));
		inCmdC.setText(fixHex(inCmdC.getText()));
		inCmdD.setText(fixHex(inCmdD.getText()));
		inCmdE.setText(fixHex(inCmdE.getText()));
		inCmdF.setText(fixHex(inCmdF.getText()));


		if(Integer.parseInt(inModeStop.getText(), 16) > 7) {inModeStop.setText(fixHex("7"));}
		if(Integer.parseInt(inModeStart.getText(), 16) > 7) {inModeStart.setText(fixHex("7"));}
		if(Integer.parseInt(inModeA.getText(), 16) > 7) {inModeA.setText(fixHex("7"));}
		if(Integer.parseInt(inModeB.getText(), 16) > 7) {inModeB.setText(fixHex("7"));}
		if(Integer.parseInt(inModeC.getText(), 16) > 7) {inModeC.setText(fixHex("7"));}
		if(Integer.parseInt(inModeD.getText(), 16) > 7) {inModeD.setText(fixHex("7"));}
		if(Integer.parseInt(inModeE.getText(), 16) > 7) {inModeE.setText(fixHex("7"));}
		if(Integer.parseInt(inModeF.getText(), 16) > 7) {inModeF.setText(fixHex("7"));}

		if(Integer.parseInt(inAddrStop.getText(), 16) > 31) {inAddrStop.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrStart.getText(), 16) > 31) {inAddrStart.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrA.getText(), 16) > 31) {inAddrA.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrB.getText(), 16) > 31) {inAddrB.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrC.getText(), 16) > 31) {inAddrC.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrD.getText(), 16) > 31) {inAddrD.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrE.getText(), 16) > 31) {inAddrE.setText(fixHex("1F"));}
		if(Integer.parseInt(inAddrF.getText(), 16) > 31) {inAddrF.setText(fixHex("1F"));}

		if(Integer.parseInt(inCmdStart.getText(), 16) > 63) {inCmdStart.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdStop.getText(), 16) > 63) {inCmdStop.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdA.getText(), 16) > 63) {inCmdA.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdB.getText(), 16) > 63) {inCmdB.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdC.getText(), 16) > 63) {inCmdC.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdD.getText(), 16) > 63) {inCmdD.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdE.getText(), 16) > 63) {inCmdE.setText(fixHex("3F"));}
		if(Integer.parseInt(inCmdF.getText(), 16) > 63) {inCmdF.setText(fixHex("3F"));}
	}
	
	
	 public void focusLost(FocusEvent e) {
		validete();
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
	
	public void RC5_set_button(int remote, int btn, int type, int mode) {
		try {
			serialPort.writeByte((byte) 0xBB); // CMD
			serialPort.writeByte((byte) type); // Type - Write Mode
			serialPort.writeByte((byte) remote); // Remote Mode
			serialPort.writeByte((byte) btn); // Button
			serialPort.writeByte((byte) mode);

		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void RC5_flush_data() {
		try {
			serialPort.writeByte((byte) 0xBB); // CMD
			serialPort.writeByte((byte) 0x04); // CMD
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void RC5_Write() {
		RC5_set_button(0, 0, 1, Integer.parseInt(inModeStart.getText(), 16));
		RC5_set_button(0, 1, 1, Integer.parseInt(inModeStop.getText(), 16));
		RC5_set_button(0, 2, 1, Integer.parseInt(inModeA.getText(), 16));
		RC5_set_button(0, 3, 1, Integer.parseInt(inModeB.getText(), 16));
		RC5_set_button(0, 4, 1, Integer.parseInt(inModeC.getText(), 16));
		RC5_set_button(0, 5, 1, Integer.parseInt(inModeD.getText(), 16));
		RC5_set_button(0, 6, 1, Integer.parseInt(inModeE.getText(), 16));
		RC5_set_button(0, 7, 1, Integer.parseInt(inModeF.getText(), 16));
		
		RC5_set_button(0, 0, 2, Integer.parseInt(inAddrStart.getText(), 16));
		RC5_set_button(0, 1, 2, Integer.parseInt(inAddrStop.getText(), 16));
		RC5_set_button(0, 2, 2, Integer.parseInt(inAddrA.getText(), 16));
		RC5_set_button(0, 3, 2, Integer.parseInt(inAddrB.getText(), 16));
		RC5_set_button(0, 4, 2, Integer.parseInt(inAddrC.getText(), 16));
		RC5_set_button(0, 5, 2, Integer.parseInt(inAddrD.getText(), 16));
		RC5_set_button(0, 6, 2, Integer.parseInt(inAddrE.getText(), 16));
		RC5_set_button(0, 7, 2, Integer.parseInt(inAddrF.getText(), 16));
	
		RC5_set_button(0, 0, 3, Integer.parseInt(inCmdStart.getText(), 16));
		RC5_set_button(0, 1, 3, Integer.parseInt(inCmdStop.getText(), 16));
		RC5_set_button(0, 2, 3, Integer.parseInt(inCmdA.getText(), 16));
		RC5_set_button(0, 3, 3, Integer.parseInt(inCmdB.getText(), 16));
		RC5_set_button(0, 4, 3, Integer.parseInt(inCmdC.getText(), 16));
		RC5_set_button(0, 5, 3, Integer.parseInt(inCmdD.getText(), 16));
		RC5_set_button(0, 6, 3, Integer.parseInt(inCmdE.getText(), 16));
		RC5_set_button(0, 7, 3, Integer.parseInt(inCmdF.getText(), 16));
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
		validete();
	}
	
	public void sleep(int ms) {
		try {
		    Thread.sleep(ms);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("HH");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		inModeStart = new JFormattedTextField(formatter);
		inModeStop = new JFormattedTextField(formatter);
		inModeA = new JFormattedTextField(formatter);
		inModeB = new JFormattedTextField(formatter);
		inModeC = new JFormattedTextField(formatter);
		inModeD = new JFormattedTextField(formatter);
		inModeE = new JFormattedTextField(formatter);
		inModeF = new JFormattedTextField(formatter);
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
		btnRead.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RC5_Read();				
			}
			
		});
		
		btnWrite.setBounds(160, 299, 73, 23);
		frame.getContentPane().add(btnWrite);
		btnWrite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RC5_Write();
				RC5_flush_data();
			}
		});
		
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
