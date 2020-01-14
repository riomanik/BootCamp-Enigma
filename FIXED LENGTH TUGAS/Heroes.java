package fixedLength;

public class Heroes {
	private String name;
	private Integer hp;
	private Integer mana;
	private Integer damage;

	public Heroes() {

	}

	public Heroes(String str) {
		this.name = str.substring(0, 14).trim();
		this.hp = Integer.parseInt(str.substring(14, 20).trim());
		this.mana = Integer.parseInt(str.substring(20, 25).trim());
		this.damage = Integer.parseInt(str.substring(25, 30).trim());
	}

	public Heroes(String name, Integer hp, Integer mana, Integer damage) {
		this.name = name;
		this.hp = hp;
		this.mana = mana;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return String.format("%-15s", name) + String.format("%5s %5s %5s", hp, mana ,damage).replaceAll(" ", "0");
	}
}
