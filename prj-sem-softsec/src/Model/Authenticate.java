package Model;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;
import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidp.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.InitiateAuthResult;

import java.util.HashMap;
import java.util.Map;

public class Authenticate {
    private static String USER_POOL_ID = "us-east-2_vSmEHFF6q";
    private static String CLIENT_ID = "7c7lbnjf8htdiasj52p2uh6q6a";
    private InitiateAuthResult authResponse;
    private AuthenticationResultType authResult;
    public Authenticate(String email, String senha) {
        AWSCognitoIdentityProvider awsc = AWSCognitoIdentityProviderClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .build();

        Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", email);
        authParams.put("PASSWORD", senha);

        InitiateAuthRequest authRequest = new InitiateAuthRequest()
                .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                .withAuthParameters(authParams)
                .withClientId(CLIENT_ID);

        authResponse = awsc.initiateAuth(authRequest);
        authResult = authResponse.getAuthenticationResult();
    }
    public boolean authenticate() {
        return (authResult != null);
    }
}
