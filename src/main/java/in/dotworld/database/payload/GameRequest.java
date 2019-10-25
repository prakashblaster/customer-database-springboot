package in.dotworld.database.payload;

import javax.validation.constraints.NotBlank;

public class GameRequest {

	@NotBlank
	private String gameName;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

}
