package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.Random;

public class EnemyPlane extends BaseSprite implements Moveable, Drawable {

    private Image image;

    private int speed = FrameConstant.GAME_SPEED * 2;

    private Random randow = new Random();

    public EnemyPlane() {
        this(0,0, ImageMap.get("ep01"));
    }

    public EnemyPlane(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,getX(),getY(),image.getWidth(null),image.getHeight(null),null);
        move();
        fire();
    }

    public void fire(){
        GameFrame gameFrame = DataStore.get("gameFrame");
        if (randow.nextInt(1000) > 990){
            gameFrame.enemyBulletList.add(new EnemyBullet(
                    getX() + (image.getWidth(null) / 2)-(ImageMap.get("epb01").getWidth(null) / 2),
                    getY() + image.getHeight(null),
                    ImageMap.get("epb01")));
        }
    }

    @Override
    public void move() {
        setY(getY() + speed);//敌方飞机移动
        borderTesting();
    }

    public void borderTesting(){
        if (getY() > FrameConstant.FRAME_HEIGHT){
            GameFrame gameFrame = DataStore.get("gameFrame");
            gameFrame.enemyPlaneList.remove(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }
}
