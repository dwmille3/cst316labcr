package banking.primitive.core;

/**
  File:	AccountServerFactory.java
  Author:   ??
  Date:	2/19/2016
  Description: Used to create and properly initialize account servers.
*/

/**
  Class:	AccountServerFactory
  Description: An account server factory that wraps around a singleton.
*/
public class AccountServerFactory {

	protected static AccountServerFactory singleton = null;

	protected AccountServerFactory() {

	}

	public static AccountServerFactory getMe() {
		if (singleton == null) {
			singleton = new AccountServerFactory();
		}

		return singleton;
	}

    /**
        Method: lookup
        Returns: AccountServer
        Description: Returns a new instance of ServerSolution.
    */
	public AccountServer lookup() {
		return new ServerSolution();
	}
}
