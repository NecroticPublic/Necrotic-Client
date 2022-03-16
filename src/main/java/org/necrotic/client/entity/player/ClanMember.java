package org.necrotic.client.entity.player;

import org.necrotic.client.Client;

public class ClanMember {

	public ClanMember(String playerName, int rankId) {
		this.playerName = playerName;
		rank = Rank.forId(rankId);
	}

	private String playerName;
	private Rank rank;

	public String getPlayerName() {
		return playerName;
	}

	public Rank getRank() {
		return rank;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setRank(int rankId) {
		rank = Rank.forId(rankId);
	}

	public enum Rank {
		NOT_RANKED, FRIEND, RECRUIT, CORPORAL, SERGEANT, LIEUTENANT, CAPTAIN, GENERAL, OWNER, BANNED, KICKED;

		public String getPermissionString() {
			String permission = toStr();

			if (this == Rank.NOT_RANKED) {
				permission = "Anyone";
			} else if (this == Rank.FRIEND) {
				permission = "Only friends";
			} else if (this == Rank.OWNER) {
				permission = "Only me";
			}

			return permission;
		}

		public String toStr() {
			return Client.capitalize(toString().toLowerCase().replaceAll("_", " "));
		}

		public static Rank forId(int id) {
			for (Rank rank : Rank.values()) {
				if (rank.ordinal() == id) {
					return rank;
				}
			}

			return null;
		}
	}

}