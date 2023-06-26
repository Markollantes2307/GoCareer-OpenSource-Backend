package goodstart.gocareer.services.impl;

import goodstart.gocareer.models.Date;
import goodstart.gocareer.repositories.DateRepository;
import goodstart.gocareer.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateServiceImpl implements DateService {
    @Autowired
    private DateRepository dateRepository;
    @Override
    public Date createDate(Date date) {
        return dateRepository.save(date);
    }
}
