package ForUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ForDB.dbOfContact;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Search(dbOfContact contact) {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setTitle("查询");
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		JTextArea textArea1 = new JTextArea();
		System.out.println("*"+textField_1.getText()+"*");
		System.out.println("*"+textField_2.getText()+"*");
		String []st=new String[100];
		int j=0;
		for(int i=0;i<contact.id.size();i++)
		{
			if((textField_1.getText().length()>0?false:true)
				/*(textField.getText().length()>0?textField.getText().equals(contact.name.get(i)):true)&&
			(textField_2.getText().length()>0?textField_2.getText().equals(contact.department.get(i)):true)*/)
			{
				
				st[j]=String.format("%-20s%-20s%-25s%-10s\n", contact.id.get(i),contact.name.get(i),contact.contact.get(i),contact.department.get(i));
				j++;
			}
				
		}
		String str1="";
		for (int i=0;i<j;i++)
		{
			str1+=st[i];
			
		}
		textArea1.setText(str1);
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String []st=new String[100];
				int j=0;
				for(int i=0;i<contact.id.size();i++)
				{
					if(textField_1.getText().length()>0?textField_1.getText().equals(contact.id.get(i)):true&&
							textField.getText().length()>0?textField.getText().equals(contact.name.get(i)):true&&
					textField_2.getText().length()>0?textField_2.getText().equals(contact.department.get(i)):true)
					{
						
						st[j]=String.format("%-20s%-20s%-25s%-10s\n", contact.id.get(i),contact.name.get(i),contact.contact.get(i),contact.department.get(i));
						j++;
					}
						
				}
				
				String str1="";
				for (int i=0;i<j;i++)
				{
					str1+=st[i];
					
				}
				textArea1.setText(str1);
				str1=null;
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel label_3 = new JLabel("\u7F16\u53F7");
		
		JLabel label_4 = new JLabel("\u59D3\u540D");
		
		JLabel label_5 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		
		JLabel label_6 = new JLabel("\u90E8\u95E8");
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(35)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 66, GroupLayout.PREFERRED_SIZE)))
					.addGap(111))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(textArea1, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addGap(51)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_5)
							.addGap(51)
							.addComponent(label_6)
							.addGap(49))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addComponent(label_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(button)
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_6)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
