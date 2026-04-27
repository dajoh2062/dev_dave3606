package a_exam;

import java.util.ArrayList;
import java.util.List;

class BlogPost{
    private final String title;
    private final String content;

    public BlogPost (String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}

class Blog {
    private final String title;
    private final List<BlogPost> posts;
    
    // +
    private List<BlogObserver> observers = new ArrayList<>();

    public Blog (String title){
        this.title=title;
        this.posts = new ArrayList<>();


    }

    public void publish (BlogPost post){
        posts.add(post);

        // +
        for (BlogObserver observer: observers){
            observer.observeBlogPost(title,post);
        }
        
    }
    
    // +
    public void addObserver (BlogObserver observer){
        observers.add(observer);
    }

}

// +
interface BlogObserver{
    void observeBlogPost(String blogTitle, BlogPost blogPost);
}


class BlogReader implements BlogObserver{
    private final String name;

    public BlogReader(String name){
        this.name=name;
    }

    public void observeBlogPost(String blogTitle, BlogPost blogPost){
        System.out.println(
            name + " leser bloggposten " +
            blogPost.getTitle() + " fra " + blogTitle +
            " med innholdet " + blogPost.getContent()
        );
    }

}

// +
public class ObserverPattern {
    public static void main(String[] args) {

        // Opprett en blogg
        Blog blog = new Blog("TechBlog");

        // Opprett noen lesere (observers)
        BlogReader reader1 = new BlogReader("Yngve");
        BlogReader reader2 = new BlogReader("Ola");
        BlogReader reader3 = new BlogReader("Kari");

        // Registrer leserne som observers
        blog.addObserver(reader1);
        blog.addObserver(reader2);
        blog.addObserver(reader3);

        // Publiser bloggposter
        BlogPost post1 = new BlogPost(
            "Observer Pattern i Java",
            "Dette er en introduksjon til observer-patternet."
        );

        BlogPost post2 = new BlogPost(
            "Design Patterns",
            "I dag ser vi på flere design patterns."
        );

        blog.publish(post1);
        blog.publish(post2);
    }
}
