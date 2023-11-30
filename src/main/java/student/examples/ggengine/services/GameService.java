package student.examples.ggengine.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.game.Game;
import student.examples.ggengine.game.GameState;
import student.examples.ggengine.game.Item;
import student.examples.ggengine.game.Rock;

@Slf4j
@Getter
@Service
public class GameService {
	private Set<Game> games;
	
	public GameService() {
	    init();
	  }

	  public void init() {
		  games = new HashSet<Game>();
//		  Game game = new Game();
		  games.add(new Game());
		  
		  Game game = games.stream().findFirst().get();
		  game.getItems().add(new Rock(0, 0, 0, 0, 0, 0, 0, 0, null));
		  
//		  items.add(new Rock(0, 0, 0, 0, 0, 0, 0, 0, null));
	  }

//	public void init() {
//		rock = new Rock();
//		rock.setWidth(0);
//		rock.setHeight(0);
//		rock.setSpeedX(0);
//		rock.setSpeedY(0);
//		rock.setLeft(0);
//		rock.setRotation(0);
//		rock.setTop(0);
//		rock.setRotationSpeed(0);
//	}

	@Scheduled(fixedRate = 15) // 15
	  public void updateGameState() {
//	    rock.setTop(rock.getTop() + 1);
//	    rock = new Rock(
//	        rock.getWidth(), 
//	        rock.getHeight(), 
//	        rock.getSpeedX(), 
//	        rock.getSpeedY(), 
//	        rock.getTop() + 1,
//	        rock.getLeft(), 
//	        rock.getRotation(), 
//	        rock.getRotationSpeed(), 
//	        rock.getItemType());
//		Item item = items.stream().findFirst().get();
//		items.remove(item);
//		items.add(new Rock(
//				item.getWidth(), 
//				item.getHeight(), 
//				item.getSpeedX(), 
//				item.getSpeedY(), 
//				item.getTop() + 1,
//				item.getLeft(), 
//				item.getRotation(), 
//		        item.getRotationSpeed(), 
//		        item.getItemType()));
		Game game = games.stream().findFirst().get();
		
		Item item = game.getItems().stream().findFirst().get();
		game.getItems().remove(item);
		
		game.getItems().add(new Rock(item.getWidth(),
				item.getHeight(),
				item.getSpeedX(),
				item.getSpeedY(),
				item.getTop()+1,
				item.getLeft(),
				item.getRotation(),
				item.getRotationSpeed(),
				null));
		
//	    log.info("Update:" + rock.getTop());
	  }

	public void addGame() {
		Game game = new Game();
		game.getItems().add(new Rock(0, 0, 0, 0, 0, 0, 0, 0, null));
		game.setGameState(GameState.STARTED);
		games.add(game);
		
		games.forEach(System.out::println);
		
	}
}
