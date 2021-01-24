package samplearc.character;

/**
 *
 * @author sakamotodaichi
 * 戦闘に参加するキャラクター情報
 */
public class BattleCharacter {
	private final int id;
	private String name;
	private int hp;
	private int attack;
	private int agile;

	public BattleCharacter(int id){
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getHp() {
		return hp;
	}
	public int getAttack() {
		return attack;
	}
	public int getAgile() {
		return agile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setAgile(int agile) {
		this.agile = agile;
	}

	@Override
	public String toString() {
		return "＜キャラクターID:" + id + "＞\n" +
				"キャラクター名:" + name +"\n" +
				"HP:" + hp + "\n" +
				"攻撃力:" + attack + "\n" +
				"敏捷度:" + agile + "\n" ;
	}

}
