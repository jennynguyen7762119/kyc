/**
 * 
 */
package com.oto.kyc.model.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thuyntp
 *
 */
public class CurrentUserGetter {
	private static CurrentUserGetter instance = new CurrentUserGetter();
    private List<CurrentUserGetterStrategy> currentUserGetterStrategies = new ArrayList<CurrentUserGetterStrategy>();

    private CurrentUserGetter() {
        currentUserGetterStrategies.add(new DefaultCurrentUserGetterStrategy());
    }

    /**
     * Singleton method.
     * 
     * @return the instance
     */
    public static CurrentUserGetter getInstance() {
        return instance;
    }

    /**
     * Get current login username.
     * 
     * @return current user by strategy chain.
     */
    public int getCurrentUser() {
        int result = 0;
        for (CurrentUserGetterStrategy strategy : currentUserGetterStrategies) {
            result = strategy.getCurrentUser();
            if (result > 0) {
                break;
            }
        }

        return result;
    }
    
    public void addCurrentUserGetterStrategy(CurrentUserGetterStrategy strategy) {
        currentUserGetterStrategies.add(strategy);
    }

    public void insertCurrentUserGetterStrategy(CurrentUserGetterStrategy strategy) {
        currentUserGetterStrategies.add(0, strategy);
    }
}
