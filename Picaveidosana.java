import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class GUI2 extends JFrame 
{
	private Component Picas;
    private JRadioButton res, pas;
    private ButtonGroup g;
	private ImageIcon logo;
    private JLabel nauda2,galda_nr2, V2, kontakts2, adrese2 ,kvant_label, kvant_op, kvant2_label,lielums_op,lielums_label, lielums2_label,pica_op,pica_label,pica2_Label,adrese, V, kontakts, Galda_nr, toppings_label, piegades_tips;
    private JTextField Galda_tf, V_tf, adrese_tf, kontakts_tf;
    private JCheckBox sipols, sampinjones, cisini, brokolis, paprika, siers;
    private JPanel pogas_panel, kvant_panel,lielums_panel,pica_panel,sakum_Panelis, ievad_panelis, piegades_panelis, top1_panel, top2_panel, toppings_panel, toppings2_panel;
    private JCheckBox picas_box, lielums_box;
	private JLabel log_V2,dat_laik2,galda_nr_op, V_op, adrese_op, kontakts_op, nauda_label, nauda_op;
	public Double a, nauda = 0.0;
	public String b,c;
	private JButton print, clear;
	private ImageIcon print_icon, clear_icon;
	String galdanr_str, V_str, adrese_str, kontakts_str, date;

	public GUI2() 
	{
		super("Picerija");
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));
		sakum_Panelis = new JPanel();
		sakum_Panelis.setLayout(new GridLayout(2, 1));		
			
			
		add(sakum_Panelis);	
	}
    public void Input()	{		
		ievad_panelis = new JPanel();
		ievad_panelis.setLayout(new GridLayout(5, 2, 5, 5));	
					
		piegades_panelis = new JPanel();
		piegades_panelis.setLayout(new GridLayout(1, 3));		
		
		piegades_tips = new JLabel("pasūtījuma veids:");	
        piegades_panelis.add(piegades_tips);
		res = new JRadioButton("restorānā");
		res.setActionCommand("res");
	    pas = new JRadioButton("Pasūtījums");
		pas.setActionCommand("pas");
				
		g = new ButtonGroup();
		g.add(res);
		g.add(pas);
		piegades_panelis.add(res);
		piegades_panelis.add(pas);
		
		ievad_panelis.add(piegades_tips);					
		ievad_panelis.add(piegades_panelis);		
		
        Galda_nr = new JLabel("Galda numurs: ");
		V = new JLabel("Vards: ");
		adrese = new JLabel("adresāts");
		kontakts = new JLabel("telefona numurs: ");
        Galda_tf = new JTextField("", 5);
		V_tf = new JTextField("", 10);
		adrese_tf = new JTextField("", 20);
		kontakts_tf = new JTextField("", 10);
        ievad_panelis.add(Galda_nr);
        ievad_panelis.add(Galda_tf);
		ievad_panelis.add(V);
		ievad_panelis.add(V_tf);					
		ievad_panelis.add(adrese);
		ievad_panelis.add(adrese_tf);
		ievad_panelis.add(kontakts);
		ievad_panelis.add(kontakts_tf);
		V.setEnabled(false);
		adrese.setEnabled(false);
		kontakts.setEnabled(false); 
		V_tf.setEditable(false);
		adrese_tf.setEditable(false);
		kontakts_tf.setEditable(false);	
		V_tf.setEnabled(false);
		adrese_tf.setEnabled(false);
		kontakts_tf.setEnabled(false);
		Galda_nr.setEnabled(false);
		Galda_tf.setEnabled(false);					
		Galda_tf.setEditable(false);	
				
		add(ievad_panelis);	
        res.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(res.isSelected())
				{
					V.setEnabled(false);
					adrese.setEnabled(false);
					kontakts.setEnabled(false); 
					V_tf.setEditable(false);
					adrese_tf.setEditable(false);
					kontakts_tf.setEditable(false);	
					V_tf.setEnabled(false);
					adrese_tf.setEnabled(false);
					kontakts_tf.setEnabled(false);
					Galda_nr.setEnabled(true);
					Galda_tf.setEnabled(true);					
					Galda_tf.setEditable(true);		
				}
			}
		});
		
		pas.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				if(pas.isSelected())
				{
					Galda_nr.setEnabled(false);
					Galda_tf.setEnabled(false);					
					Galda_tf.setEditable(false);
					V.setEnabled(true);
					adrese.setEnabled(true);
					kontakts.setEnabled(true); 
					V_tf.setEditable(true);
					adrese_tf.setEditable(true);
					kontakts_tf.setEditable(true);	
					V_tf.setEnabled(true);
					adrese_tf.setEnabled(true);
					kontakts_tf.setEnabled(true);
				}
			}
		});								
	}
    public void Toppings()
	{
		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppings_label = new JLabel("piedevas:");	
		
		sipols = new JCheckBox("sīpols +0,20", false);
		sampinjones = new JCheckBox("šampinjones +0,20", false);
		cisini = new JCheckBox("brokoļi +0.20", false);
		brokolis = new JCheckBox("cīsiņi +0.20", false);
		paprika = new JCheckBox("paprika +0,20", false);
		siers = new JCheckBox("siers +0.20", false);

		ItemListener itemListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					nauda+= 0.20;
				}
			}
		};
			
		sipols.addItemListener(itemListener);
		sampinjones.addItemListener(itemListener);
		cisini.addItemListener(itemListener);
		brokolis.addItemListener(itemListener);
		paprika.addItemListener(itemListener);
		siers.addItemListener(itemListener);
		
		top1_panel.add(sipols);
		top1_panel.add(sampinjones);
		top1_panel.add(cisini);	
		top2_panel.add(brokolis);
		top2_panel.add(paprika);	
		top2_panel.add(siers);					
	
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
					
		toppings2_panel.add(toppings_label);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
	}
    public void Pica(){
		pica_label = new JLabel("Picas: ");
		pica2_Label = new JLabel("Pica: ");
		pica_op = new JLabel();
		pica_panel=new JPanel();
		pica_panel.setLayout(new GridLayout(4,5));
		DefaultComboBoxModel Picas = new DefaultComboBoxModel(new String []  {"Studentu Pica", "Kalifornijas Pica", "Havaju pica", "Zemnieku Pica", "Vistas Karija pica", "Amerikāņu pica"});
		JComboBox picas_box = new JComboBox(Picas);
		picas_box.setSelectedIndex(-1);
		pica_panel.add(pica_label);
		pica_panel.add(picas_box);
		picas_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				pica_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
				b = (picas_box.getSelectedItem().toString());
			}	
		});
		add(pica_panel);
	}
	public void Lielums(){
		lielums_label = new JLabel("lielums: ");
		lielums2_label = new JLabel("lielums:");
		lielums_op = new JLabel();
		lielums_panel = new JPanel();
		lielums_panel.setLayout(new GridLayout(3, 4));
		DefaultComboBoxModel lielums = new DefaultComboBoxModel(new String []  {"20","30","50"});
		JComboBox lielums_box = new JComboBox(lielums);
		lielums_box.setSelectedIndex(-1);
		lielums_panel.add(lielums_label);
		lielums_panel.add(lielums_box);
		lielums_box.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				lielums_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
				c = (lielums_box.getSelectedItem().toString());
			}	
		});
		add(lielums_panel);
	}
	public void kvantitate(){
		kvant_label = new JLabel("Kvantitāte");
		kvant2_label = new JLabel("kvantitāte:");
		kvant_op = new JLabel();
		kvant_panel = new JPanel();
		kvant_panel.setLayout(new GridLayout(2, 2));
		String[] kvanti = {"1","2","3","4","5"};
		JComboBox<String>kvant_box = new JComboBox<String>();
		for(int i=0; i<kvanti.length;i++)
		kvant_box.addItem(kvanti[i]);
		kvant_box.setSelectedIndex(-1);
		kvant_panel.add(kvant_label);
		kvant_panel.add(kvant_box);
		kvant_box.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				kvant_op.setText((String)((JComboBox)e.getSource()).getSelectedItem());
				a = Double.parseDouble(kvant_box.getSelectedItem().toString());
			}
		});
		add(kvant_panel);
	}
	public void Output(){
		pogas_panel = new JPanel();
		pogas_panel.setLayout(new GridLayout(1, 2,10,0));
		Picas = new JLabel("Pica: ");
		galda_nr2=new JLabel("Galda numurs:");
		V2 = new JLabel("Vārds: ");
		adrese2 = new JLabel("Adresāts: ");
		kontakts2= new JLabel("kontakta numurs: ");

		print = new JButton("Print");
		print.setRolloverIcon(print_icon);
		print.setRolloverEnabled(true);
		clear=new JButton("Clear");

		pogas_panel.add(print);
		pogas_panel.add(clear);
		add(pogas_panel);
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Galda_tf.setText("");
				V_tf.setText("");
				adrese_tf.setText("");
				kontakts_tf.setText("");
				g.clearSelection();
				V.setEnabled(true);
				adrese.setEnabled(true);
				kontakts.setEnabled(true);

				V_tf.setEditable(true);
				adrese_tf.setEditable(true);
				kontakts_tf.setEditable(true);	
				V_tf.setEnabled(true);
				adrese_tf.setEnabled(true);
				kontakts_tf.setEnabled(true);
				Galda_nr.setEnabled(true);
				Galda_tf.setEnabled(true);
				Galda_tf.setEnabled(true);
				
				brokolis.setSelected(false);
				paprika.setSelected(false);
				siers.setSelected(false);
				cisini.setSelected(false);
				sampinjones.setSelected(false);
				sipols.setSelected(false);
			}
		});
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				if(b == "Studentu Pica"){
					nauda += 4.20;
				}else if(b  == "Vistas Kariju pica"){
					nauda += 6.46;
				}else if(b  == "Zemnieku Pica"){
					nauda += 5.74;
				}else if(b  == "Havaju pica"){
					nauda += 10.20;
				}else if(b  == "Kalifornijas Pica"){
					nauda += 8.32;
				}else if(b  == "amerikāņu pica"){
					nauda += 7.10;
				}

				if(c == "20"){
					nauda += 2.20;
				}else if(c  == "30"){
					nauda += 4.50;
				}else if(c  == "50"){
					nauda += 7.80;
				}

				nauda *= a;
				String nauda2;
				nauda2 = Double.toString(nauda);
				JLabel rate_label = new JLabel("Sum: ");
				JLabel rate_op_label = new JLabel(nauda2);
				JFrame out = new JFrame();
				out.setLayout(new GridLayout(10, 5));
				log_V2 = new JLabel("Picerija: čeks", logo, 0);		
				out.add(log_V2);				
				date = new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss").format(new Date());							
				dat_laik2 = new JLabel(date);
				out.add(dat_laik2);										
				

				galdanr_str = Galda_tf.getText();
				V_str = V_tf.getText();
				adrese_str = adrese_tf.getText();
				kontakts_str = kontakts_tf.getText();

				galda_nr_op = new JLabel(galdanr_str);
				V_op = new JLabel(V_str);
				adrese_op = new JLabel(adrese_str);
				kontakts_op = new JLabel(kontakts_str);
				out.add(galda_nr2);
				out.add(galda_nr_op);
				out.add(V2);
				out.add(V_op);
				out.add(adrese2);
				out.add(adrese_op);
				out.add(kontakts2);
				out.add(kontakts_op);	

				out.add(pica2_Label);
				out.add(pica_op);
				out.add(lielums2_label);
				out.add(lielums_op);
				out.add(rate_label);
				out.add(rate_op_label);
				out.add(kvant_label);				
				out.add(kvant_op);
				out.pack();
				out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				out.setLocationRelativeTo(null);
				out.setSize(450, 250);
				out.setVisible(true);
				JOptionPane.showMessageDialog(null, "tavs pasūtījums tika saņemts!");
			}
		});
	}
}