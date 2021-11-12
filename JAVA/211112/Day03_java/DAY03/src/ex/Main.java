import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class javaFrame {

    public static void main(String[] args) {
        // Create frame
        JFrame j = new JFrame();
        j.setTitle("로그인 화면");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Cloud 강의 로그인");
        headingPanel.add(headingLabel);

        JPanel panel = new JPanel(new GridBagLayout());

        // Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();
        constr.anchor = GridBagConstraints.WEST;

        // Setting initial grid values to 0,0
        JLabel userID = new JLabel("ID :   ");
        JLabel userPw = new JLabel("PASSWORD :  ");
        JTextField idInput = new JTextField(20);
        JTextField pwInput = new JTextField(20);
        panel.add(userID, constr);
        constr.gridx = 1;
        panel.add(idInput, constr);
        constr.gridx = 0;
        constr.gridy = 1;
        panel.add(userPw, constr);
        constr.gridx = 1;
        panel.add(pwInput, constr);

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        // Button with text "Register"
        JButton button = new JButton("로그인");
        JButton button2 = new JButton("취소");
        // add a listener to button

        button.setBounds(185, 300, 100, 30);
        button2.setBounds(285, 300, 100, 30);
        j.getContentPane().add(button);
        j.getContentPane().add(button2);

        mainPanel.add(headingPanel);
        mainPanel.add(panel);
        j.add(mainPanel);
        j.pack();
        j.setSize(500, 500);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
