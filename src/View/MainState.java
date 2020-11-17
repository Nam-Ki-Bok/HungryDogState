package View;

import Controller.GameManager;
import Model.BackgroundMusic;

public class MainState implements State {

	private static MainState mainState;

	private MainState() {
	}

	public static MainState getInstance() {
		Game game = GameManager.getInstance().getGame();
		game.getContentPane().removeAll();
		game.getContentPane().add(MainPanel.getInstance());
		game.repaint();
		game.setVisible(true);
		if (mainState == null)
			mainState = new MainState();
		
		return mainState;
	}

	@Override
	public void rankButton() {
		Game game = GameManager.getInstance().getGame();
		game.setState(RankState.getInstance());
	}

	@Override
	public void startButton() {
		Game game = GameManager.getInstance().getGame();
		game.setState(PlayingState.getInstance());
		BackgroundMusic.getInstance().stopMusic();
		game.getController().setIsGameOverTrue(); 
	}

	@Override
	public void mainButton() {
	}

	@Override
	public void gameOver() {
	}

	@Override
	public void gameClear() {
	}

	@Override
	public void nextStage() {
	}
}