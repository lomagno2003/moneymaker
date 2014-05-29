package net.clomagno.moneymaker.behaviours.simpletraderbehaviour;

import org.apache.log4j.Logger;

import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.buyingbehaviour.BuyingBehaviour;
import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.scanningbehaviour.ScanningBehaviour;
import net.clomagno.moneymaker.behaviours.simpletraderbehaviour.sellingbehaviour.SellingBehaviour;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;

public class SimpleTraderBehaviour extends SequentialBehaviour {
	private static final long serialVersionUID = 4934131284427906093L;

	private static final Logger log = Logger
			.getLogger(SimpleTraderBehaviour.class.getName());

	@Override
	public void onStart() {
		log.info("Trader behaviour initializaton started");
		// Initialization of states
		Behaviour buyingBehaviour = new BuyingBehaviour();
		Behaviour sellingBehaviour = new SellingBehaviour();
		Behaviour scanningBehaviour = new ScanningBehaviour();

		// Configuration of the states
		buyingBehaviour.setDataStore(getDataStore());
		sellingBehaviour.setDataStore(getDataStore());
		scanningBehaviour.setDataStore(getDataStore());

		// Register of states
		addSubBehaviour(scanningBehaviour);
		addSubBehaviour(buyingBehaviour);
		addSubBehaviour(sellingBehaviour);

		log.info("Trader behaviour initializaton finished");
	}

	public int onEnd() {
		reset();
		myAgent.addBehaviour(this);
		return super.onEnd();
	}

}