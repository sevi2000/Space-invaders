package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Bullet extends Actor {
    Rectangle bounds;
    Bullet(){
        super();
        setSize(10,10);
        bounds = new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        update();
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawPixel(0, 0);
        Texture texture = new Texture(pixmap); // remember to dispose of later
        pixmap.dispose();
        TextureRegion region = new TextureRegion(texture, 0, 0, 1, 1);
        ShapeDrawer schdr = new ShapeDrawer(batch, region);
        schdr.setColor(Color.BLACK);
        schdr.filledRectangle(getX(),getY(),getWidth(),getHeight());
    }
    public void update(){
        this.moveBy(0,10);
        this.bounds.x = getX();
        this.bounds.y+=10;
    }
}
