package ru.ecosystem.dreamjob.app.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.ecosystem.dreamjob.app.model.WorkingMode;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
@Repository
public class WorkingModeRepository {

    private final Map<Long, WorkingMode> modes = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        modes.put(1L, new WorkingMode(1L, WorkingMode.Type.HYBRID));
        modes.put(2L, new WorkingMode(2L, WorkingMode.Type.IN_THE_OFFICE));
        modes.put(3L, new WorkingMode(3L, WorkingMode.Type.REMOTELY));
    }

    public WorkingMode getById(long id) {
        return modes.get(id);
    }

    public List<WorkingMode> findAll() {
        return new ArrayList<>(modes.values());
    }
}
