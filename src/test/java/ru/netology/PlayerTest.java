package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Game game = new Game();
    Player player1 = new Player(1, "Ваня", 40);
    Player player2 = new Player(2, "Маша", 40);
    Player player3 = new Player(3, "Катя", 20);

    @Test
    public void shouldWinOne() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Ваня", "Катя");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinTwo() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Катя", "Маша");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinNobody() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Ваня", "Маша");

        assertEquals(expected, actual);
    }

    @Test
    public void OneNoRegistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Миша", "Маша");
        });
    }

    @Test
    public void TwoNoRegistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Маша", "Коля");
        });
    }

    @Test
    public void NoRegisteredPlayers() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Петя");
        });
    }
}
