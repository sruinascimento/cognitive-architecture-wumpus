import br.com.rsfot.Environment;

public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment(4);
        environment.showElementsBoard();
        System.out.println(environment.getFeelingsByCoordinate());
    }
}