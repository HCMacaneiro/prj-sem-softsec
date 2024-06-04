package Model;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AWSCognitoIdentityProviderException;
import com.amazonaws.services.cognitoidp.model.SignUpRequest;
import com.amazonaws.services.cognitoidp.model.SignUpResult;

public class SignUp {
    private String USER_POOL_ID = "us-east-2_vSmEHFF6q";
    private String CLIENT_ID = "7c7lbnjf8htdiasj52p2uh6q6a";
    private SignUpResult result;

    public SignUp(String email, String senha) {
        AWSCognitoIdentityProvider awsc;
        try {
            if (!isValidEmail(email)) {
                throw new IllegalArgumentException("Formato de e-mail inválido.");
            }
            awsc = AWSCognitoIdentityProviderClientBuilder.standard()
                    .withRegion(Regions.US_EAST_2)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Erro com AWS Cognito: " + e.getMessage());
            return;
        }

        SignUpRequest sur = new SignUpRequest()
                .withClientId(CLIENT_ID)
                .withUsername(email)
                .withPassword(senha);

        try {
            result = awsc.signUp(sur);
        } catch (AWSCognitoIdentityProviderException e) {
            System.out.println("Cadastro falhou: " + e.getErrorCode() + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro durante cadastro: " + e.getMessage());
        }
    }

    public boolean signUp() {
        return result != null;
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";
        return email.matches(regex);
    }
}