package mapper;

public interface RabbitMq<T> {
    public void sendMsg(T t);
    public void receiveMsg (T t);
}
