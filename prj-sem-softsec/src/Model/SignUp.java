package Model;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.SignUpRequest;

public class SignUp {
    private String USER_POOL_ID = "us-east-2_vSmEHFF6q";
    private String CLIENT_ID = "7c7lbnjf8htdiasj52p2uh6q6a";

    public SignUp(String email, String senha) {
        AWSCognitoIdentityProvider awsc = AWSCognitoIdentityProviderClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .build();

        SignUpRequest sur = new SignUpRequest().withClientId(CLIENT_ID)
                .withUsername(email)
                .withPassword(senha);

        awsc.signUp(sur);

    }
}