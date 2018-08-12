
package project_or;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static project_or.panal_dual.valid;

public class panal_graph extends javax.swing.JPanel {

    private String arr[] = {">=", "<=", "="};
    private JComboBox comboBox[] = new JComboBox[100];
    private JTextField text[] = new JTextField[1000];
    private JTextField text1[] = new JTextField[100];
    private JLabel label[] = new JLabel[1000];
    public int count1,count,var,cons=0;
    public int a=100,b=10;
    int d[]= new int[100];
    int c[]= new int[100];
    int x1[]=new int[100];
    int x2[]=new int[100];
    
    public panal_graph() {
        initComponents();
    }

    public  int[] point_x1(){
    
    for(int i=2,j=0;j<cons;j++,i+=2){
        if(d[i]==0)
            x1[j]=0;
        else
        x1[j]=c[j]/d[i];
    }    
    return x1;
    }
    public int[]  point_x2(){
    
    for(int i=3,j=0;j<cons;j++,i+=2){
        if(d[i]==0)
            x2[j]=0;
        else
        x2[j]=c[j]/d[i];
    }
    return x2;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_cons = new javax.swing.JTextField();
        button_ok = new javax.swing.JButton();
        panal_cons = new javax.swing.JPanel();
        txt_var = new javax.swing.JTextField();
        combo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(36, 36, 36));

        txt_cons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_consActionPerformed(evt);
            }
        });
        txt_cons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_consKeyReleased(evt);
            }
        });

        button_ok.setText("OK");
        button_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panal_consLayout = new javax.swing.GroupLayout(panal_cons);
        panal_cons.setLayout(panal_consLayout);
        panal_consLayout.setHorizontalGroup(
            panal_consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panal_consLayout.setVerticalGroup(
            panal_consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        txt_var.setText("2");
        txt_var.setEnabled(false);
        txt_var.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_varKeyReleased(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MAX", "MIN", " " }));

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton1.setText("Graph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Number of variable");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Number of constrains ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panal_cons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_var, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_var, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txt_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(button_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(panal_cons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_okActionPerformed

        if(combo.getSelectedItem().equals("MAX")){
             JLabel label4 = new JLabel("MAX Z =");
        panal_cons.add(label4);
        label4.setBounds(40, 10, 60, 30);
        }else{
            JLabel label4 = new JLabel("MIN Z =");
        panal_cons.add(label4);
        label4.setBounds(40, 10, 60, 30);
        }
        
        JLabel label3 = new JLabel("S.T");
        panal_cons.add(label3);
        label3.setBounds(10, 40, 40, 30);
        cons=Integer.parseInt(txt_cons.getText());
        var=Integer.parseInt(txt_var.getText());
        for (int i = 0; i <= cons; i++) {
            for (int z = 0; z < var; z++) {
                text[count] = new JTextField();
                label[count] = new JLabel();
                panal_cons.add(label[count]);
                panal_cons.add(text[count]);
                text[count].setBounds(a, b, 30, 30);
                label[count].setBounds(a + 30, b, 30, 30);

                label[count].setText("X" + (z + 1));
                count++;
                a += 60;
            }
            if (i != 0) {
                comboBox[count1] = new JComboBox(arr);
                text1[count1] = new JTextField();
                panal_cons.add(text1[count1]);
                panal_cons.add(comboBox[count1]);
                text1[count1].setBounds(a + 60, b, 30, 30);
                comboBox[count1].setBounds(a, b, 50, 30);
                count1++;
            }
            a = 50;
            b += 40;
        }
       
        
    }//GEN-LAST:event_button_okActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      
        for(int i=0;i<cons*var+var;i++){
            d[i]=Integer.parseInt(text[i].getText());
        }   
for(int i=0;i<cons*var+var;i++){
           System.out.println(" D ["+i+"]  =" +d[i]);
        } 
        for (int i = 0; i < cons; i++) {
            c[i]=Integer.parseInt(text1[i].getText());
            System.out.println(" Text1  = "+c[i] );
        }
        JFrame f=new JFrame();
        f.setSize(300, 300);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add( new paint(point_x1(),point_x2(),cons));
      
      /* int w[]=new int[100];
       w=point_x1();
       for(int i=0;i<3;i++)
            System.out.println("w  =  "+w[i]);*/
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_consActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_consActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_consActionPerformed

    private void txt_varKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_varKeyReleased

String a=txt_var.getText();
        if(valid(a)==0){
        button_ok.setEnabled(false);
            txt_var.setBackground(Color.red);
        }else{
            
            txt_var.setBackground(Color.white);
        button_ok.setEnabled(true);
        }     
        
// TODO add your handling code here:
    }//GEN-LAST:event_txt_varKeyReleased

    private void txt_consKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_consKeyReleased

String a=txt_cons.getText();

        if(valid(a)==0){
button_ok.setEnabled(false);        
           txt_cons.setBackground(Color.red);
        }else{
button_ok.setEnabled(true);
            txt_cons.setBackground(Color.white);        
    }        

// TODO add your handling code here:
    }//GEN-LAST:event_txt_consKeyReleased

    public static void main(String[] args) {
        
        JFrame f=new JFrame();
        f.setSize(590 , 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new panal_graph());
        f.setVisible(true);
        
        
    }
    static int valid(String s){
        if(s.matches("[0-9]+"))
            return 1;
        
        return 0;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ok;
    private javax.swing.JComboBox combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panal_cons;
    private javax.swing.JTextField txt_cons;
    private javax.swing.JTextField txt_var;
    // End of variables declaration//GEN-END:variables
}
