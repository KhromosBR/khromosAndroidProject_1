package khromostech.khromosandroidproject_1;


import android.app.Activity;

public class Constructor_users {

    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    private String title_news;

    public String getContentNews() {
        return contentNews;
    }

    public void setContentNews(String contentNews) {
        this.contentNews = contentNews;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getTitle_news() {
        return title_news;
    }

    public void setTitle_news(String title_news) {
        this.title_news = title_news;
    }

    private String contentNews;

    public Constructor_users(String email, String confirmEmail, String password, String confirmPassword) {
        this.email = email;
        this.confirmEmail = confirmEmail;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Constructor_users(String title_news, String contentNews){
        this.title_news = title_news;
        this.contentNews = contentNews;
    }
}

