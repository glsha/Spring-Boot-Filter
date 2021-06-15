package com.example.SpringBootFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TopicController {
    @Autowired
    private TopicService topicService;

    //GET api to get the list of all topics
    @RequestMapping("/topics")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    //Get api to retrieve a individual id
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    //POST to add new topic
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    //PUT request
    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    //DELETE request
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
