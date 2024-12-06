import java.util.*;

class SocialNetwork {
    private Map<String, List<String>> network;

    public SocialNetwork() {
        network = new HashMap<>();
    }

    public void addPerson(String person) {
        network.putIfAbsent(person, new ArrayList<>());
    }

    public void addFriendship(String person1, String person2) {
        network.get(person1).add(person2);
        network.get(person2).add(person1);
    }

    public void displayNetwork() {
        for (String person : network.keySet()) {
            System.out.print(person + " is friends with: ");
            for (String friend : network.get(person)) {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
    }
}

public class SocialNetworkApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();

        network.addPerson("Lexharriet");
        network.addPerson("Anrelle");
        network.addPerson("Gv");
        
        network.addFriendship("Lexharriet", "Anrelle");
        network.addFriendship("Lexharriet", "Gv");
        network.addFriendship("Anrelle", "Gv");

        System.out.println("Social Network:");
        network.displayNetwork();
    }
}
