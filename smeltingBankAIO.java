package scripts;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.Bank;
import scripts.smeltingAIO;
import scripts.smeltingUseAIO;
public class smeltingBankAIO extends Task<ClientContext> {
	int copperOreId = 436;
	int tinOreId = 438;
	int ironOreId = 440;
	int coalOreId = 453;
	int silverOreId = 442;
	int goldOreId = 444;
	int mithrilOreId = 447;
	int adamantOreId = 449;
	int runeOreId = 451;
	int oreChoice = 1;
	int oreChoice2 = 2;



	public smeltingBankAIO(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	int bankId = 1270;
	GameObject bank = ctx.objects.select().id(bankId).nearest().poll();	
	
	
//==============================================================================================	
	
	
	public boolean activate() {//what to satisfy to activate
			
		return ctx.inventory.select().count()<28;
	}

	
	
	
	
//==============================================================================================	

	
	
	public void execute() {//do what
		System.out.println("entering execute for banking");
		System.out.println(smeltingAIO.userChoice+"is the var entering the bank on  line 52");
		
		
		
		
		
		
		
//==============================================================================================	
		
		
		
				
		while(ctx.bank.opened()==false) {//loop the ctx open til it opens
		Condition.sleep(1000);
		ctx.bank.open();
		Condition.sleep(1000);
		ctx.camera.turnTo(bank);
		ctx.movement.step(bank);
		}
		Condition.sleep(1000);
		ctx.bank.depositInventory();

		
		
		
		
		
//==============================================================================================		
		
		Condition.sleep(1000);
		
		if (smeltingAIO.userChoice.equals("Bronze")) {
			oreChoice = copperOreId;
			oreChoice2 = tinOreId;
			ctx.bank.withdraw(oreChoice, 14);//copper
			Condition.sleep(1000);
			ctx.bank.withdraw(oreChoice2, 14);//tin
			Condition.sleep(1000);
			ctx.bank.close();			
		}
		
		
		if(smeltingAIO.userChoice.equals("Iron")) {
			oreChoice = ironOreId;
			ctx.bank.withdraw(oreChoice, 28);//iron			
			Condition.sleep(1000);
			ctx.bank.close();
		}
		
		
	
		if(smeltingAIO.userChoice.equals("Steel")) {//
			oreChoice = ironOreId;
			oreChoice2 = coalOreId;
			ctx.bank.withdraw(oreChoice, 14);//iron
			Condition.sleep(1000);
			ctx.bank.withdraw(oreChoice2, 14);//coal
			Condition.sleep(1000);
			ctx.bank.close();
			
		}
		
		if(smeltingAIO.userChoice.equals("Silver")) {
			oreChoice = silverOreId;
			ctx.bank.withdraw(oreChoice, 28);//silver			
			Condition.sleep(1000);
			ctx.bank.close();
		}

			
		if(smeltingAIO.userChoice.equals("Gold")) {
			oreChoice = goldOreId;
			ctx.bank.withdraw(oreChoice, 28);//gold		
			Condition.sleep(1000);
			ctx.bank.close();
		}
			
	
		
		if(smeltingAIO.userChoice.equals("Mithril")) {//mith takes 5 mith and 20 coal max, we withdraw 23 to maintain a full inv
			oreChoice = mithrilOreId;
			oreChoice2 = coalOreId;
			ctx.bank.withdraw(oreChoice, 5);//mith
			Condition.sleep(1000);
			ctx.bank.withdraw(oreChoice2, 23);//coal
			Condition.sleep(1000);
			ctx.bank.close();
			
		}
		if(smeltingAIO.userChoice.equals("Adamant")) {//adamant takes 4 adamant and 24 coal max
			oreChoice = adamantOreId;
			oreChoice2 = coalOreId;
			ctx.bank.withdraw(oreChoice, 4);//adamant
			Condition.sleep(1000);
			ctx.bank.withdraw(oreChoice2, 24);//coal
			Condition.sleep(1000);
			ctx.bank.close();
			
		}
		
		if(smeltingAIO.userChoice.equals("Rune")) {//rune takes 3 rune and 24 coal max	
			oreChoice = runeOreId;
			oreChoice2 = coalOreId;
			ctx.bank.withdraw(oreChoice, 3);//adamant
			Condition.sleep(1000);
			ctx.bank.withdraw(oreChoice2, 25);//coal
			Condition.sleep(1000);
			ctx.bank.close();
			
		}
		
		
		

//==============================================================================================		
		
		
		if (ctx.inventory.select().count()<28){//didn't withdraw right amount
			ctx.controller.stop();
			System.out.println("ran out of stuff");
			
		}
		
	}//closes execute




	@Override
	public String status() {//todo status
		// TODO Auto-generated method stub
		return "banking";
	}
}


