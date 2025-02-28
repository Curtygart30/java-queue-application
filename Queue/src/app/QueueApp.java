package app;

import model.Task;
import service.TaskQueueService;
import java.util.Scanner;

public class QueueApp {
    public static void main(String args[]){
        TaskQueueService queueService = new TaskQueueService();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while(choice != 4) {
            System.out.println("==Task Menu==");
            System.out.println("1. Add a task");
            System.out.println("2. List all tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter task ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter description: ");
                    String description = input.nextLine();
                    Task task = new Task(id, description);
                    queueService.enqueue(task);
                    System.out.println("Task Added");
                    break;
                case 2:
                    System.out.println("All task currently in queue: ");
                    for (Task t: queueService.listTasks()){
                        System.out.println(t);
                    }
                    break;
                case 3:
                    Task removedTask = queueService.dequeue();
                    if(removedTask != null) {
                        System.out.println("Removed Task: " + removedTask);
                    }
                    else {
                        System.out.println("No task to remove");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Application");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    input.close();
    }
}
