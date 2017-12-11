package wang.hafuhafu.model;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private long id;
    private String email;
    private String password;
    private String username;
    private String role;
    private int status;
    private Date regTime;
    private String regIp;
}
