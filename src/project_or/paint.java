
package project_or;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class paint extends JPanel{
public int arr_x1[];
public int arr_x2[];
public int cons_num;
  
public paint(int x1[],int x2[],int num){
    
    this.arr_x1=x1;
    this.arr_x2=x2;
    this.cons_num=num;
}

    @Override
    protected void paintComponent(Graphics g) {
       
        int space = 0, y = 0;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        g.setColor(Color.black);
        Font f=new Font("Graph",Font.BOLD, 48);
        g.setFont(f);
        g.drawLine((this.getWidth() / 2) , 0, (this.getWidth() / 2) , this.getHeight());
        g.drawLine(0, (this.getHeight() / 2) , this.getWidth(), (this.getHeight() / 2));
        /*........................ Draw X1 & X2 ..............................*/
         Font f1=new Font("Graph",Font.BOLD, 11);
        g.setFont(f1);
            g.setColor(Color.red);
            g.drawString("X2", (this.getWidth() / 2)+10 , 10);
            g.drawString("X1", this.getWidth() - 30, (this.getHeight() / 2) - 7);
            
            /*........................... Draw number ............................*/
        for (int i = 0; i < this.getWidth(); i++, space += 20) {
            //for draw squers
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(space, 0, space, this.getHeight());
           g.drawLine(0, space, this.getWidth(), space);
            g.setColor(Color.black);
            if (i == 0 ) {
            } else {
              //for paint numbers -1 -2 -3 .... in x2 corrdinet wwww
              g.drawString("" + (-i), (this.getWidth() / 2) - 22, (this.getHeight() / 2) + (space + 10));
                 // g.drawString("" + (-i), (this.getWidth() / 2) , (this.getHeight() / 2) + (space ));
            }
            if (i == 0) {
            } else {
                //for paint numbers -1 -2 -3 .... in x1 corrdinet 
                g.drawString("" + (-y), (this.getWidth() / 2) - (space + 9), (this.getHeight() / 2) + 10);
               //   g.drawString("" + (-y), (this.getWidth() / 2) - (space), (this.getHeight() / 2) );
                //for paint numbers 1 2 3 .... in x1 corrdinet 
               g.drawString("" + (i), (this.getWidth() / 2) + (space - 10), (this.getHeight() / 2) + 10);
//g.drawString("" + (i), (this.getWidth() / 2) + (space), (this.getHeight() / 2) );                               
//for paint numbers 1 2 3 .... in x2 corrdinet 
                g.drawString("" + (y), (this.getWidth() / 2) - 10, (this.getHeight() / 2) - (space - 10));
             //   g.drawString("" + (y), (this.getWidth() / 2), (this.getHeight() / 2) - (space ));
            }
            y++;
        }
        
        /*.............................. line .....................*/
          g.setColor(Color.RED);
         
          for(int i=0;i<cons_num;i++){
              if (arr_x1[i] == 0) {
                
                    //when x1=0
                  g.drawLine(0, this.getHeight()/2 - (arr_x2[i]*20), this.getWidth(), this.getHeight()/2 -( arr_x2[i]*20) );
                   
                } else if (arr_x2[i] == 0) {
                    //when x2=0
               g.drawLine((this.getWidth()/2)+arr_x1[i]*20,this.getHeight(),(this.getWidth()/2)+arr_x1[i]*20,0 );
                } else {
          g.drawLine((this.getWidth()/2)+(arr_x1[i]*20),(this.getHeight()/2), (this.getWidth()/2) , (this.getHeight()/2)-(arr_x2[i]*20));
          
                }
          
          
          }
          
    }
    
    public static void main(String[] args) {
       
        
        
    }
    
    
    
}
