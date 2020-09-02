
package bookRental.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="confirm", url="${api.url.confirm}")
public interface ConfirmService {

    @RequestMapping(method= RequestMethod.POST, path="/confirms")
    public void makeConfirm(@RequestBody Confirm confirm);

}