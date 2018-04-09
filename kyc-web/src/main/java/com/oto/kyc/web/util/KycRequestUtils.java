/**
 * 
 */
package com.oto.kyc.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oto.kyc.web.security.SessionInfo;


/**
 * @author thuyntp
 *
 */
public class KycRequestUtils {
	public static final String KYC_SESSION_INFO_KEY = "SESSION_INFO";

    private static KycRequestUtils instance = new KycRequestUtils();

    /**
     * Private default constructor.
     */
    private KycRequestUtils() {
    }

    /**
     * Singleton method.
     * 
     * @return the instance
     */
    public static KycRequestUtils getInstance() {
        if (instance == null) {
            instance = new KycRequestUtils();
        }

        return instance;
    }

    /**
     * Get {@link SessionInfo} from HttpServletRequest.
     * 
     * @param request
     *            {@link HttpServletRequest}
     * @return {@link SessionInfo} object or null
     */
    public SessionInfo getSessionInfo(HttpServletRequest request) {
        return (SessionInfo) getSession(request).getAttribute(KYC_SESSION_INFO_KEY);
    }

    /**
     * Set {@link SessionInfo} instance into Session get from {@link HttpServletRequest}.
     * 
     * @param request
     *            {@link HttpServletRequest}
     * @param sessionInfo
     *            {@link SessionInfo}
     */
    public void setSessionInfo(HttpServletRequest request, SessionInfo sessionInfo) {
        request.getSession(true).setAttribute(KYC_SESSION_INFO_KEY, sessionInfo);
    }

    /**
     * Retrieve {@link HttpSession} object.
     * 
     * @param request {@link HttpServletRequest} object
     * @return {@link HttpSession}
     */
    public HttpSession getSession(HttpServletRequest request) {
        return request.getSession(true);
    }
}
