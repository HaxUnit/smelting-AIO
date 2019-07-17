package scripts;


import org.powerbot.script.AbstractScript;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

import javax.swing.JOptionPane;

@Script.Manifest(name = "Hax Smelter AIO", description = "smelts bars at edgeville -V1.0")//V1.0


public class smeltingAIO extends PollingScript<ClientContext> implements MessageListener, PaintListener {
	
	private List<Task> taskList = new ArrayList<Task>();
	int copperOreId = 1;
	int tinOreId = 1;
	int ironoreid = 440;
	int coalOreId = 453;
	int silverOreId = 442;
	int goldOreId = 444;
	int mithrilOreId = 447;
	int adamantOreId = 449;
	int runeOreId = 451;
    Task Bronze,Iron,Steel,Silver,Gold,Mithril,Adamant,Rune;
    public static String userChoice;
	
//=============================================================================================================    	
	
	public  void start() {
		taskList.addAll(Arrays.asList(new smeltingBankAIO(ctx),new smeltingUseAIO(ctx)));
		String userOptions[] = {"Bronze", "Iron","Steel","Silver", "Gold","Mithril","Adamant", "Rune"};
         userChoice = ""+(String)JOptionPane.showInputDialog(null, "Select what bar to smith", "Fishing", JOptionPane.PLAIN_MESSAGE, null, userOptions, userOptions[0]);
    	
        
       
	}
	

//=============================================================================================================    	
	
	
	public void poll() {
		for (Task task : taskList) {
			if (task.activate()) {
				task.execute();
				 
			}
		}
		
	}
	
//=============================================================================================================    	
//paint	
	
	public static final Font TAHOMA = new Font("Tahoma", Font.PLAIN, 12);

    public void repaint(Graphics graphics) {
    	long milliseconds = getTotalRuntime();
        long seconds = (milliseconds / 1000) % 60;
        long minutes = (milliseconds / (1000*60) % 60);
        long hours = (milliseconds / (1000*60*60)) % 24; 		
    	final Graphics2D g = (Graphics2D) graphics;
    	g.setFont(TAHOMA);
        g.setColor(Color.WHITE);   
		g.drawString(String.format("HaxBars (AIO)  Time running: "+ String.format("%02d:%02d:%02d", hours, minutes, seconds)), 10, 35);      
    }
 
  //=============================================================================================================    	
   

	@Override
	public void messaged(MessageEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
