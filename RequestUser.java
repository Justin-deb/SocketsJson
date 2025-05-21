public class RequestUser {
    private Person user;
    private String petition;
    
    public RequestUser() {
    }

    public RequestUser(Person user, String petition) {
        this.user = user;
        this.petition = petition;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public String getPetition() {
        return petition;
    }

    public void setPetition(String petition) {
        this.petition = petition;
    }

    @Override
    public String toString() {
        return "RequestUser: user:" + user + ", petition:" + petition;
    }

    
}
