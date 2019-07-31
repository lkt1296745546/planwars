package com.neuedu.runtime;

import com.neuedu.base.BaseSprite;
import com.neuedu.base.Drawable;
import com.neuedu.base.Moveable;
import com.neuedu.constant.FrameConstant;
import com.neuedu.main.GameFrame;
import com.neuedu.util.DataStore;
import com.neuedu.util.ImageMap;

import java.awt.*;
import java.util.List;

public class Bullet extends BaseSprite implements Moveable, Drawable {

    private Image image;

    private int speed = FrameConstant.GAME_SPEED * 5;

    public Bullet() {
        this(0,0,ImageMap.get("mb01"));
    }

    public Bullet(int x, int y, Image image) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,getX(),getY(),image.getWidth(null),image.getHeight(null),null);
        move();
        borderTesting();
    }

    @Override
    public void move() {
        setY(getY() - speed);
    }

    public void borderTesting(){
        if (getY() < 30 - image.getHeight(null)){
            GameFrame gameFrame = DataStore.get("gameFrame");
            gameFrame.bulletList.remove(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(getX(),getY(),image.getWidth(null),image.getHeight(null));
    }

    //碰撞检测  intersects 判断相交关系的方法
    public void collisionTesting(List<EnemyPlane> enemyPlaneList){
        GameFrame gameFrame = DataStore.get("gameFrame");
        for (EnemyPlane enemyPlane : enemyPlaneList){
            if (enemyPlane.getRectangle().intersects(this.getRectangle())){
                enemyPlaneList.remove(enemyPlane);
                gameFrame.bulletList.remove(this);
            }
        }
    }
}
