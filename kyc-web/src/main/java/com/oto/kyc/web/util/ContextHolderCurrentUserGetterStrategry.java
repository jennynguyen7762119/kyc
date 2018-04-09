/**
 * 
 */
package com.oto.kyc.web.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.oto.kyc.model.util.CurrentUserGetterStrategy;
import com.oto.kyc.web.security.SessionInfo;

/**
 * @author thuyntp
 *
 */
public class ContextHolderCurrentUserGetterStrategry implements CurrentUserGetterStrategy {

	public int getCurrentUser() {
		int result = 0;
		SessionInfo sessionInfo = this.getSessionInfo();
		if (sessionInfo != null) {
			result = sessionInfo.getUser().getId();
		}
		return result;
	}

	private SessionInfo getSessionInfo() {
        SessionInfo info = null;
        try {
            info = (SessionInfo) RequestContextHolder.currentRequestAttributes()
                    .getAttribute(KycRequestUtils.KYC_SESSION_INFO_KEY, RequestAttributes.SCOPE_SESSION);
        } catch (Exception ex) {
            // do nothing
        }
        
        return info;
    }
    
}
