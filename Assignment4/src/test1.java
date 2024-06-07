import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class test1 {
    String postBody60 = "This has 60 characteThis has 60 characteThis has 60 characte";
    String postBody260 = "This has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 charactellllllllllllllllllll";
    String postBody310 = "This has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 characteThis has 60 charactellllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllThis has 60 characteThis has 60 characteThThis has 60 characteThis has 60 characteTh";

    @Test
    public void addValidPost() throws IOException { //Testing with valid post
        Post validPostShouldPass = new Post(1, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag","tag2","tag3"}, "Difficult", "Highly Needed");
        assertTrue(validPostShouldPass.addPost());

        Post validPostShouldPass1 = new Post(1, "TitleWithAtLeast20Chars", postBody310, new String[]{"abc","def","adad"}, "Easy", "Highly Needed");
        assertTrue(validPostShouldPass.addPost());
    }
    @Test
    public void addInvalidShortTitlePost() throws IOException { //Testing with post with invalid title/short
        Post invalidPostShortTitle = new Post(2, "Title1", postBody310, new String[]{"tag1", "tag2", "tag3"}, "Difficult", "Highly Needed");
        assertFalse(invalidPostShortTitle.addPost());

        Post invalidPostShortTitle1 = new Post(2, "abc", postBody310, new String[]{"tag1", "tag2", "tag3"}, "Difficult", "Highly Needed");
        assertFalse(invalidPostShortTitle1.addPost());
    }
    @Test
    public void addPostTooManyTagsEasyDifficulty() throws IOException { //Adding post with too many tags
        Post invalidTooManyTagsForDifficulty = new Post(3, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag1", "tag2", "tag3", "tag4", "tag5"}, "Easy", "Ordinary");
        assertFalse(invalidTooManyTagsForDifficulty.addPost());

        Post invalidTooManyTagsForDifficulty1 = new Post(3, "TitleWithAtLeast20Chars", postBody310, new String[]{"tag1", "tag2", "tag3", "tag4"}, "Easy", "Ordinary");
        assertFalse(invalidTooManyTagsForDifficulty1.addPost());
    }
    @Test
    public void addPostNotEnoughCharsBody() throws IOException { //Adding post with not enough characters in main body
        Post invalidNotEnoughCharsBody = new Post(4, "TitleWithAtLeast10Chars", postBody60, new String[]{"tag1", "tag2", "tag3"}, "Difficult", "Highly Needed");
        assertFalse(invalidNotEnoughCharsBody.addPost());

        Post invalidNotEnoughCharsBody1 = new Post(4, "TitleWithAtLeast20Chars", postBody260, new String[]{"tag1", "tag2", "tag3", "tag4"}, "Very Difficult", "Highly Needed");
        assertFalse(invalidNotEnoughCharsBody1.addPost());
    }
    @Test
    public void addPostIncorrectTags() throws IOException { //Adding post with incorrect tags
        Post invalidIncorrectTags = new Post(5, "TitleWithAtLeast10Chars", postBody310, new String[]{"Java", "Beans", "Toast"}, "Difficult", "Highly Needed");
        assertFalse(invalidIncorrectTags.addPost());

        Post invalidIncorrectTags1 = new Post(5, "TitleWithAtLeast20Chars", postBody310, new String[]{"tag1", "tag2", "tag3", "tag4", "tag5", "tag6", "tag7"}, "Very Difficult", "Highly Needed");
        assertFalse(invalidIncorrectTags1.addPost());
    }
    @Test
    public void addPostEasyWithUrgentStatus() throws IOException { //Adding post with mismatches status/difficulty
        Post invalidStatus = new Post(6, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag1", "tag2", "tag3"}, "Easy", "Highly Needed");
        assertFalse(invalidStatus.addPost());

        Post invalidStatus1 = new Post(6, "TitleWithAtLeast20Chars", postBody310, new String[]{"tag1", "tag2", "tag3"}, "Very Difficult", "Ordinary");
        assertFalse(invalidStatus1.addPost());
    }
    //TESTING COMMENTS NOW
    @Test
    public void addValidComment() throws IOException { //Test for adding valid comment, should pass
        Post validPost = new Post(1, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag","tag2","tag3"}, "Difficult", "Highly Needed");
        validPost.addPost();
        assertTrue(validPost.addComment("This comment is correct."));

        assertTrue(validPost.addComment("Second valid comment yayayaya."));
    }
    @Test
    public void addCommentInvalidWordCount() throws IOException { //Adding comment with short/long word count
        Post validPost = new Post(2, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag","tag2","tag3"}, "Difficult", "Highly Needed");
        validPost.addPost();
        assertFalse(validPost.addComment("Too short"));

        assertFalse(validPost.addComment("Too loong long long long long long long long long long long long long."));
    }
    @Test
    public void addCommentLowerCaseStart() throws IOException { //Adding comment with lower case start
        Post validPost = new Post(3, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag","tag2","tag3"}, "Difficult", "Highly Needed");
        validPost.addPost();
        assertFalse(validPost.addComment("i like bananas and also cherries"));

        assertFalse(validPost.addComment("banana"));
    }
    @Test
    public void addCommentTooManyComments() throws IOException { //Checking to see how many comments have been added
        Post validPost = new Post(4, "TitleWithAtLeast10Chars", postBody310, new String[]{"tag","tag2","tag3"}, "Easy", "Ordinary");
        validPost.addPost();
        validPost.addComment("I like bananas and also cherries 1");
        validPost.addComment("I like bananas and also cherries 2");
        validPost.addComment("i like bananas and also cherries 3");
        validPost.addComment("i like bananas and also cherries 4");
        validPost.addComment("i like bananas and also cherries 5");
        assertTrue(validPost.addComment("I like bananas and also cherries 4"));
    }





    public static void main(String[] args) {

    }
}
