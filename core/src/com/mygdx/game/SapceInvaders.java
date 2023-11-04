package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class SapceInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	SpaceCraft spaceCraft;
	ArrayList<Ennemi> ennemis;
	Bullet bullet;
	Stage stg;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		ennemis = new ArrayList<>();
		bullet = new Bullet();
		stg = new Stage();
		spaceCraft = new SpaceCraft(bullet);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				Ennemi e = new Ennemi(10 + j * 50 , Gdx.graphics.getHeight() - ((i+1) * 50));
				ennemis.add(e);
				stg.addActor(e);
			}
		}

		stg.addActor(spaceCraft);
		stg.act();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		spaceCraft.update(stg);
		stg.draw();
		Ennemi toRemove = null;
		for (Ennemi e: ennemis){
			if (bullet.bounds.overlaps(e.bounds)){
				stg.getRoot().removeActor(e);
				stg.getRoot().removeActor(bullet);
				toRemove = e;
				System.out.println("touched");
			}
		}
		ennemis.remove(toRemove);

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
