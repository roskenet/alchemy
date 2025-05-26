import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PullRequestApprover {

    public static class PullRequestComment {
        private String userId;
        private String commentText;
        private LocalDateTime date;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCommentText() {
            return commentText;
        }

        public void setCommentText(String commentText) {
            this.commentText = commentText;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }
    }


    public static boolean isPullRequestApproved(List<PullRequestComment> comments,
                                                LocalDateTime lastCommitTime) {
        // check last two comments for the word "approved"
        // they need to be after lastCommitTime

        // use streams to order pullRequestComments
        // filter for every pullRequComm younger thatn lastCommitTime
        // get the last two
        // check for String equals "approved"

        List<PullRequestComment> approved = comments.stream()
                .filter(
                        prc -> prc.getDate().isAfter(lastCommitTime) &&
                                           prc.getCommentText().equals("approved"))
                .collect(Collectors.toList());

        if (approved.size() >= 2) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

        List<PullRequestComment> pullRequestComments = new ArrayList<>();

        PullRequestComment c1 = new PullRequestComment();
        c1.setUserId("1");
        c1.setCommentText("approved");
        c1.setDate(LocalDateTime.parse("2025-05-25T12:00:00"));

        PullRequestComment c2 = new PullRequestComment();
        c2.setUserId("1");
        c2.setCommentText("approved");
        c2.setDate(LocalDateTime.parse("2025-05-25T12:01:00"));

        pullRequestComments.addAll(Arrays.asList(c1, c2));

        boolean pullRequestApproved = isPullRequestApproved(pullRequestComments, LocalDateTime.parse("2025-05-25T10:00:00"));
        Assertions.assertTrue(pullRequestApproved);
    }
}
