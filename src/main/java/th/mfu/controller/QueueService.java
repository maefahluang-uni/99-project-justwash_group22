package th.mfu.controller;

import org.springframework.stereotype.Service;

import th.mfu.domain.Queue;
import th.mfu.repository.QueueRepository;

@Service
public class QueueService {

    private final QueueRepository queueRepository;

    // Inject the QueueRepository via constructor injection
    public QueueService(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    public Queue getQueueById(Long id) {
        return queueRepository.findById(id).orElse(null);
    }

    public void saveQueue(Queue queue) {
        queueRepository.save(queue);
    }

    // Other methods related to QueueService based on your requirements

}

