public class Main{
    public static void main(String[] args) {
        UsersCount socialNetwork = new UsersCount("Вконкате", "Сергей Черненко", 2019);
        UsersCount socialNetwork2 = new UsersCount("Вконкате", "Даша Самосвал", 2024);
        UsersCount socialNetwork3 = new UsersCount("Вконкате", "Евгений Туберкулез", 2024);
        Game game = new Game("Dota 2", "Valve", 2013);
        Weather weather = new Weather("Солнечно", "Сергей Черненко", 2024);
        System.out.println(socialNetwork);
        System.out.println(socialNetwork2);
        System.out.println(socialNetwork3);
        System.out.println(game);
        System.out.println(weather);
        System.out.println("Кол-во запросов: " + Application.getCount());
    }
}

abstract class Application{
    private String name; 
    private String developer;
    private int date;
    private static int count = 0;
    public Application(){}
    public Application(String name,String developer,int date){
        this.name = name;
        this.developer = developer;
        this.date = date;
        count++;
    }
    // Сделаем сеттеры и геттеры
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDeveloper(){
        return developer;
    }
    public void setDeveloper(String developer){
        this.developer = developer;
    } 
    public int getDate(){
        return date;
    }
    public void setDate(int date){
        this.date = date;
    }
    public static int getCount(){
        return count;
    }
    public abstract void showInfromation();
}

class SocialNetwork extends Application{
    public SocialNetwork(String name, String developer, int date){
        super(name,developer,date);
    }

    public void showInfromation() {}
    
    @Override
    public String toString() {
        return "Социальная сеть: " + getName() +
               ", Пользователь: " + getDeveloper() +
               ", Год регистрации: " + getDate();
    }
}

class UsersCount extends SocialNetwork{
    private static int countUsers = 0;
    public UsersCount(String name, String developer, int date){
        super(name, developer, date);
        countUsers++;
    }
    @Override
    public String toString() {
        return "Социальная сеть: " + getName() +
                ", Пользователь: " + getDeveloper() +
                ", Год регистрации: " + getDate() +
                ", Количество пользователей: " + countUsers;
    }
}

class Game extends Application{
    public Game(String name, String developer, int date){
        super(name,developer,date);
    }

    public void showInfromation(){}

    @Override
    public String toString(){
        return "Игра: " + getName() + 
        ", Разработчик: " + getDeveloper() +
        ", Год создания: " + getDate();
    }    
}

class Weather extends Application{
    public Weather(String name,String developer, int date){
        super(name,developer,date);
    }
    public void showInfromation(){};
    @Override
    public String toString(){
        return "Погода: " + getName() + 
        ", Разработчик: " + getDeveloper() +
        ", Год: " + getDate();
    }
}