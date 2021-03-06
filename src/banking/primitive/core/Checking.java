package banking.primitive.core;

/**
  File:	Checking.java
  Author:	??
  Date:	2/19/2016
  Description: A specific type of account separate from savings.
*/

/**
  Class:	Checking
  Description: Child class of Account.
*/
public class Checking extends Account {

	private static final long serialVersionUID = 11L;
	private int numWithdraws = 0;

	private Checking(String name) {
		super(name);
	}

    public static Checking createChecking(String name) {
        return new Checking(name);
    }

	public Checking(String name, float balance) {
		super(name, balance);
	}

	/**
	 * A deposit may be made unless the Checking account is closed
	 * @param float is the deposit amount
	 */
	public boolean deposit(float amount) {
        boolean deposited = false;
		
		if (getState() != State.CLOSED && amount > 0.0f) {
			balance = balance + amount;
			if (balance >= 0.0f) {
				setState(State.OPEN);
			}
			deposited = true;
		}
		
		return deposited;
	}

	/**
	 * Withdrawal. After 10 withdrawals a fee of $2 is charged per transaction You may
	 * continue to withdraw an overdrawn account until the balance is below -$100
	 */
	public boolean withdraw(float amount) {
        boolean withdrawn = false;
		
		if (amount > 0.0f) {
			// KG: incorrect, last balance check should be >=
			if (getState() == State.OPEN || (getState() == State.OVERDRAWN && balance > -100.0f)) {
				balance = balance - amount;
				numWithdraws++;
				if (numWithdraws > 10)
					balance = balance - 2.0f;
				if (balance >= 0.0f) {
					setState(State.OVERDRAWN);
				}
				withdrawn = true;
			}
		}
		
		return withdrawn;
	}

	public String getType() { return "Checking"; }

	public String toString() {
		return "Checking: " + getName() + ": " + getBalance();
	}
}
