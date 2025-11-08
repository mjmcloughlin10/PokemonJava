package pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class PokemonMaker {
    public static Pokemon[] getAllPokemons() {
        List<Move> allMoves = new ArrayList<>();
        List<String> moveLines = getLines("pokemon/MoveData.txt");
        // System.out.println(lines.size());
        for(String line : moveLines) {
            String[] tokens = line.split(",");
            //name,power,type,pp,accuracy
            String name = tokens[0];
            int power = 0;
            if(!tokens[1].equals("None")) {
                power = Integer.parseInt(tokens[1]);
            }
            Type type = new Type(tokens[2]);
            int pp = Integer.parseInt(tokens[3]);
            int accuracy = 0;
            if(!tokens[4].equals("None")) {
                accuracy = Integer.parseInt(tokens[4]);
            }
            Move move = new Move(name, power, type, pp, accuracy);
            allMoves.add(move);
        }

        Collections.sort(allMoves);

        List<Pokemon> allPokemon = new ArrayList<>();
        List<String> pokeLines = getLines("pokemon/PokemonData.txt");
        for(String line : pokeLines) {
            String[] tokens = line.split(",");
            // name,type1,type2?,type3?,hp,atk,def,spAtk,spDef,speed,level,move1,move2?,move3?,move4?
            String name = tokens[0];
            Type[] types;
            String type1 = tokens[1];
            String type2 = tokens[2];
            String type3 = tokens[3];
            if(type2.equals("")) {
                types = new Type[1];
                types[0] = new Type(type1);
            } else if(type3.equals("")) {
                types = new Type[2];
                types[0] = new Type(type1);
                types[1] = new Type(type2);
            } else {
                types = new Type[3];
                types[0] = new Type(type1);
                types[1] = new Type(type2);
                types[2] = new Type(type3);
            }
            int hp = Integer.parseInt(tokens[4]);
            int atk = Integer.parseInt(tokens[5]);
            int def = Integer.parseInt(tokens[6]);
            int spAtk = Integer.parseInt(tokens[7]);
            int spDef = Integer.parseInt(tokens[8]);
            int speed = Integer.parseInt(tokens[9]);
            int level = Integer.parseInt(tokens[10]);
            Move[] moves;
            String move1 = tokens[11];
            if(tokens.length < 13) {
                moves = new Move[1];
                moves[0] = allMoves.get(Collections.binarySearch(allMoves, new Move(move1)));
            } else if(tokens.length < 14) {
                moves = new Move[2];
                String move2 = tokens[12];
                moves[0] = allMoves.get(Collections.binarySearch(allMoves, new Move(move1)));
                moves[1] = allMoves.get(Collections.binarySearch(allMoves, new Move(move2)));
            } else if (tokens.length < 15) {
                moves = new Move[3];
                String move2 = tokens[12];
                String move3 = tokens[13];
                moves[0] = allMoves.get(Collections.binarySearch(allMoves, new Move(move1)));
                moves[1] = allMoves.get(Collections.binarySearch(allMoves, new Move(move2)));
                moves[2] = allMoves.get(Collections.binarySearch(allMoves, new Move(move3)));
            } else {
                moves = new Move[4];
                String move2 = tokens[12];
                String move3 = tokens[13];
                String move4 = tokens[14];
                moves[0] = allMoves.get(Collections.binarySearch(allMoves, new Move(move1)));
                moves[1] = allMoves.get(Collections.binarySearch(allMoves, new Move(move2)));
                moves[2] = allMoves.get(Collections.binarySearch(allMoves, new Move(move3)));
                moves[3] = allMoves.get(Collections.binarySearch(allMoves, new Move(move4)));
            }
            Pokemon pokemon = new Pokemon(name, hp, atk, def, spAtk, spDef, speed, level, types, moves);
            allPokemon.add(pokemon);
        }

        return allPokemon.toArray(new Pokemon[0]);
    }

    private static List<String> getLines(String filename) {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner;
        try 
        {
            scanner = new Scanner(file);
        }
        catch(FileNotFoundException fnfe)
        {
            return lines;
        }

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            lines.add(line);
        }
        scanner.close();
        return lines;
    }
}
