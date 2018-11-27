package ru.rsreu.nikolaev0211.view.mob;

import ru.rsreu.nikolaev0211.model.level.Block;
import ru.rsreu.nikolaev0211.model.mob.Mob;

import java.awt.*;

public interface MobView {
    void render(Graphics2D graphics, Mob mob);
}
