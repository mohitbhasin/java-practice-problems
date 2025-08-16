package springBoot.transactoional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class LogEventService {
    @Autowired
    LogEventRepository logEventRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void logSaveEvent(Orders order, Product product) {
        LogEvent logEvent = new LogEvent();
        logEvent.setMessage("Request for "+product.name+" with quantity = "+order.quantity);
        logEvent.setTimestamp(new Date());
        logEventRepository.save(logEvent);
    }
}
