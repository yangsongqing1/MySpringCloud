package ysq.com.app.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseController {
    protected Log log = LogFactory.getLog(this.getClass());
}
