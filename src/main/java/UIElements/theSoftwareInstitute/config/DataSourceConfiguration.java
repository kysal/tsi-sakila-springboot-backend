package UIElements.theSoftwareInstitute.config;


import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
 import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
 import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
 import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfiguration {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource() {
        AwsSecrets secrets = getSecret();
        return DataSourceBuilder
                .create()
//                .driverClassName("com.mysql.cj.jdbc.driver")
                .url("jdbc:" + secrets.getEngine() + "://" + secrets.getHost() + ":" + secrets.getPort() + "/sakila")
                .username(secrets.getUsername())
                .password(secrets.getPassword())
                .build();
    }



     private AwsSecrets getSecret() {

        String secretName = "Applications/tsi/MySQL-RDS-Database";
        Region region = Region.of("us-east-1");

        AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));
        SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();

        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;

        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            throw e;
        }

        String secret = getSecretValueResponse.secretString();
        return gson.fromJson(secret, AwsSecrets.class);
    }
}