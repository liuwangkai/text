package ForUser;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ForDB.dbOfContact;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;

public class User extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public User(dbOfContact contact) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setTitle("电话号码查询系统");
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add add=new Add(contact);
				add.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				Alter alter=new Alter(contact,row);
				alter.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

					contact.id.remove(row);
					contact.department.remove(row);
					contact.name.remove(row);
					contact.contact.remove(row);
					try {
						contact.updata();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}
				
		);
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search se=new Search(contact);
				se.setVisible(true);
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton button_3 = new JButton("\u5237\u65B0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] columnNames = new String[] { "编号", "姓名", "联系方式", "部门" };
				table.setVisible(false);
				String [][]user=new String[contact.id.size()][4];
				for(int i=0;i<contact.id.size();i++)
				{
					user[i][0]=contact.id.get(i);
					user[i][1]=contact.name.get(i);
					user[i][2]=contact.contact.get(i);
					user[i][3]=contact.department.get(i);
				}
				System.out.println(1);
				dispose();
				User user1=new User(contact);
				user1.setVisible(true);
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 20));
		
		String[] columnNames = new String[] { "编号", "姓名", "联系方式", "部门" };
        /*String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
        */
		
		String [][]user=new String[contact.id.size()][4];
		for(int i=0;i<contact.id.size();i++)
		{
			user[i][0]=contact.id.get(i);
			user[i][1]=contact.name.get(i);
			user[i][2]=contact.contact.get(i);
			user[i][3]=contact.department.get(i);
		}
		table= new JTable(user,columnNames);
		
		 scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7F16\u53F7");
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		
		JLabel label_3 = new JLabel("\u90E8\u95E8");
		//JScrollPane sp = new JScrollPane(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(button)
											.addGap(33)
											.addComponent(btnNewButton)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(28)
											.addComponent(button_1)
											.addGap(30)
											.addComponent(button_2)
											.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
											.addComponent(button_3))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(94)
											.addComponent(label_2))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(37, Short.MAX_VALUE)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)))
					.addGap(30))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
					.addComponent(label_3)
					.addGap(60))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton)
						.addComponent(button_1)
						.addComponent(button_2)
						.addComponent(button_3))
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_3)
						.addComponent(label_1)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
