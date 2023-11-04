package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class Ennemi extends Actor {
    Rectangle bounds;
    Ennemi(int x, int y){
        super();
        setPosition(x,y);
        setSize(40,40);
        bounds = new Rectangle(getX(),getY(),getWidth(),getHeight());
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
        schdr.setColor(Color.WHITE);
        schdr.filledRectangle(getX(),getY(),getWidth(),getHeight());
    }
}
