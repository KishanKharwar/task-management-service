//package com.jaza.software.tms.services;
//
//import com.jaza.software.tms.entities.LabelEntity;
//import com.jaza.software.tms.entities.TaskEntity;
//import com.jaza.software.tms.models.Priority;
//import com.jaza.software.tms.repositories.TaskRepository;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
////@Component
//public class DBOperationRunner implements CommandLineRunner {
//
//  private TaskRepository repository;
//
//  @Override
//  public void run(String... args) throws Exception {
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    Calendar c = Calendar.getInstance();
//    c.setTime(new Date()); // Using today's date
//    c.add(Calendar.DATE, 2); // Adding 5 days
//
//    Date date = new Date();
//    Timestamp timestamp = new Timestamp(date.getTime());
//    List<LabelEntity> labelEntities = new ArrayList<>();
//    List<TaskEntity> tasks = new ArrayList<>();
//    labelEntities.add(new LabelEntity("project1"));
//    tasks.add(new TaskEntity("create api", Priority.CRITICAL,2,timestamp,labelEntities));
//
//
//    List<LabelEntity> labelEntities1 = new ArrayList<>();
//    List<TaskEntity> tasks1 = new ArrayList<>();
//    Calendar deadLine5 = Calendar.getInstance();
//    c.setTime(new Date()); // Using today's date
//    c.add(Calendar.DATE, 5); // Adding 5 days
//    labelEntities1.add(new LabelEntity("project2"));
//    tasks1.add(new TaskEntity("create api", Priority.CRITICAL,3,timestamp,labelEntities1));
//
//
//    List<LabelEntity> labelEntities2 = new ArrayList<>();
//    List<TaskEntity> tasks2 = new ArrayList<>();
//    Calendar deadLine3 = Calendar.getInstance();
//    c.setTime(new Date()); // Using today's date
//    c.add(Calendar.DATE, 3); // Adding 5 days
//    labelEntities2.add(new LabelEntity("project1"));
//    labelEntities2.add(new LabelEntity("project2"));
//    tasks2.add(new TaskEntity("create api", Priority.CRITICAL,5,timestamp,labelEntities2));
//
//      repository.saveAll(Arrays.asList(
//          new TaskEntity("create api", Priority.CRITICAL,c,timestamp,labelEntities),
//          new TaskEntity("update api", Priority.MEDIUM,c,timestamp,labelEntities),
//          new TaskEntity("delete api", Priority.HIGH,c,timestamp,labelEntities1),
//          new TaskEntity("get api", Priority.CRITICAL,c,timestamp,labelEntities),
//          new TaskEntity("swagger api", Priority.LOW,c,timestamp,labelEntities2)
//      ));
//  }
//
//  @Autowired
//  public void setRepository(TaskRepository repository) {
//    this.repository = repository;
//  }
//}
