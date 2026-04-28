package exam_summary;


interface SocialMedia{
    void publishPost(String content);
}

class Facebook implements SocialMedia{
    @Override
    public void publishPost(String content){
        System.out.println("Publishing to Facebook" + content);
    }
}

class Twitter implements SocialMedia{
    public void publishPost(String content){
        System.out.println("Publishing to Twitter" + content);
    }
}

// +
class PostCounter implements SocialMedia{
    private int count;
    private final SocialMedia sm;

    public PostCounter (SocialMedia sm){
        this.count=0;
        this.sm=sm;
    }


    @Override
    public void publishPost(String content){
        sm.publishPost(content);
        count++;
    }

    public int getPostCount(){
        return count;
    }
}


public class Decorator{

    public static void main(String[] args) {

        Facebook fb = new Facebook();
        Twitter x = new Twitter();

        PostCounter fbCounter = new PostCounter(fb);
        PostCounter xCounter = new PostCounter(x);
        PostCounter counterCounter = new PostCounter(xCounter);

        fbCounter.publishPost("hi facebook");
        xCounter.publishPost("Hi twitter");
        xCounter.publishPost("Hi twitter again");
        counterCounter.publishPost(" hi from Counter");

        

    

        
    }

}