package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.GameField;
import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.view.mob.MonsterView;
import ru.rsreu.nikolaev0211.view.mob.PlayerView;
import ru.rsreu.nikolaev0211.view.object.level.BlockView;

import java.awt.*;
import java.util.List;


public class FieldView implements Renderable {

    private BlockView blockView = new BlockView();
    private PlayerView playerView = new PlayerView();
    private MonsterView monsterView = new MonsterView();

    @Override
    public void render(Graphics2D graphics, GameData gameData) {
        renderGameField(graphics, gameData.getGameField());
        renderPlayer(graphics, gameData.getPlayer());
        renderMonsters(graphics, gameData.getMonsters());
    }

    private void renderGameField(Graphics2D graphics, GameField gameField) {
        List<Block> blockList = gameField.getBlocks();
        for (Block block : blockList) {
            blockView.render(graphics, block);
        }

    }

    private void renderPlayer(Graphics2D graphics, Mob player) {
        playerView.render(graphics, player);
    }

    private void renderMonsters(Graphics2D graphics, List<Mob> monsters) {
        for (Mob monster : monsters) {
            monsterView.render(graphics, monster);
        }
    }

}
