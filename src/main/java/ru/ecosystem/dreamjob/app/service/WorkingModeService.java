package ru.ecosystem.dreamjob.app.service;

import lombok.RequiredArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecosystem.dreamjob.app.model.WorkingMode;
import ru.ecosystem.dreamjob.app.repository.WorkingModeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ThreadSafe
public class WorkingModeService {

    private final WorkingModeRepository workingModeRepository;

    public List<WorkingMode> findAll() {
        return workingModeRepository.findAll();
    }

    public WorkingMode getById(long id) {
        return workingModeRepository.getById(id);
    }
}
