package ru.netology;

import java.util.ArrayList;

public class Game {

    public ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player[] findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return new Player[]{player};
            }
        }
        return null;
    }

    public int findByStrength(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player.getStrength();
            }
        }
        return 0;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName1 + " not found"
            );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Element with name: " + playerName2 + " not found"
            );
        }
        if (findByStrength(playerName1) > findByStrength(playerName2)) {
            return 1;
        }
        if (findByStrength(playerName1) < findByStrength(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}
