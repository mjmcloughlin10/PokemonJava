package pokemon;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Pokemon[] allPokemon = PokemonMaker.getAllPokemons();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Pokemon p1 = allPokemon[random.nextInt(allPokemon.length)];
        Pokemon p2 = allPokemon[random.nextInt(allPokemon.length)];

        
        while(!p1.isDead() && !p2.isDead()) {
            System.out.println(p1);
            System.out.println("vs.");
            System.out.println(p2);
            for(int i = 0; i < p1.getMoves().length; ++i) {
                System.out.printf("%d. %s\n", i+1, p1.getMoves()[i]);
            }
    
            System.out.print("Choose an attack: ");
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Please type a number!");
                scanner.nextLine();
                continue;
            }
            while(choice < 1 || choice > p1.getMoves().length) {
                System.out.print("Choose an attack: ");
                choice = scanner.nextInt();
            }
    
            Move move = p1.getMoves()[choice-1];
            if(move.canUse()) {
                move.use();
            } else {
                continue;
            }
            int damage = calcDamage(move, p1, p2);
    
            System.out.printf("%s used %s! It did %d damage!\n", p1.getName(), move.getName(), damage);
            p2.takeDamage(damage);
        }

        if(p1.isDead()) {
            System.out.printf("%s fainted!\n", p1.getName());
        }
        
        if(p2.isDead()) {
            System.out.printf("%s fainted!\n", p2.getName());
        }

        scanner.close();
    }

    private static int calcDamage(Move move, Pokemon attacker, Pokemon defender) {
        int crit = 1;
        int atk = attacker.getAtk();
        int def = defender.getDef();
        int damage = ((((2 * attacker.getLevel() * crit) / 5) + 2) * move.getPower() * atk / def) / 50 + 2;
        double stab = getSTAB(move, attacker);
        double effect = Type.getEffect(attacker.getTypes()[0], defender.getTypes()[0]);
        return (int) (damage * stab * effect);
    }

    private static double getSTAB(Move move, Pokemon attacker) {
        if(attacker.hasType(move.getType())) return 1.5;
        return 1;
    }
}