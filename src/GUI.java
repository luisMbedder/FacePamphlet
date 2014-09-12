import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class GUI implements FacePamphletConstants{
	
	private JFrame frame;
	private JPanel mainPanel;//this is what i'll add to the contentPane

    private JTextField statusTextField1;
    private JTextField nameTextField1;
    private JTextField pictureTextField1;
    private JTextField friendTextField1;
    private JLabel profileNameLabel;
    private JLabel profileStatusLabel;
    private JLabel profileFriendsLabel;
    private JLabel profileInfoLabel;
    private JTextArea textArea;
    private FacePamphletDatabase database = new FacePamphletDatabase();
    private static String currentProfile=null;
    private static ActionEvent buttonPressed=null;
    private String friend;
    //ProfilePanel panel = new ProfilePanel(this);
   // ProfilePanel panel = new ProfilePanel();
    private JPanel panel = new JPanel();
   
    
    
	public GUI(){
		initializeComponents();
		frame = new JFrame("FacePamphlet");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, APPLICATION_WIDTH, APPLICATION_HEIGHT);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
	}
	
	

	
	private void initializeComponents(){

		mainPanel=new JPanel();
		mainPanel.setBackground(new Color(176, 196, 222));
		statusTextField1 = new JTextField();
		statusTextField1.setColumns(10);
		statusTextField1.setDocument(new JTextFieldLimit(TEXT_FIELD_SIZE));
		
		nameTextField1 = new JTextField();
		nameTextField1.setColumns(10);
		nameTextField1.setDocument(new JTextFieldLimit(TEXT_FIELD_SIZE));
		
		pictureTextField1 = new JTextField();
		pictureTextField1.setColumns(10);
		pictureTextField1.setDocument(new JTextFieldLimit(TEXT_FIELD_SIZE));
		
		friendTextField1 = new JTextField();
		friendTextField1.setColumns(10);
		friendTextField1.setDocument(new JTextFieldLimit(TEXT_FIELD_SIZE));

		profileNameLabel = new JLabel();
		profileNameLabel.setBounds(25, 11, 182, 41);
		profileNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		profileNameLabel.setForeground(UIManager.getColor("Button.focus"));
		profileNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		
		profileInfoLabel = new JLabel();
		profileInfoLabel.setBounds(241, 360, 215, 32);
		profileInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profileInfoLabel.setForeground(UIManager.getColor("Button.focus"));
		profileInfoLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		profileStatusLabel = new JLabel();
		profileStatusLabel.setBounds(25, 233, 167, 57);
		profileStatusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		profileStatusLabel.setForeground(UIManager.getColor("Button.focus"));
		profileStatusLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		profileFriendsLabel = new JLabel();
		profileFriendsLabel.setBounds(323, 20, 73, 32);
		profileFriendsLabel.setVerticalAlignment(SwingConstants.TOP);
		profileFriendsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		profileFriendsLabel.setForeground(UIManager.getColor("Button.focus"));
		profileFriendsLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBounds(323, 56, 73, 104);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		textArea.setVisible(false);
		//JScrollPane scroll = new JScrollPane(textArea); //place the JTextArea in a scroll pane	
	//	textArea.setBorder(BorderFactory.createEmptyBorder());
	//	add(textArea, BorderLayout.CENTER);

		JLabel nameLabel1 = new JLabel("Name");
		nameLabel1.setFont(new Font("Dialog", Font.BOLD, 13));
		JButton addProfileButton = new JButton("Add");
		addProfileButton.setFont(new Font("Dialog", Font.BOLD, 11));
		
		
		JButton deleteProfileButton = new JButton("Delete");
		deleteProfileButton.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton lookupProfileButton = new JButton("Lookup");
		lookupProfileButton.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnChangePicture = new JButton("Change Picture");
		btnChangePicture.setFont(new Font("Dialog", Font.BOLD, 11));
		
		JButton btnAddFriend = new JButton("Add Friend");
		btnAddFriend.setFont(new Font("Dialog", Font.BOLD, 11));

		panel.setBackground(Color.WHITE);
			
		
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(statusTextField1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(btnChangeStatus, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(pictureTextField1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(btnAddFriend, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(btnChangePicture, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
						.addComponent(friendTextField1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(nameLabel1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nameTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addProfileButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteProfileButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lookupProfileButton)
							.addGap(322))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(nameLabel1)
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(nameTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(addProfileButton)
							.addComponent(deleteProfileButton)
							.addComponent(lookupProfileButton)))
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(44)
							.addComponent(statusTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnChangeStatus)
							.addGap(18)
							.addComponent(pictureTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnChangePicture)
							.addGap(18)
							.addComponent(friendTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAddFriend))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel.setLayout(null);
		panel.add(profileInfoLabel);
		panel.add(profileStatusLabel);
		panel.add(profileNameLabel);
		panel.add(profileFriendsLabel);
		panel.add(textArea);
		mainPanel.setLayout(gl_mainPanel);
		
		
	
///Action Listener for Add Button
	addProfileButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			buttonPressed=e;
			String name = nameTextField1.getText();
			if(!database.containsProfile(name)){
			textArea.setText("");
			textArea.setVisible(false);
			profileNameLabel.setText(nameTextField1.getText());
			profileInfoLabel.setText("New profile created");
			profileFriendsLabel.setText("Friends:");
			profileStatusLabel.setText("No current status");
			currentProfile = name;
			FacePamphletProfile newProfile = new FacePamphletProfile(name);//create new profile
			database.addProfile(newProfile);//add profile to database
			panel.add(profileNameLabel);

			}
			else
				profileInfoLabel.setText("A profile with the name "+name+" already exists");
			panel.revalidate();
			panel.repaint();
		
		}
	});
	
	///Action Listener for delete profile Button
	deleteProfileButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			buttonPressed=e;
			if(database.containsProfile(nameTextField1.getText())){
			database.deleteProfile(nameTextField1.getText());
			currentProfile = null;
			profileInfoLabel.setText("Profile of "+nameTextField1.getText()+" deleted");
			profileStatusLabel.setText("");
			profileNameLabel.setText("");
			profileFriendsLabel.setText("");
			textArea.setText("");
			textArea.setVisible(false);
			}
			else
				profileInfoLabel.setText("A profile with the name "+nameTextField1.getText()+" doesnt exist");
			panel.revalidate();
			panel.repaint();
				
		}
	});
	
	
	
	///Action Listener for change status Button
	btnChangeStatus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			buttonPressed=e;
			String status = statusTextField1.getText();
			if((currentProfile!=null)&&(status.length()!=0)){
				database.getProfile(currentProfile).setStatus(status);	
				profileInfoLabel.setText("Status updated to "+status);
				profileStatusLabel.setText(status);
				panel.revalidate();
				panel.repaint();
			}
			
	
		
		}
	});
	
	///Action Listener for add friend Button
	btnAddFriend.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			buttonPressed=e;
			
			friend = friendTextField1.getText();
			if(database.containsProfile(friend)){
				textArea.setVisible(true);
				database.getProfile(currentProfile).addFriend(friend);//add friend to profile
				database.getProfile(friend).addFriend(currentProfile);//add reciprocal friend
				profileInfoLabel.setText(friend+" added as a friend");
				printFriendList();
			//	panel.revalidate();
			}
			else{
				profileInfoLabel.setText(friend+" does not exist");
			}
		}
	});
	
	///Action Listener for change picture Button
	btnChangePicture.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			buttonPressed=e;
			String filename = pictureTextField1.getText();
			//	database.getProfile(nameTextField1.getText()).setImage();
			
			Image image = null;
			try {
				  image = ImageIO.read(new File(filename));//image = new Image(filename);
				  database.getProfile(currentProfile).setImage(image);
			} catch (IOException ex) {
					// Code that is executed if the filename cannot be opened.
			}
			
			frame.repaint();
		}
	});
	
	///Action Listener for lookup profile Button
	lookupProfileButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			buttonPressed=e;
			
			//if(database.getProfile(currentProfile).getName()!=null){
			try{
			currentProfile = nameTextField1.getText();//database.getProfile(currentProfile).getName();
			profileNameLabel.setText(database.getProfile(currentProfile).getName());
			profileStatusLabel.setText(database.getProfile(currentProfile).getStatus());
			profileInfoLabel.setText("Displaying "+ currentProfile);
			printFriendList();
			//profileFriendsLabel
			}
			catch(Exception e1){
				profileInfoLabel.setText("Profile doesn't exist");
				currentProfile = null;
			}
			panel.revalidate();
			panel.repaint();
			//frame.repaint();
		}
	});
	

}
	
	public void printFriendList(){
	String gd="";
	Iterator<String> it = database.getProfile(currentProfile).getFriends();
	if(it.hasNext()){
	 gd =it.next();
	 textArea.setText(gd+"\n");
       while(it.hasNext()){ 
    	   textArea.append(it.next()+"\n");
       }
	}
	}
}

