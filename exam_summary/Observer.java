package exam_summary;

import java.util.ArrayList;
import java.util.List;

class BlogPost{
    private final String title;
    private final String content;

    public BlogPost(String title, String content){
        this.title=title;
        this.content=content;
    }
    public String getTitle() {
        return title;
    }

    public String getContent(){
        return content;
    }

}

class Blog{
    private final String title;
    private final List<BlogPost> posts;
    
    public Blog(String title){
        this.title=title;
        this.posts=new ArrayList<>();
    }
    public void publish (BlogPost post){
        posts.add(post);
        //+
        for(BlogObserver observer : observers){
            observer.observeBlog(title, post);
        }
    }

    //+
    private final List<BlogObserver> observers = new ArrayList<>();

    public void addObserver(BlogObserver observer){
        observers.add(observer);
    }

    public void deleteObserver (BlogObserver observer){
        observers.remove(observer);
    }
   
}

//+
interface BlogObserver{
    void observeBlog(String blogTitle, BlogPost blog);

}

//+
class BlogReader implements BlogObserver{
    private final String name;

    public BlogReader(String name){
        this.name=name;
    }

    @Override
    public void observeBlog(String blogTitle, BlogPost blog){
        System.out.println("Observerd blogpost with title: " + blog.getTitle() + " and content: "  + blog.getContent() 
        + " from observer " + this.name);

    }
    

}

public class Observer {
    public static void main(String[] args) {
        // ++
        Blog blog = new Blog("avis");
        blog.addObserver(new BlogReader("Leser"));
    }
}
