package coder.services;

import coder.daos.PostDao;
import coder.models.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao postDao;

    public void addPost(Posts post){
        postDao.addPost(post);
    }

    public List<Posts> getAllPosts(){
        return postDao.getAllPost();
    }

    public Posts getPostById(int id){
        return postDao.getPostById(id);
    }

    public void updatePost(Posts post){
        postDao.updatePost(post);
    }

    public void deletePost(int id){
        postDao.deletePost(id);
    }
}
