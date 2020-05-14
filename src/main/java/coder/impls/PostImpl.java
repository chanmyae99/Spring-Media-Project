package coder.impls;

import coder.daos.PostDao;
import coder.models.Posts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostImpl implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addPost(Posts post) {
        session().save(post);
        session().flush();
    }

    @Override
    public List<Posts> getAllPost() {
        Query query = session().createQuery("from Posts");
        List<Posts> posts = query.list();
        session().flush();
        return posts;
    }

    @Override
    public Posts getPostById(int id) {
        Posts post = session().get(Posts.class, id);
        session().flush();
        return post;
    }

    @Override
    public void updatePost(Posts post) {
        session().saveOrUpdate(post);
        session().flush();
    }

    @Override
    public void deletePost(int id) {
        session().delete(getPostById(id));
        session().flush();
    }
}
