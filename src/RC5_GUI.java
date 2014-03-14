import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;


public class RC5_GUI extends JFrame {

	private JFrame frame;
	public SerialPort serialPort;
	public boolean connected = false;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
		
		final JButton btnConnect = new JButton("Connect");
		JButton btnRead = new JButton("Read");
		JButton btnWrite = new JButton("Write");
		final JComboBox serialList = new JComboBox();
		JSpinner inModeStart = new JSpinner();
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
		JSpinner inModeStop = new JSpinner();
		JSpinner inModeA = new JSpinner();
		JSpinner inModeB = new JSpinner();
		JSpinner inModeC = new JSpinner();
		JSpinner inModeD = new JSpinner();
		JSpinner inModeE = new JSpinner();
		JSpinner inModeF = new JSpinner();
		JSpinner inAddrA = new JSpinner();
		JSpinner inAddrStop = new JSpinner();
		JSpinner inAddrStart = new JSpinner();
		JSpinner inAddrB = new JSpinner();
		JSpinner inAddrC = new JSpinner();
		JSpinner inAddrD = new JSpinner();
		JSpinner inAddrE = new JSpinner();
		JSpinner inAddrF = new JSpinner();
		JSpinner inCmdStart = new JSpinner();
		JSpinner inCmdStop = new JSpinner();
		JSpinner inCmdA = new JSpinner();
		JSpinner inCmB = new JSpinner();
		JSpinner inCmdC = new JSpinner();
		JSpinner inCmdD = new JSpinner();
		JSpinner inCmdE = new JSpinner();
		JSpinner inCmdF = new JSpinner();
		JLabel jImage = new JLabel(new ImageIcon(wPic));
		JSeparator separator = new JSeparator();
		JLabel lblBattery = new JLabel("Battery:");
		JLabel lbVoltage = new JLabel("0.00V");
		
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
				}
				else {
					serialPort = new SerialPort(String.valueOf(serialList.getSelectedItem()));
			        try {
			            serialPort.openPort();//Open serial port
			            serialPort.setParams(SerialPort.BAUDRATE_9600, 
			                                 SerialPort.DATABITS_8,
			                                 SerialPort.STOPBITS_1,
			                                 SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
			            serialPort.writeBytes("This is a test string".getBytes());//Write data to port
			            btnConnect.setLabel("Disconnect");
			            btnConnect.setBackground(new Color(50,230,50));
			            connected = true;
			        }
			        catch (SerialPortException ex) {
			            System.out.println(ex);
			        }
				}
			}
        });
		
		btnRead.setBounds(57, 299, 73, 23);
		frame.getContentPane().add(btnRead);
		
		btnWrite.setBounds(160, 299, 73, 23);
		frame.getContentPane().add(btnWrite);
		
		serialList.setBounds(541, 12, 73, 20);
		frame.getContentPane().add(serialList);
		
		inModeStart.setModel(new SpinnerNumberModel(0, 0, 7, 1));
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
		inModeStop.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeStop);
		
		inModeA.setBounds(57, 113, 42, 20);
		inModeA.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeA);
		
		inModeB.setBounds(57, 144, 42, 20);
		inModeB.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeB);
		
		inModeC.setBounds(57, 175, 42, 20);
		inModeC.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeC);
		
		inModeD.setBounds(57, 206, 42, 20);
		inModeD.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeD);
		
		inModeE.setBounds(57, 237, 42, 20);
		inModeE.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeE);
		
		inModeF.setBounds(57, 268, 42, 20);
		inModeF.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(inModeF);
		
		inAddrStop.setBounds(109, 71, 57, 20);
		inAddrStop.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(inAddrStop);
		
		inAddrStart.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		inAddrStart.setBounds(109, 40, 57, 20);
		frame.getContentPane().add(inAddrStart);
		
		inAddrA.setBounds(109, 113, 57, 20);
		inAddrA.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(inAddrA);
		
		inAddrB.setBounds(109, 144, 57, 20);
		inAddrB.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(inAddrB);
		
		inAddrC.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		inAddrC.setBounds(109, 175, 57, 20);
		frame.getContentPane().add(inAddrC);
		
		inAddrD.setBounds(109, 206, 57, 20);
		inAddrD.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(inAddrD);
		
		inAddrE.setBounds(109, 237, 57, 20);
		inAddrE.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(inAddrE);
		
		inAddrF.setBounds(109, 270, 57, 20);
		inAddrF.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(inAddrF);
		
		inCmdStart.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		inCmdStart.setBounds(176, 40, 57, 20);
		frame.getContentPane().add(inCmdStart);
		
		inCmdStop.setBounds(176, 71, 57, 20);
		inCmdStop.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(inCmdStop);
		
		inCmdA.setBounds(176, 113, 57, 20);
		inCmdA.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(inCmdA);
		
		inCmB.setBounds(176, 144, 57, 20);
		inCmB.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(inCmB);
		
		inCmdC.setBounds(176, 175, 57, 20);
		inCmdC.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(inCmdC);
		
		inCmdD.setBounds(176, 206, 57, 20);
		inCmdD.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(inCmdD);
		
		inCmdE.setBounds(176, 237, 57, 20);
		inCmdE.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(inCmdE);
		
		inCmdF.setBounds(176, 268, 57, 20);
		inCmdF.setModel(new SpinnerNumberModel(0, 0, 127, 1));
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
        
        
	}
}
