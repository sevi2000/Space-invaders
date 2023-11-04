package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import space.earlygrey.shapedrawer.ShapeDrawer;

public class SpaceCraft extends Actor {
    Texture texture;
    int width;
    int height;
    int bulletX,bulletY;
    boolean launched;
    private boolean alive;

    SpaceCraft(){
        super();
        setSize(40,40);
        launched = false;
        alive = true;

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
        schdr.filledRectangle(getX() + getWidth()/2 - 10,bulletY,10,30);
        schdr.setColor(Color.WHITE);
        if (alive)
            schdr.filledRectangle(40,400,40,40);
    }
    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.getX() != Gdx.graphics.getWidth()-this.getWidth()){
            this.setX(this.getX()+10);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.getX() != 0){
            this.setX(this.getX()-10);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            System.out.println(bulletX);
                //if (!launched)
                    bulletX = (int)this.getX();
                launched = true;
        }
        if (launched)
            bulletY += 1;
        if (bulletY == Gdx.graphics.getHeight())
            launched = false;
        if (bulletY == 360)
            alive = false;
    }
}
