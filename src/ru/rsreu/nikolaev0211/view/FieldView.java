package ru.rsreu.nikolaev0211.view;

import ru.rsreu.nikolaev0211.model.GameData;
import ru.rsreu.nikolaev0211.model.GameField;
import ru.rsreu.nikolaev0211.model.bomb.Bomb;
import ru.rsreu.nikolaev0211.model.bomb.Explosion;
import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.level.Portal;
import ru.rsreu.nikolaev0211.model.mob.Mob;
import ru.rsreu.nikolaev0211.view.Canvas;
import ru.rsreu.nikolaev0211.view.mob.MonsterView;
import ru.rsreu.nikolaev0211.view.mob.PlayerView;
import ru.rsreu.nikolaev0211.view.object.BombView;
import ru.rsreu.nikolaev0211.view.object.ExplosionView;
import ru.rsreu.nikolaev0211.view.object.level.BlockView;

import java.awt.*;
import java.util.List;


public class FieldView implements Renderable {

    private BlockView blockView = new BlockView();
    private PlayerView playerView = new PlayerView();
    private MonsterView monsterView = new MonsterView();
    private BombView bombView = new BombView();
    private ExplosionView explosionView = new ExplosionView();


    @Override
    public void render(Graphics2D graphics, GameData gameData, Canvas canvas) {
        renderGameFieldPortal(graphics, gameData.getGameField().getPortal());
        renderGameField(graphics, gameData.getGameField());
        renderBombs(graphics, gameData.getBomb());
        renderExplosions(graphics, gameData.getGameField().getExplosionList());
        renderPlayer(graphics, gameData.getPlayer());
        renderMonsters(graphics, gameData.getMonsters());
    }

    private void renderGameFieldPortal(Graphics2D graphics, Portal portal) {
        blockView.render(graphics, portal);
    }

    private void renderExplosions(Graphics2D graphics, List<Explosion> explosionList) {
        for (Explosion explosion : explosionList) {
            explosionView.render(graphics, explosion);
        }
    }

    private void renderBombs(Graphics2D graphics, List<Bomb> bombs) {
        if (bombs != null) {
            for (Bomb bomb : bombs) {
                bombView.render(graphics, bomb);
            }
        }
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
