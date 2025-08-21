package controler;

import java.security.SecureRandom;

public class Safety {

    public class IdGenerator {
        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final int ID_LENGTH = 10;
        private static final SecureRandom random = new SecureRandom();

        public static String generateId() {
            StringBuilder sb = new StringBuilder(ID_LENGTH);
            for (int i = 0; i < ID_LENGTH; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            // Exemple de génération d'un ID pour un nouveau compte
            String newId = generateId();
            String email = "nouvel.email@example.com"; // Email du nouveau compte

            System.out.println("ID généré : " + newId);
            System.out.println("Email associé : " + email);
        }
    }
}
