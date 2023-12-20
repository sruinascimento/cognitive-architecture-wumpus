//import br.com.rsfot.domain.Agent;
//import br.com.rsfot.domain.Environment;

import br.com.rsfot.domain.Environment;
import br.com.rsfot.util.MatrixFormatter;

public class Main {
    public static void main(String[] args) {
        Environment environment = new Environment(4);
        System.out.println(MatrixFormatter.formatMatrix(environment.getWorld(), 5, 1));
        System.out.println(environment.getFeelingsByCoordinate());
    }
}