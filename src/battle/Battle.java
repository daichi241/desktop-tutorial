package battle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import samplearc.character.BattleCharacter;
import samplearc.dao.ArcDao;

public class Battle {
	//戦闘参加キャラクタマップ キー:戦闘キャラクタID  値:キャラクター情報
	private static Map<Integer,BattleCharacter> battleCharactersMap = new HashMap<>();
	public static void main(String[] args) {
		Battle battle = new Battle();
		List<Integer> compareActionCharacter;
		//戦闘開始
		do{
			//ターン毎に敏捷度が高いキャラから行動するようソートする
			compareActionCharacter = battle.compareAction();
		}while(battle.battleAction(compareActionCharacter));
		System.out.println("戦闘終了");

	}

	/**
	 *  コンストラクタ
	 */
	private Battle(){
		//キャラクター情報をDBから取得して、戦闘キャラクターとして生成
		ArcDao dao = new ArcDao();
		for(int i=0;i<2;i++) {
			BattleCharacter battleCharacter = dao.selectCharacter(i + 2);
			battleCharactersMap.put(i,battleCharacter);
		}

	}

	/**
	 * 行動順ソートメソッド
	 * @return Map<Integer,Integer> compareActionMap
	 */
	private List<Integer> compareAction(){
		System.out.println(battleCharactersMap);
		Map<Integer,Integer> actionCompareMap = new HashMap<>();
		actionCompareMap = battleCharactersMap
				.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getAgile()));
		List<Map.Entry<Integer, Integer>> entries =
				actionCompareMap
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toList());
		System.out.println("MapList:" + entries.get(0) + " " + entries.get(1));
		List<Integer> actionCharacterId = new ArrayList<>();

		return actionCharacterId;
	}
	/**
	 * 戦闘行動メソッド
	 * @param actionCharacters
	 * @return true:戦闘続行 false:戦闘終了
	 */
	private boolean battleAction(List<Integer> actionCharactersId) {
		for(Integer charId:actionCharactersId) {
			System.out.println(charId);
		}

		return false;
	}

}
