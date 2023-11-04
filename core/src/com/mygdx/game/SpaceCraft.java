package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.HashMap;

public class SpaceCraft extends Actor {
    Bullet bullet;
    SpaceCraft(Bullet bullet){
        super();
        setSize(40,40);
        this.bullet = bullet;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawPixel(0, 0);
        Texture texture = new Texture(pixmap); // remember to dispose of later
        pixmap.dispose();
        TextureRegion region = new TextureRegion(texture, 0, 0, 1, 1);
        ShapeDrawer schdr = new ShapeDrawer(batch, region);
        schdr.setColor(Color.BLACK);
        schdr.filledRectangle(getX(),getY(),getWidth()/3,getHeight()/2);
        schdr.filledRectangle(getX()+getWidth()/3,getY(),getWidth()/3,getHeight());
        schdr.filledRectangle(getX()+getWidth()/3*2,getY(),getWidth()/3,getHeight()/2);
    }
    public void update(Stage stg){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.getX() != Gdx.graphics.getWidth()-this.getWidth()){
            this.moveBy(5,0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.getX() != 0){
            this.moveBy(-5,0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if(!stg.getActors().contains(bullet,true)){
                bullet.setPosition(getX() + (int)getWidth()/2,0);
                bullet.bounds.x = getX();
                bullet.bounds.y = getY();
                stg.addActor(bullet);
            }
        }
        if (bullet.getY() == Gdx.graphics.getHeight()){
            stg.getRoot().removeActor(bullet);
        }
    }
    boolean touchesAlien(int x, int y, Vector2 alienPos){
        return x <= alienPos.x + 40 && x >= alienPos.x && y == alienPos.y - 20;
    }
}
