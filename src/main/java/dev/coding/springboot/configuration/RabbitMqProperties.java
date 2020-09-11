package dev.coding.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties("rabbitmq")
public class RabbitMqProperties {

    @NotNull
    private String exchangeName;

    @Valid
    private TasksReceived tasksReceived = new TasksReceived();

    @Valid
    private TasksDeadLetter tasksDeadLetter = new TasksDeadLetter();

    public static class TasksReceived extends Entry { }

    public static class TasksDeadLetter extends Entry { }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public Entry getTasksReceived() {
        return tasksReceived;
    }

    public void setTasksReceived(TasksReceived tasksReceived) {
        this.tasksReceived = tasksReceived;
    }

    public Entry getTasksDeadLetter() {
        return tasksDeadLetter;
    }

    public void setTasksDeadLetter(TasksDeadLetter tasksDeadLetter) {
        this.tasksDeadLetter = tasksDeadLetter;
    }

    @Validated
    public static class Entry {

        @NotNull
        private String queueName;

        @NotNull
        private String routingKey;

        public String getQueueName() {
            return queueName;
        }

        public void setQueueName(String queueName) {
            this.queueName = queueName;
        }

        public String getRoutingKey() {
            return routingKey;
        }

        public void setRoutingKey(String routingKey) {
            this.routingKey = routingKey;
        }
    }
}
