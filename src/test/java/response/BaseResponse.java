package response;

import lombok.Data;

@Data
public class BaseResponse <T>{

    T data;
}
