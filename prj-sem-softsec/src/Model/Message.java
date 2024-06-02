package Model;

public class Message {

    private int sender_id;
    private int recipient_id;
    private String subject;
    private String body;

    public Message(int sender_id, int recipient_id, String subject, String body){
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.subject = subject;
        this.body = body;
    }

    public int getSender_id(){
        return this.sender_id;
    }

    public int getRecipient_id(){
        return this.recipient_id;
    }

    public String getSubject(){
        return this.subject;
    }

    public String getBody(){
        return this.body;
    }
}
