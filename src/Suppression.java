import java.util.ArrayList;

public class Suppression extends Thread{
	
	ArrayList<String> aList = new ArrayList<String>();
	ArrayList<String> bList = new ArrayList<String>();
	ArrayList<String> cList = new ArrayList<String>();
	ArrayList<String> dList = new ArrayList<String>();
	ArrayList<String> eList = new ArrayList<String>();
	ArrayList<String> fList = new ArrayList<String>();
	ArrayList<String> gList = new ArrayList<String>();
	ArrayList<String> hList = new ArrayList<String>();
	ArrayList<String> iList = new ArrayList<String>();
	ArrayList<String> jList = new ArrayList<String>();
	ArrayList<String> kList = new ArrayList<String>();
	ArrayList<String> lList = new ArrayList<String>();
	ArrayList<String> mList = new ArrayList<String>();
	ArrayList<String> nList = new ArrayList<String>();
	ArrayList<String> oList = new ArrayList<String>();
	ArrayList<String> pList = new ArrayList<String>();
	ArrayList<String> qList = new ArrayList<String>();
	ArrayList<String> rList = new ArrayList<String>();
	ArrayList<String> sList = new ArrayList<String>();
	ArrayList<String> tList = new ArrayList<String>();
	ArrayList<String> uList = new ArrayList<String>();
	ArrayList<String> vList = new ArrayList<String>();
	ArrayList<String> wList = new ArrayList<String>();
	ArrayList<String> xList = new ArrayList<String>();
	ArrayList<String> yList = new ArrayList<String>();
	ArrayList<String> zList = new ArrayList<String>();
	ArrayList<String> charList = new ArrayList<String>();
	
	
	//constructor
	public Suppression(ArrayList<String> list) {
		for (int x = 0; x < list.size(); x++) {
			String temp = list.get(x).substring(0, 1);
			String tempEmail = list.get(x);
			switch (temp) {
			case "a":
				aList.add(tempEmail);
				break;
			case "b":
				bList.add(tempEmail);
				break;
			case "c":
				cList.add(tempEmail);
				break;
			case "d":
				dList.add(tempEmail);
				break;
			case "e":
				eList.add(tempEmail);
				break;
			case "f":
				fList.add(tempEmail);
				break;
			case "g":
				gList.add(tempEmail);
				break;
			case "h":
				hList.add(tempEmail);
				break;
			case "i":
				iList.add(tempEmail);
				break;
			case "j":
				jList.add(tempEmail);
				break;
			case "k":
				kList.add(tempEmail);
				break;
			case "l":
				lList.add(tempEmail);
				break;
			case "m":
				mList.add(tempEmail);
				break;
			case "n":
				nList.add(tempEmail);
				break;
			case "o":
				oList.add(tempEmail);
				break;
			case "p":
				pList.add(tempEmail);
				break;
			case "q":
				qList.add(tempEmail);
				break;
			case "r":
				rList.add(tempEmail);
				break;
			case "s":
				sList.add(tempEmail);
				break;
			case "t":
				tList.add(tempEmail);
				break;
			case "u":
				uList.add(tempEmail);
				break;
			case "v":
				vList.add(tempEmail);
				break;
			case "w":
				wList.add(tempEmail);
				break;
			case "x":
				xList.add(tempEmail);
				break;
			case "y":
				yList.add(tempEmail);
				break;
			case "z":
				zList.add(tempEmail);
				break;
			default:
				charList.add(tempEmail);
				break;
			}
		}
	}
	
	public Suppression(Suppression copier) {
		this.aList = new ArrayList<String>(copier.aList);
		this.bList = new ArrayList<String>(copier.bList);
		this.cList = new ArrayList<String>(copier.cList);
		this.dList = new ArrayList<String>(copier.dList);
		this.eList = new ArrayList<String>(copier.eList);
		this.fList = new ArrayList<String>(copier.fList);
		this.gList = new ArrayList<String>(copier.gList);
		this.hList = new ArrayList<String>(copier.hList);
		this.iList = new ArrayList<String>(copier.iList);
		this.jList = new ArrayList<String>(copier.jList);
		this.kList = new ArrayList<String>(copier.kList);
		this.lList = new ArrayList<String>(copier.lList);
		this.mList = new ArrayList<String>(copier.mList);
		this.nList = new ArrayList<String>(copier.nList);
		this.oList = new ArrayList<String>(copier.oList);
		this.pList = new ArrayList<String>(copier.pList);
		this.qList = new ArrayList<String>(copier.qList);
		this.rList = new ArrayList<String>(copier.rList);
		this.sList = new ArrayList<String>(copier.sList);
		this.tList = new ArrayList<String>(copier.tList);
		this.uList = new ArrayList<String>(copier.uList);
		this.vList = new ArrayList<String>(copier.vList);
		this.wList = new ArrayList<String>(copier.wList);
		this.xList = new ArrayList<String>(copier.xList);
		this.yList = new ArrayList<String>(copier.yList);
		this.zList = new ArrayList<String>(copier.zList);
		this.charList = new ArrayList<String>(copier.charList);
	}
	
	/*Thread t1 = new Thread() {
		public void run() {
			
		}
	};*/
	
	private String to;
	public Suppression(String to) {
		this.to= to;
	}
	
	public void run() {
		System.out.println("hello" + to);
	}
	
	public int dupeLists (Suppression list) {
		int returning = 0;
		
		Suppression temp1 = new Suppression(this);
		Suppression temp2 = new Suppression(list);
		
		//temp1.aList.removeAll(temp2.aList);
		new Suppression("world!").start();
	
		return returning;
	}
	
}
