//Image Cryptography
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Cryptography
{
    public static void operate(int key)
    {
        JFileChooser fileChooser=new JFileChooser();//Selects files for encryption
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        try
        {
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Process Completed");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) 
    {
        JFrame f=new JFrame();
        f.setTitle("Image cryptography");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.BOLD,25);
        JButton button=new JButton();
        JButton b=new JButton();
        b.setText("Enter the Code");
        f.add(b);
        button.setText("Encode");
        button.setFont(font);
        JTextField textField=new JTextField(10);
        textField.setFont(font);
        button.addActionListener(e->
        {
            String text=textField.getText();
            int temp=Integer.parseInt(text);//String to integer
            operate(temp);
        });
        f.setLayout(new FlowLayout());
        f.add(textField);
        f.add(button);
        f.setVisible(true);
        JButton butt=new JButton();
        butt.setText("DECODE");
        butt.setFont(font);
        
        butt.addActionListener(e->
        {
            String tex=textField.getText();
            int temp=Integer.parseInt(tex);
            operate(temp);
        });
        f.setLayout(new FlowLayout());
        f.add(butt);
        f.setVisible(true);//blocking operation
    }
}
