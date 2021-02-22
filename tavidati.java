import javax.swing.JFrame;

class GUI1
{
	public static void main(String[] args) 
	{
		GUI2 bizness = new GUI2();	
		bizness.Input();		
		bizness.Toppings();
		bizness.Pica();
		bizness.Lielums();
		bizness.kvantitate();
		bizness.Output();

		bizness.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bizness.setLocationByPlatform(true);
		bizness.setSize(575,500);
		bizness.setVisible(true);
	}
}