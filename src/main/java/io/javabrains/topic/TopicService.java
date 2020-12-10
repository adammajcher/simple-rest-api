package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Course> topics = new ArrayList<>(Arrays.asList(
//            new Course("spring", "Spring Framework", "Spring Framework Description"),
//            new Course("java", "Core Java", "Core Java Description"),
//            new Course("javascript", "JavaScript", "JavaScript Description"),
//            new Course("javaee", "Enterprise Java", "Enterprise Java Description"),
//            new Course("python", "Python", "Python Description")
//    ));

//    public List<Course> getWantedTopics(int paddingStart, int paddingStop) {
//        List<Course> topicsWanted = new ArrayList<>();
//        for (int i = 0; i < topics.size(); i++) {
//            if (i >= paddingStart && i <= paddingStop) {
//                topicsWanted.add(topics.get(i));
//            }
//        }
//        return topicsWanted;
//    }

    public List<Topic> getAllTopic() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).orElse(null);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }

}
