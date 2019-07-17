package scripts;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.TextQuery;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ChatOption;
import java.awt.event.KeyListener;

public class smeltingUseAIO extends Task<ClientContext> {
	int furnaceId = 16469;
	int bankId = 10355;
	GameObject bank = ctx.objects.select().id(bankId).nearest().poll();
	int copperId = 436;
	int tinId = 438;
	
	String whatNumberToPush;
	int copperOreId = 436;
	int tinOreId = 438;
	int ironOreId = 440;
	int coalOreId = 453;
	int silverOreId = 442;
	int goldOreId = 444;
	int mithrilOreId = 447;
	int adamantOreId = 449;
	int runeOreId = 451;
	int oreChoice;
	int smithAnim = 899;
	int bronzeWait = 0;
	int ironWait = 0;
	int silverWait = 0;
	int steelWait = 0;
	int goldWait = 0;
	int mithWait = 0;
	int adamWait = 0;
	int runeWait = 0;
	int waitTime;
	

	
//===========================================================================================================================	
	public smeltingUseAIO(ClientContext ctx) {
		super(ctx);
	}
	
//===========================================================================================================================	
	
	public boolean activate() {
		return ctx.inventory.select().count() == 28;
		//return ctx.client().
	
	}

//===========================================================================================================================	

	@Override
	public void execute() {
		GameObject furnace = ctx.objects.select().id(furnaceId).nearest().poll();
	
		System.out.println("execute in use class");
		
		if(smeltingAIO.userChoice.equals("Bronze")) {
			whatNumberToPush = "1";
			oreChoice = copperOreId;
			waitTime = bronzeWait;
		}
		
		if(smeltingAIO.userChoice.equals("Iron")) {
			whatNumberToPush = "2";
			oreChoice = ironOreId;
			waitTime = ironWait;
		}
		if(smeltingAIO.userChoice.equals("Silver")) {
			whatNumberToPush = "3";
			oreChoice = silverOreId;
			waitTime = silverWait;
		}
		if(smeltingAIO.userChoice.equals("Steel")) {
			whatNumberToPush = "4";
			oreChoice = ironOreId;
			waitTime = steelWait;
		}
		if(smeltingAIO.userChoice.equals("Gold")) {
			whatNumberToPush = "5";
			oreChoice = goldOreId;
			waitTime = goldWait;
		}
		if(smeltingAIO.userChoice.equals("Mithril")) {
			whatNumberToPush = "6";
			oreChoice = mithrilOreId;
			waitTime = mithWait;
		}
		if(smeltingAIO.userChoice.equals("Adamant")) {
			whatNumberToPush = "7";
			oreChoice = adamantOreId;
			waitTime = adamWait;
		}
		if(smeltingAIO.userChoice.equals("Rune")) {
			whatNumberToPush = "8";
			oreChoice = runeOreId;
			waitTime = runeWait;
		}
		
	
		
		
		//turn to furnace from back and walk towards it
		
		ctx.camera.turnTo(furnace);
		ctx.movement.step(furnace);
		Condition.sleep(1000);
	
		
		
		
		//while walking, dont do anything
		
		while(ctx.players.local().animation()!=-1) {
			Condition.sleep(1000);
		}
		
		Condition.sleep(3000);
		boolean flag = false;
		
		
		
		//infinite loop til everything is smelted
		while (flag == false){
			furnace.click();
			Condition.sleep(2000);
			ctx.input.send(whatNumberToPush);
			Condition.sleep(2555);
		while(ctx.players.local().animation()!=-1) {//while smelting, dont do anything
			Condition.sleep(2555);//2555 because 3 seconds for smithing animation
			flag = false;
		}
		if(!ctx.inventory.select().id(oreChoice).isEmpty()) {//check if ore is in invo when something stops us, if theres ore, keep going
        	  flag = false;
          }
		else {
			flag = true;
		}
		}
		
		ctx.camera.turnTo(bank);
		ctx.movement.step(bank);


	
	
	}
		
		

	
	
	
//===========================================================================================================================	


	@Override
	public String status() {
		// TODO Auto-generated method stub
		return "using";
	}
	
	
	

}
