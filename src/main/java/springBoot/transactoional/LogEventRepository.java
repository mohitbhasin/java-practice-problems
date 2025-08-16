package springBoot.transactoional;

import org.springframework.data.repository.CrudRepository;

public interface LogEventRepository extends CrudRepository<LogEvent, Integer> {
}
