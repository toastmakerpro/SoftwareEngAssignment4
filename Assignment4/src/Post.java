import java.util.*;
import java.io.*;

public class Post {
    private int postID;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String difficulty;  //= {"Very Difficult", "Difficult", "Easy"};
    private String postEmergency; //= {"Immediately Needed", "Highly Needed", "Ordinary"};
    private ArrayList<String> postComments = new ArrayList<>();

    public Post(int postID, String postTitle, String postBody, String[] postTags, String difficulty, String postEmergency) { //Defining post object
        this.postID = postID;
        this.postTitle = postTitle;
        this.postBody = postBody;
        this.postTags = postTags;
        this.difficulty = difficulty;
        this.postEmergency = postEmergency;
    }

    public boolean addPost() throws IOException //Main addPost function for adding a new post
    {
        // TODO Add the information of a post to a TXT file
        // If the post's information meets the following conditions,
        // the information should be added to a TXT file (e.g., post.txt), and the addPost function should return true.
        // If the post's information does not meet the following conditions,
        // the information should not be added to the TXT file, and the addPost function should return false.
        if (postTitle.length() < 10) return false; //Post length checks
        if (postTitle.length() > 250) return false;

        String postTitleFirstFive = postTitle.substring(0, 5); //First five characters in title must be valid
        if (postTitleFirstFive.matches(".*\\d.*")) return false;
        if (postTitleFirstFive.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) return false;

        if (postBody.length() < 250) return false; //Length of body more than 250

        if (postTags.length < 2) return false; //Amount of tags checking
        if (postTags.length > 5) return false;
        for (String i : postTags) {
            if (i.length() < 2) return false; //Checking each tag has valid amount and type of characters
            if (i.length() > 10) return false;
            if (i.matches(".*[A-Z].*")) return false;
        }
        if (difficulty == "Easy" && postTags.length > 3) return false; //Checking for too many tags with easy post type
        if (difficulty == "Very Difficult" && postBody.length() < 300) return false; //Not enough characters for very difficult
        if (difficulty == "Difficult" && postBody.length() < 300) return false; //Same for difficult

        if (difficulty == "Easy" && postEmergency == "Immediately Needed") return false; //Easy posts must not be immediately or highly needed
        if (difficulty == "Easy" && postEmergency == "Highly Needed") return false;
        if (difficulty == "Very Difficult" && postEmergency == "Ordinary") return false; //Difficult and very difficult posts cannot be ordinary urgency
        if (difficulty == "Difficult" && postEmergency == "Ordinary") return false;


        FileOutputStream fileStream = new FileOutputStream("post" + postID + ".txt"); //Printing post to .txt file with formatting
        PrintWriter printer = new PrintWriter(fileStream);
        printer.println("PostID = " + postID);
        printer.println("Title = " + postTitle);
        printer.println("Body = " + postBody);

        printer.print("Tags = " );
        for (int i = 0; i < postTags.length; i++) {
            printer.print(postTags[i] + " ");
        }
        printer.println();
        printer.println("Difficulty = " + difficulty);
        printer.println("Urgency = " + postEmergency);

        printer.close();

        return true;
    }

    public boolean addComment(String comment) throws IOException //Main method for adding comments
    {

        String[] commentWords = comment.split("\\s+"); //Splitting input into words
        if (commentWords.length < 4 ) return false; //Checking amount of words is valid
        if (commentWords.length > 10) return false;
        if (!Character.isUpperCase(commentWords[0].charAt(0))) return false; //Checking first character uppercase

        if (postComments.size() > 5) return false; //Checking if too many comments already
        if (difficulty == "Easy" && postComments.size() > 2) return false; //Checking if too many commnents for difficulty
        if (postEmergency == "Ordinary" && postComments.size() > 2) return false;

        FileOutputStream fileStream = new FileOutputStream("comment" + postID + postComments.size() + ".txt"); //Outputting comment to .txt file
        PrintWriter printer = new PrintWriter(fileStream);
        printer.println("PostID = " + postID);
        printer.println("Comment = " + comment);
        printer.close();
        postComments.add(comment);

        return true;
    }
}