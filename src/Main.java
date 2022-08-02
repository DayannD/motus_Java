import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int essaie = 5;
        String[] wordTableau = new String[]{"bonjour","cadeau","unidimensionnel","voiture","dépression"};
        Random rand = new Random();
        String uncoderWord = null;
        int randomWord = rand.nextInt(wordTableau.length);

        System.out.println("Voici le mot que vous aller déviner " + wordTableau[randomWord]);

        String word = wordTableau[randomWord];

        for (int i = 0; i < word.length(); i++){
            if (i == 0){
                uncoderWord = String.valueOf(word.charAt(i));
            }else{
                uncoderWord += "*";
            }
        }

        System.out.println(uncoderWord);
        List charTabl = new ArrayList<>() ;
        StringBuilder newString = new StringBuilder(uncoderWord);

        while(!newString.equals(word)){
            charTabl.clear();

            System.out.println("Rentrer votre mot");
            String urWord = scanner.nextLine();

            if (urWord.length() > word.length() || urWord.length() < word.length()){
                System.out.println("Le mot que vous avez rentrer est incorrect");
                continue;
            }

            StringBuilder urWordBuilder = new StringBuilder(urWord);
            for (int i = 0; i < urWord.length(); i++){
                if (urWord.charAt(i) == word.charAt(i)){
                     newString.setCharAt(i,urWord.charAt(i));
                     urWordBuilder.setCharAt(i,' ');
                }
            }
            for (int i = 0; i < urWord.length(); i++) {
                for (int y = 0; y < urWord.length(); y++) {
                    char charWord = urWordBuilder.charAt(i);
                    if (charWord == word.charAt(y)) {
                        charTabl.add(urWord.charAt(i));
                        urWordBuilder.setCharAt(i, '1');
                    }
                }
            }
            String result = String.valueOf(newString);
            if (result.equals(word)){
                System.out.println("Vous avez gagné!!!");
                break;
            }
            System.out.println(newString);
            System.out.println("les lettres " + charTabl + " sont mal placer, il vous reste "+ essaie--);

            if (essaie == 0){
                System.out.println("vous avez dépasser le nombre d'essaie,Relancer la partie");
                break;
            }
        }
    }
}