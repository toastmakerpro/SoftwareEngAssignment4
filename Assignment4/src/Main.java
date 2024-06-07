import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Defining first post information
        int postID = 1;
        String postTitle = "Does anyone know how to reverse a string in Java?";
        String postBody = "For one of my Java homework questions this week I need to take in a string of characters and reverse the order of it, ";
        postBody = postBody + "Ive tried everything but I cant get it to work. Does anybody have any ideas on what I should do? It's due tomorrow!!!!";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";
        postBody = postBody + "Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250Words to get the word count up to 250";

        String[] postTags = {"java", "strings", "arrays"};
        String difficulty = "Easy";
        String postEmergency = "Ordinary";

        Post post1 = new Post(postID, postTitle, postBody, postTags, difficulty, postEmergency); //Creating post object

        if (post1.addPost() == true) { //Adding the post
            System.out.println("Post added!");
        }
        else if (post1.addPost() == false) { //If boolean false then error
            System.out.println("Issues with post, not added");
        }

        String comment1 = "Im not sure im not very good at java sorry";
        if (post1.addComment(comment1) == true) { //Test comment
            System.out.println("Comment added to: Post " + postID);
        }
        else if (post1.addComment(comment1) == false) { //Fail test comment
            System.out.println("Issues with comment, not added");
        }

    }
}