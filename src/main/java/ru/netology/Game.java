package ru.netology;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName1 + " not found");
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName2 + " not found");
        }

        int strength1 = player1.getStrength();
        int strength2 = player2.getStrength();

        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 < strength2) {
            return 2;
        } else {
            return 0;
        }
    }
}

