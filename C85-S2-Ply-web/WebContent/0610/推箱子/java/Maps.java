import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Maps {

	// 当前的关数
	private static int index = 0;

	public static int[][] next() {
		int[][] ret = next(++index);
		if(ret==null) {
			index = 0;
			return next();
		} else {
			return ret;
		}
	}
	public static int[][] next(int index) {
		// 获取资源流
		InputStream in = Maps.class.getClassLoader().getResourceAsStream(index + ".map");
		if (in == null) {
			return null;
		}
		// 字节流转字符流
		InputStreamReader isr = new InputStreamReader(in);
		// 字符流转缓冲字符流
		BufferedReader br = new BufferedReader(isr);
		// 定义用于接收数据的集合
		ArrayList<int[]> data = new ArrayList<int[]>();
		String line;
		try {
			while ((line = br.readLine()) != null) {
				// 字符串转字节数组
				char[] chars = line.toCharArray();
				// 字节数组转int数组
				int[] cols = new int[chars.length];
				for (int i = 0; i < cols.length; i++) {
					cols[i] = Integer.valueOf("" + chars[i]);
				}
				// 加入集合
				data.add(cols);
			}
		} catch (IOException e) {
			// 抛出运行期异常
			throw new RuntimeException("地图读取失败!", e);
		} finally {
			// 关闭流
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		// 集合转数组
		return data.toArray(new int[data.size()][]);
	}

	/**
		数组克隆的特殊性: 请参考 https://blog.csdn.net/diyinqian/article/details/83279457
		一维数组：深克隆；（重新分配空间，并将元素复制过去）
		二维数组：浅克隆。（只传递引用）
	 */
	public static int[][] clone(int[][] array) {
		int[][] ret = array.clone();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = array[i].clone();
		}
		return ret;
	}

}
