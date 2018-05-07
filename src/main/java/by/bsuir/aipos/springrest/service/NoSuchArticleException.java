package by.bsuir.aipos.springrest.service;

public class NoSuchArticleException extends Exception {

    public NoSuchArticleException() {
    }

    public NoSuchArticleException(String message) {
        super(message);
    }

    public NoSuchArticleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchArticleException(Throwable cause) {
        super(cause);
    }
}
