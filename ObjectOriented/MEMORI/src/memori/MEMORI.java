/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memori;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyJFrame extends JFrame{
    //存圖片
    private ImageIcon[] icons = new ImageIcon[5];
    //存格子
    private JButton[] jbtn = new JButton[8];
    //兩個按鈕
    private JButton jbtnOk, jbtnf, jbtns;
    //f 和 s 是按下圖片取得的字串
    String f="", s="";
    //num: 按下按鈕次數, win: 猜對幾組
    int num=0, win=0;
    //rnd[0]~ rnd[7] 存每張圖的編號
    int[] rnd = new int[8];
    //MyJFrame constructor 
    MyJFrame(){
        //不使用版面配置
        super.setLayout(null);
        //標題
        super.setTitle("MEMORY TEST");
        //icons[0]~icons[4] 為圖示
        for(int i=0; i<icons.length; i++){
            icons[i] = new ImageIcon(".\\memoryImg\\" + String.valueOf(i) + ".jpg");
        }
        
        //視窗放入jbtnOk 確定鈕
        jbtnOk = new JButton("OK");
        jbtnOk.setBounds(20,260,80,30);
        add(jbtnOk);
        
        //設定jbtnOk 為anony actionListener
        jbtnOk.addActionListener(new ActionListener(){
            public 
        })
        
    
    }




}







/**
 *
 * @author yale918
 */
public class MEMORI {

    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
