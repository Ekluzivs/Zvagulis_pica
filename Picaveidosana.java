import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class GUI2 extends JFrame 
{
    private JRadioButton res, pas;
    private ButtonGroup g;
    private JLabel adrese, V, kontakts, Galda_nr, toppings_label, piegades_tips;
    private JTextField Galda_tf, V_tf, adrese_tf, kontakts_tf;
    private JCheckBox sipols, sampinjones, cisini, brokolis, paprika, siers;
    private JPanel sakum_Panelis, ievad_panelis, piegades_panelis, top1_panel, top2_panel, toppings_panel, toppings2_panel;
    public Double nauda = 0.0;

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
		
		toppings_label = new JLabel("Toppings:");	
		
		sipols = new JCheckBox("Onion +0,20", false);
		sampinjones = new JCheckBox("Mushroom +0,20", false);
		cisini = new JCheckBox("Broccoli +0.20", false);
		brokolis = new JCheckBox("Corn +0.20", false);
		paprika = new JCheckBox("Capsicum +0,20", false);
		siers = new JCheckBox("Cheese +0.20", false);

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
}