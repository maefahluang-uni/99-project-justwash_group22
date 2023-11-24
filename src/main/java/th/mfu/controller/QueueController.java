package th.mfu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import th.mfu.domain.Queue;

@Controller
@RequestMapping("/queues")
public class QueueController {

    private final QueueService queueService;

    // Inject the QueueService via constructor injection
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping("/{queueId}/updateStatus")
    public String updateStatus(@PathVariable Long queueId, @RequestParam String status) {
        Queue queue = queueService.getQueueById(queueId);
        if (queue != null) {
            queue.setW_status(status);
            queueService.saveQueue(queue); // Assuming you have a method to save/update the queue

            // Redirect to a success page or any appropriate page
            return "redirect:/machines"; // Redirect to the queue details page or another relevant page
        } else {
            // Handle error when queue is not found
            return "redirect:/machines"; // Redirect to an error page
        }
    }
}



