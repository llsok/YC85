package com.yc.favorite;

import org.apache.ibatis.session.SqlSession;

import com.yc.favorite.bean.Favorite;
import com.yc.favorite.bean.Tag;
import com.yc.favorite.bean.TagFavorite;
import com.yc.favorite.dao.FavoriteMapper;
import com.yc.favorite.dao.TagFavoriteMapper;
import com.yc.favorite.dao.TagMapper;
import com.yc.favorite.util.MyBatisHelper;

public class FavoriteBiz {

	public void addFavorite(Favorite f) {
		/**
		 * Favorite:
		 * 1  淘宝  taobao.com 好网站     购物,生活
		 * 2  网易  163.com    常用网址 门户,军事,生活
		 * 
		 * TagFavorite( 中间表 : tid  fid)
		 * 1  1
		 * 2  1
		 * 3  2
		 * 4  2
		 * 2  2
		 * 
		 * Tag
		 * 1 购物 1
		 * 2 生活 2
		 * 3 门户 1
		 * 4 军事 1
		 */
		SqlSession session = MyBatisHelper.openSession();
		FavoriteMapper fm = session.getMapper(FavoriteMapper.class);
		TagMapper tm = session.getMapper(TagMapper.class);
		TagFavoriteMapper tfm = session.getMapper(TagFavoriteMapper.class);

		try {
			// 添加链接到 favorite 表, insert 方法会带回 fid 的值
			fm.insert(f);
			// 拆分分类 ftags
			String[] tags = f.getFtags().split("[,，；;]");
			for (String tag : tags) {
				Tag tagObj = new Tag();
				// 直接修改分类的数量
				if (tm.updateCount(tag) == 0) {
					// 如果返回的结果为 0 表示没有修改到对应记录, 那么就新增
					tagObj.setTname(tag);
					tm.insert(tagObj);
				} else {
					// 过有返回的结果为 1 表示修改数量成功
					// 并且查询数据对应的 tag 对象
					tagObj = tm.selectByName(tag);
				}
				// 根据分类tid 和 链接的fid , 向中间表写入记录
				TagFavorite tf = new TagFavorite();
				tf.setTid(tagObj.getTid());
				tf.setFid(f.getFid());
				tfm.insert(tf);
				// 提交
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚
			session.rollback();
		} finally {
			session.close();
		}
	}

}
