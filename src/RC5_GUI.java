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
	public SerialPort serrialPort;

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
		
		JButton btnConnect = new JButton("Connect");
		JButton btnRead = new JButton("Read");
		JButton btnWrite = new JButton("Write");
		final JComboBox comboBox = new JComboBox();
		JSpinner spinner = new JSpinner();
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
		JSpinner spinner_1 = new JSpinner();
		JSpinner spinner_2 = new JSpinner();
		JSpinner spinner_3 = new JSpinner();
		JSpinner spinner_4 = new JSpinner();
		JSpinner spinner_5 = new JSpinner();
		JSpinner spinner_6 = new JSpinner();
		JSpinner spinner_7 = new JSpinner();
		JSpinner spinner_10 = new JSpinner();
		JSpinner spinner_8 = new JSpinner();
		JSpinner spinner_9 = new JSpinner();
		JSpinner spinner_11 = new JSpinner();
		JSpinner spinner_12 = new JSpinner();
		JSpinner spinner_13 = new JSpinner();
		JSpinner spinner_14 = new JSpinner();
		JSpinner spinner_15 = new JSpinner();
		JSpinner spinner_16 = new JSpinner();
		JSpinner spinner_17 = new JSpinner();
		JSpinner spinner_18 = new JSpinner();
		JSpinner spinner_19 = new JSpinner();
		JSpinner spinner_20 = new JSpinner();
		JSpinner spinner_21 = new JSpinner();
		JSpinner spinner_22 = new JSpinner();
		JSpinner spinner_23 = new JSpinner();
		JLabel jImage = new JLabel(new ImageIcon(wPic));
		JSeparator separator = new JSeparator();
		JLabel lblBattery = new JLabel("Battery:");
		JLabel lblv = new JLabel("0.00V");
		
		btnConnect.setBounds(436, 11, 89, 23);
		frame.getContentPane().add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SerialPort serialPort = new SerialPort(String.valueOf(comboBox.getSelectedItem()));
		        try {
		            serialPort.openPort();//Open serial port
		            serialPort.setParams(SerialPort.BAUDRATE_9600, 
		                                 SerialPort.DATABITS_8,
		                                 SerialPort.STOPBITS_1,
		                                 SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
		            serialPort.writeBytes("This is a test string".getBytes());//Write data to port
		            serialPort.closePort();//Close serial port
		        }
		        catch (SerialPortException ex) {
		            System.out.println(ex);
		        }
			}
        });
		
		btnRead.setBounds(57, 299, 73, 23);
		frame.getContentPane().add(btnRead);
		
		btnWrite.setBounds(160, 299, 73, 23);
		frame.getContentPane().add(btnWrite);
		
		comboBox.setBounds(535, 12, 79, 20);
		frame.getContentPane().add(comboBox);
		
		spinner.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		spinner.setBounds(57, 40, 42, 20);
		frame.getContentPane().add(spinner);
		
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
		
		
		spinner_1.setBounds(57, 71, 42, 20);
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_1);
		
		spinner_2.setBounds(57, 113, 42, 20);
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_2);
		
		spinner_3.setBounds(57, 144, 42, 20);
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_3);
		
		spinner_4.setBounds(57, 175, 42, 20);
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_4);
		
		spinner_5.setBounds(57, 206, 42, 20);
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_5);
		
		spinner_6.setBounds(57, 237, 42, 20);
		spinner_6.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_6);
		
		spinner_7.setBounds(57, 268, 42, 20);
		spinner_7.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		frame.getContentPane().add(spinner_7);
		
		spinner_8.setBounds(109, 71, 57, 20);
		spinner_8.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(spinner_8);
		
		spinner_9.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinner_9.setBounds(109, 40, 57, 20);
		frame.getContentPane().add(spinner_9);
		
		spinner_10.setBounds(109, 113, 57, 20);
		spinner_10.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(spinner_10);
		
		spinner_11.setBounds(109, 144, 57, 20);
		spinner_11.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(spinner_11);
		
		spinner_12.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		spinner_12.setBounds(109, 175, 57, 20);
		frame.getContentPane().add(spinner_12);
		
		spinner_13.setBounds(109, 206, 57, 20);
		spinner_13.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(spinner_13);
		
		spinner_14.setBounds(109, 237, 57, 20);
		spinner_14.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(spinner_14);
		
		spinner_15.setBounds(109, 270, 57, 20);
		spinner_15.setModel(new SpinnerNumberModel(0, 0, 31, 1));
		frame.getContentPane().add(spinner_15);
		
		spinner_16.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		spinner_16.setBounds(176, 40, 57, 20);
		frame.getContentPane().add(spinner_16);
		
		spinner_17.setBounds(176, 71, 57, 20);
		spinner_17.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_17);
		
		spinner_18.setBounds(176, 113, 57, 20);
		spinner_18.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_18);
		
		spinner_19.setBounds(176, 144, 57, 20);
		spinner_19.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_19);
		
		spinner_20.setBounds(176, 175, 57, 20);
		spinner_20.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_20);
		
		spinner_21.setBounds(176, 206, 57, 20);
		spinner_21.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_21);
		
		spinner_22.setBounds(176, 237, 57, 20);
		spinner_22.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_22);
		
		spinner_23.setBounds(176, 268, 57, 20);
		spinner_23.setModel(new SpinnerNumberModel(0, 0, 127, 1));
		frame.getContentPane().add(spinner_23);
		
		jImage.setBounds(436, 48, 176, 310);
		frame.getContentPane().add(jImage);
		
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(422, 0, 4, 382);
		frame.getContentPane().add(separator);
		
		lblBattery.setHorizontalAlignment(SwingConstants.LEFT);
		lblBattery.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblBattery.setBounds(10, 344, 57, 14);
		frame.getContentPane().add(lblBattery);
		
		lblv.setHorizontalAlignment(SwingConstants.LEFT);
		lblv.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblv.setBounds(73, 344, 57, 14);
		frame.getContentPane().add(lblv);
		
		String[] portNames = SerialPortList.getPortNames();
        for(int i = 0; i < portNames.length; i++){
        	comboBox.addItem(portNames[i]);
        }
        
        
	}
}
