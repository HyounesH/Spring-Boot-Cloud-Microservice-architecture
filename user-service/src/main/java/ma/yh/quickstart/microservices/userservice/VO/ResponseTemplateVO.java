package ma.yh.quickstart.microservices.userservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yh.quickstart.microservices.userservice.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private User user;
    private Department department;

    public static ResponseTemplateVO of(User user, Department department) {
        return new ResponseTemplateVO(user, department);
    }
}
