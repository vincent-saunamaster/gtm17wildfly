package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculatrice
 */
@Stateless
@LocalBean
public class Calculatrice implements CalculatriceRemote, CalculatriceLocal {

	/**
	 * Default constructor.
	 */
	public Calculatrice() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int multiplication(int x, int y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	@Override
	public int addition(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public int soustraction(int x, int y) {
		// TODO Auto-generated method stub
		return x - y;
	}

	@Override
	public int division(int x, int y) {
		// TODO Auto-generated method stub
		if(y!=0){
		return x / y;
		}
		System.out.println("pas de division par 0 !");
		return 0;
	}

}
