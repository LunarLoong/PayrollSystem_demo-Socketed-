package cn.bnuz.edu.dp.memoto;

import java.util.HashMap;
import java.util.Map;

public class AlbumCarer {
	private Map<String,IMemoto> memotos = new HashMap<>();

	public void putMemoto(String key, IMemoto memoto) {
		memotos.put(key, memoto);
		
	}

	public IMemoto getMemoto(String key) {		
		return memotos.get(key);
	}

}
