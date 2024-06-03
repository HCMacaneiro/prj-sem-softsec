package Model;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;

import java.util.HashMap;
import java.util.Map;

public class Authenticate {
    private static String USER_POOL_ID = "us-east-2_vSmEHFF6q";
    private static String CLIENT_ID = "7c7lbnjf8htdiasj52p2uh6q6a";
    private InitiateAuthResult authResponse;
    private AuthenticationResultType authResult;
    public Authenticate(String email, String senha) {
        AWSCognitoIdentityProvider awsc;
        try {
            if (!isValidEmail(email)) {
                throw new IllegalArgumentException("Formato de e-mail inválido.");
            }
            awsc = AWSCognitoIdentityProviderClientBuilder.standard()
                    .withRegion(Regions.US_EAST_2)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Erro com AWS Cognito: " + e.getMessage());
            return;
        }

        Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", email);
        authParams.put("PASSWORD", senha);

        InitiateAuthRequest authRequest = new InitiateAuthRequest()
                .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                .withAuthParameters(authParams)
                .withClientId(CLIENT_ID);

        try {
            authResponse = awsc.initiateAuth(authRequest);
            authResult = authResponse.getAuthenticationResult();
        } catch (AWSCognitoIdentityProviderException e) {
            System.out.println("Autenticação falhou: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro na autenticação: " + e.getMessage());
        }
    }

    public boolean authenticate() {
        return authResult != null;
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";
        return email.matches(regex);
    }
}
