package coder.daos;

import coder.models.Posts;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface PostDao {
    void addPost(Posts post);
    List<Posts> getAllPost();
    Posts getPostById(int id);
    void updatePost(Posts post);
    void deletePost(int id);
}
