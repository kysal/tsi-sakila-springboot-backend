package UIElements.theSoftwareInstitute.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Ignore;

@Ignore
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwsSecrets {
    private String username;
    private String password;
    private String host;
    private String engine;
    private String port;
    private String dbInstanceIdentifier;
}
