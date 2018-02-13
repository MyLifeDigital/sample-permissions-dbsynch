package io.consentric.connector.service;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isEmpty;


@Component
public class Auth0Service {

    private static final String CLIENT_ID_PROP = "consentric.auth0.clientId";
    private static final String CLIENT_SECRET_PROP = "consentric.auth0.clientSecret";
    private static final String DOMAIN_PROP = "consentric.auth0.domain";
    private static final String AUDIENCE_PROP = "consentric.auth0.audience";

    private final String clientId;
    private final String clientSecret;
    private final String domain;
    private final String audience;

    private final AuthAPI authAPI;

    @Autowired
    public Auth0Service(@Value("${" + CLIENT_ID_PROP + "}") String clientId,
                        @Value("${" + CLIENT_SECRET_PROP + "}") String clientSecret,
                        @Value("${" + DOMAIN_PROP + "}") String domain,
                        @Value("${" + AUDIENCE_PROP + "}") String audience) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.domain = domain;
        this.audience = audience;

        verifyParams();
        authAPI = new AuthAPI(domain, clientId, clientSecret);
    }

    public String getJwtToken() throws Auth0Exception {
        return authAPI.requestToken(audience).execute().getAccessToken();
    }

    private void verifyParams() {
        verifyParam(CLIENT_ID_PROP, clientId);
        verifyParam(CLIENT_SECRET_PROP, clientSecret);
        verifyParam(DOMAIN_PROP, domain);
        verifyParam(AUDIENCE_PROP, audience);
    }

    private void verifyParam(String paramName, String paramValue) {
        if (isEmpty(paramValue)) {
            throw new InvalidPropertyException(Auth0Service.class, paramName, "Cannot be empty.");
        }
    }
}
