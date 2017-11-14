import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Game implements ActionListener
{
JFrame f;
JButton b[];
JPanel p1,p2;
JMenuBar menubar;
JMenu menu;
JMenuItem item;
JTextField jt;
int player1[],player2[];
int end=0;
int index1,index2;
Game(String s)
{index1=-1;
index2=-1;
player1=new int[10];player2=new int[10];
f=new JFrame(s);
b=new JButton[9];
JLabel jl=new JLabel("switch ");
p2=new JPanel();
p2.setLayout(new GridLayout(3,3));
for(int i=0;i<b.length;i++)
{
b[i]=new JButton();
b[i].addActionListener(this);
p2.add(b[i]);
}
menubar=new JMenuBar();
menu=new JMenu("Game");
menu.setMnemonic(KeyEvent.VK_G);
menubar.add(menu);
item=new JMenuItem("New Game");
item.setMnemonic(KeyEvent.VK_N);
item.addActionListener(this);
menu.add(item);
item=new JMenuItem("Exit");
item.addActionListener(this);
menu.add(item);
f.setJMenuBar(menubar);
/*p1=new JPanel();
p1.add(new JButton(""));
f.add(p1,BorderLayout.NORTH);*/
f.add(p2);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
f.setSize(400,400);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
int i1;
Icon i,j;
i=new ImageIcon("zero1.png");
j=new ImageIcon("wrong.jpg");
if(e.getActionCommand().equals("New Game"))
{new Game("Tic Tac TOe");
}
if(e.getActionCommand().equals("Exit"))
{System.exit(0);}
else if(end==0)
{	
	int turn;
	for(i1=0;i1<b.length;i1++)
	{
	if(e.getSource()==(b[i1])&&(b[i1].getIcon()==null))
	{
		if(player1[9]<=player2[9])
		{player1[9]++;
		b[i1].setBackground(Color.white);
		b[i1].setIcon(i);
		player1[++index1]=i1;turn=1;
		}
		else 
		{player2[9]++;
		b[i1].setIcon(j);b[i1].setBackground(Color.white);
		player2[++index2]=i1;turn=2;
		}
	if(player1[9]>=3||player2[9]>=3)
	{
	switch(turn)
	{
	case 1:
	{int t;
	for(t=0;t<=6;t+=3){
		if(true==find(player1,t,t+1,t+2,index1))
		{       
			b[t].setBackground(Color.orange);b[t+1].setBackground(Color.orange);b[t+2].setBackground(Color.orange);
			end=1;
			return;
		}
	}
	for(t=0;t<=2;t++)
	{
		if(find(player1,t,(t+3),(t+6),index1))
		{end=1;b[t].setBackground(Color.orange);b[t+3].setBackground(Color.orange);b[t+6].setBackground(Color.orange);
			return;
		}
	}
	if(find(player1,0,4,8,index1))
	{b[0].setBackground(Color.orange);b[4].setBackground(Color.orange);b[8].setBackground(Color.orange);
	end=1;
	return;
	}
	if(find(player1,2,4,6,index1))
	{end=1;b[2].setBackground(Color.orange);b[4].setBackground(Color.orange);b[6].setBackground(Color.orange);
	return;}
	break;}
	case 2:
	int t;
	for(t=0;t<=6;t+=3)
	{
		if(find(player2,t,t+1,t+2,index2))
		{end=1;b[t].setBackground(Color.orange);b[t+1].setBackground(Color.orange);b[t+2].setBackground(Color.orange);
			return;
		}
	}
	for(t=0;t<=2;t++)
	{
		if(find(player2,t,(t+3),(t+6),index2))
		{end=1;b[t].setBackground(Color.orange);b[t+3].setBackground(Color.orange);b[t+6].setBackground(Color.orange);
			return;
		}
	}
	if(find(player2,0,4,8,index2))
	{
	end=1;b[0].setBackground(Color.orange);b[4].setBackground(Color.orange);b[8].setBackground(Color.orange);
	return;
	}
	if(find(player2,2,4,6,index2))
	{end=1;
	b[2].setBackground(Color.orange);b[4].setBackground(Color.orange);b[6].setBackground(Color.orange);
	return;}
	}
	}
	break;
	}
	}
	}
}
boolean find(int a[],int x,int y,int z,int index)
{
int flag1=0;
for(int i=0;i<=index;i++)
{
if(a[i]==x||a[i]==y||a[i]==z)
{flag1++;
if(flag1==3)
return true;}
}
return false;
}
public static void main(String s[])
{
Game b=new Game("Tic Tac Toe");
}
}