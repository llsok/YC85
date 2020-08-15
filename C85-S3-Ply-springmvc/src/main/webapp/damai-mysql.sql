/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-06-19 14:32:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dm_address
-- ----------------------------
DROP TABLE IF EXISTS `dm_address`;
CREATE TABLE `dm_address` (
  `id` int(11) NOT NULL auto_increment,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `addr` varchar(255) default NULL COMMENT '地址',
  `phone` varchar(50) default NULL COMMENT '收货人电话',
  `name` varchar(50) default NULL COMMENT '收货人姓名',
  `dft` bit(1) default NULL COMMENT '默认地址 1默认',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_address
-- ----------------------------

-- ----------------------------
-- Table structure for dm_adminuser
-- ----------------------------
DROP TABLE IF EXISTS `dm_adminuser`;
CREATE TABLE `dm_adminuser` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_adminuser
-- ----------------------------
INSERT INTO `dm_adminuser` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for dm_cart
-- ----------------------------
DROP TABLE IF EXISTS `dm_cart`;
CREATE TABLE `dm_cart` (
  `id` int(11) NOT NULL auto_increment COMMENT '购物车ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `pid` int(11) NOT NULL COMMENT '商品ID',
  `count` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_cart
-- ----------------------------
INSERT INTO `dm_cart` VALUES ('1', '2', '1', '1');
INSERT INTO `dm_cart` VALUES ('2', '2', '2', '1');

-- ----------------------------
-- Table structure for dm_category
-- ----------------------------
DROP TABLE IF EXISTS `dm_category`;
CREATE TABLE `dm_category` (
  `id` int(11) NOT NULL auto_increment,
  `cname` varchar(255) default NULL,
  `pid` int(11) default NULL COMMENT '父id 关联本表 id (自关联)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_category
-- ----------------------------
INSERT INTO `dm_category` VALUES ('1', '女装男装', null);
INSERT INTO `dm_category` VALUES ('2', '鞋靴箱包', null);
INSERT INTO `dm_category` VALUES ('3', '运动户外', null);
INSERT INTO `dm_category` VALUES ('4', '珠宝配饰', null);
INSERT INTO `dm_category` VALUES ('5', '手机数码', null);
INSERT INTO `dm_category` VALUES ('6', '家电办公', null);
INSERT INTO `dm_category` VALUES ('7', '护肤彩妆', null);
INSERT INTO `dm_category` VALUES ('9', '女鞋', '2');
INSERT INTO `dm_category` VALUES ('10', '短靴', '2');
INSERT INTO `dm_category` VALUES ('11', '男鞋', '2');
INSERT INTO `dm_category` VALUES ('12', '女包', '2');
INSERT INTO `dm_category` VALUES ('13', '男包', '2');
INSERT INTO `dm_category` VALUES ('14', '服饰配件', '2');
INSERT INTO `dm_category` VALUES ('15', '运动鞋', '3');
INSERT INTO `dm_category` VALUES ('16', '运动服', '3');
INSERT INTO `dm_category` VALUES ('17', '户外运动', '3');
INSERT INTO `dm_category` VALUES ('18', '健身装备', '3');
INSERT INTO `dm_category` VALUES ('19', '骑行装备', '3');
INSERT INTO `dm_category` VALUES ('20', '珠宝首饰', '4');
INSERT INTO `dm_category` VALUES ('21', '时尚饰品', '4');
INSERT INTO `dm_category` VALUES ('22', '品质手表', '4');
INSERT INTO `dm_category` VALUES ('23', '眼镜配饰', '4');
INSERT INTO `dm_category` VALUES ('24', '手机', '5');
INSERT INTO `dm_category` VALUES ('25', '平板', '5');
INSERT INTO `dm_category` VALUES ('26', '电脑', '5');
INSERT INTO `dm_category` VALUES ('27', '相机', '5');
INSERT INTO `dm_category` VALUES ('28', '大家电', '6');
INSERT INTO `dm_category` VALUES ('29', '厨房电器', '6');
INSERT INTO `dm_category` VALUES ('30', '生活电器', '6');
INSERT INTO `dm_category` VALUES ('31', '个户电器', '6');
INSERT INTO `dm_category` VALUES ('32', '办公耗材', '6');
INSERT INTO `dm_category` VALUES ('33', '美容护肤', '7');
INSERT INTO `dm_category` VALUES ('34', '强效保养', '7');
INSERT INTO `dm_category` VALUES ('35', '超值彩妆', '7');
INSERT INTO `dm_category` VALUES ('36', '换季保养', '7');
INSERT INTO `dm_category` VALUES ('37', '潮流女装', '1');
INSERT INTO `dm_category` VALUES ('38', '初冬羽绒', '1');
INSERT INTO `dm_category` VALUES ('39', '毛呢大衣', '1');
INSERT INTO `dm_category` VALUES ('40', '温暖毛衣', '1');
INSERT INTO `dm_category` VALUES ('41', '精选男装', '1');
INSERT INTO `dm_category` VALUES ('42', '冬季外套', '1');
INSERT INTO `dm_category` VALUES ('43', '羽绒服', '1');

-- ----------------------------
-- Table structure for dm_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `dm_orderitem`;
CREATE TABLE `dm_orderitem` (
  `id` int(11) NOT NULL auto_increment,
  `count` int(11) default NULL,
  `total` double default NULL COMMENT '商品金额',
  `pid` int(11) default NULL COMMENT '商品id:关联dm_product.id',
  `oid` int(11) default NULL COMMENT '订单id:关联dm_orders.id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_orderitem
-- ----------------------------
INSERT INTO `dm_orderitem` VALUES ('59', '1', '228', '1', '64');
INSERT INTO `dm_orderitem` VALUES ('60', '1', '228', '1', '65');
INSERT INTO `dm_orderitem` VALUES ('61', '1', '119', '9', '66');
INSERT INTO `dm_orderitem` VALUES ('62', '1', '172', '2', '66');
INSERT INTO `dm_orderitem` VALUES ('63', '1', '198', '21', '67');
INSERT INTO `dm_orderitem` VALUES ('64', '1', '358', '47', '67');
INSERT INTO `dm_orderitem` VALUES ('65', '1', '119', '5', '68');
INSERT INTO `dm_orderitem` VALUES ('66', '1', '198', '21', '68');
INSERT INTO `dm_orderitem` VALUES ('67', '1', '299', '56', '69');
INSERT INTO `dm_orderitem` VALUES ('68', '1', '358', '44', '69');
INSERT INTO `dm_orderitem` VALUES ('69', '1', '358', '51', '69');
INSERT INTO `dm_orderitem` VALUES ('70', '10', '3580', '48', '70');
INSERT INTO `dm_orderitem` VALUES ('71', '1', '198', '21', '71');
INSERT INTO `dm_orderitem` VALUES ('72', '2', '344', '2', '72');
INSERT INTO `dm_orderitem` VALUES ('73', '2', '372', '31', '72');
INSERT INTO `dm_orderitem` VALUES ('74', '1', '228', '1', '73');
INSERT INTO `dm_orderitem` VALUES ('75', '1', '299', '54', '73');
INSERT INTO `dm_orderitem` VALUES ('76', '1', '590', '7', '73');
INSERT INTO `dm_orderitem` VALUES ('77', '3', '29700', '14', '73');

-- ----------------------------
-- Table structure for dm_orders
-- ----------------------------
DROP TABLE IF EXISTS `dm_orders`;
CREATE TABLE `dm_orders` (
  `id` int(11) NOT NULL auto_increment,
  `total` double default NULL COMMENT '总金额',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '订单时间',
  `state` int(11) default '0' COMMENT '状态: 0未支付,1已支付,2已发货,3已收货,4已评价,5已退货',
  `uid` int(11) default NULL COMMENT '用户id',
  `aid` int(11) default NULL COMMENT '收货地址id: 关联 dm_address.id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_orders
-- ----------------------------
INSERT INTO `dm_orders` VALUES ('64', '228', '2017-11-21 19:46:44', '1', '1', null);
INSERT INTO `dm_orders` VALUES ('65', null, '2017-11-21 20:02:21', '1', '4', null);
INSERT INTO `dm_orders` VALUES ('66', null, '2017-11-21 20:07:04', '1', '4', null);
INSERT INTO `dm_orders` VALUES ('67', null, '2017-11-21 20:09:47', '1', '4', null);
INSERT INTO `dm_orders` VALUES ('68', '317', '2017-11-21 20:13:44', '1', '4', null);
INSERT INTO `dm_orders` VALUES ('69', '1015', '2017-11-21 20:20:41', '2', '4', null);
INSERT INTO `dm_orders` VALUES ('70', '3580', '2017-11-21 20:25:30', '2', '4', null);
INSERT INTO `dm_orders` VALUES ('71', '198', '2017-11-27 13:22:58', '1', '4', null);
INSERT INTO `dm_orders` VALUES ('72', '716', '2019-10-16 10:40:31', '1', '1', null);
INSERT INTO `dm_orders` VALUES ('73', '30817', '2019-10-16 11:05:52', '1', '1', null);

-- ----------------------------
-- Table structure for dm_product
-- ----------------------------
DROP TABLE IF EXISTS `dm_product`;
CREATE TABLE `dm_product` (
  `id` int(11) NOT NULL auto_increment,
  `pname` varchar(255) default NULL COMMENT '商品名称',
  `market_price` double default NULL COMMENT '市场价',
  `shop_price` double default NULL COMMENT '商城价',
  `image` varchar(255) default NULL COMMENT '商品图片地址',
  `pdesc` varchar(255) default NULL COMMENT '商品描述',
  `is_hot` int(11) default NULL COMMENT '热销商品标志',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  `cid` int(11) default NULL COMMENT '分类id 关联 dm_category.id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_product
-- ----------------------------
INSERT INTO `dm_product` VALUES ('1', '韩版连帽加厚毛衣女外套', '558', '228', 'products/1/cs10001.jpg', '双11限量200件，拍完下架，加车享优惠，早下手早发货。。秋冬个性中长款毛衣，美丽和温度同在！限量供应，拒绝撞衫！迫于纱线和人工在不断上涨的双重压力下，产品涨价在即！少量现货出售中，手快有，手慢等哦，赶紧抢哦，绝对高大上。', '1', '2014-11-02 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('2', '女装立领长袖拼接PU皮毛呢外套', '436', '172', 'products/1/cs10002.jpg', '【现在拍下并支付定金，即可获得双12当天10元无门槛优惠券一张。注：只限有预付定金款~优惠券统一在12月11号发放】 毛呢外套 整洁干练的长款版型 整个肩部给予皮绒拼接 与毛呢一起撑起品质感 立领 长袖 肩部往下做流行加层拼接 一粒扣收合门襟 特意做的夹棉里层（袖里无） 不必再畏惧冷冽寒风', '0', '2014-11-04 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('3', '韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10003.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-10-01 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('4', '韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10004.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-12-07 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('5', '韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10005.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-11-02 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('6', '冬装韩版女装翻领羔绒夹棉格子毛呢外套', '238', '119', 'products/1/cs10006.jpg', '外套款。 称为棉衣也不为过 或者因为它的表层毛呢　称呼为毛呢外套 ｙａｎｇ　羔绒位于翻领及袖口 从视觉着手　带来温暖无限 夹棉里衬（袖里也有）再次提升御寒功能 流行元素上　选择红黑格纹理　大气而又经典 金属拉链开叉　插袋自不会少', '0', '2014-11-10 15:18:00', '1');
INSERT INTO `dm_product` VALUES ('7', '新款优雅奢华毛领白鸭绒轻薄羽绒服', '1120', '590', 'products/1/cs10007.jpg', '秋冬热卖款，今日特惠！库存有限，卖完即止！喜欢的赶紧出手哦！', '0', '2014-11-03 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('8', '秋冬季毛呢外套女中长款圆领小香风呢子大衣', '672', '336', 'products/1/cs10008.jpg', '【双12预售】双12提前开抢，11月24日—12月11日抢先付预付款33.6元，12月12日付剩余尾款，先付先发货，提前引爆双12！！！买就【送】双十二10元无门槛优惠券！！！商家【赠】运费险！！！', '0', '2014-11-03 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('9', '女装貉子毛大衣 时尚修身长袖淑女毛呢外套', '238', '119', 'products/1/cs10009.jpg', '秋冬热卖款，今日特惠！库存有限，卖完即止！喜欢的赶紧出手哦！', '0', '2014-11-03 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('10', '修身显瘦淑女针织长袖打底连衣裙女', '356', '158', 'products/1/cs10010.jpg', '【1212万能盛典预售抢先购,早买早便宜！】定金15.80元，预售价158.00元，双12价涨价至178.00元!', '0', '2014-11-03 20:18:00', '1');
INSERT INTO `dm_product` VALUES ('11', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20001.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('12', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20002.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('13', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20003.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('14', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20004.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('15', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20005.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('16', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20006.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('17', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20007.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('18', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20008.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('19', '整貂皮大衣外套中长款收腰立领长袖进口真皮草裘皮', '19800', '9900', 'products/1/cs20009.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货 【售后保障】终身免费保养维修', '0', '2014-10-01 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('20', '中长款貂皮大衣整貂女装', '17900', '7290', 'products/1/cs20010.jpg', '采用100%进口小母貂 毛皮结实柔软毛峰更有光泽 保暖效果极强。　 【正品保证】【售后保障】我们承诺100%整皮水貂 假一罚十 支持验货 无理由退换货', '0', '2014-11-03 20:18:00', '2');
INSERT INTO `dm_product` VALUES ('21', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30001.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '1', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('22', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30002.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('23', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30003.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('24', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30004.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('25', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30005.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('26', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30006.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('27', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30007.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('28', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30008.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('29', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30009.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-03 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('30', '韩版毛呢外套女韩范秋冬装厚中长款冬季呢子', '598', '198', 'products/1/cs30010.png', '今年韩国首尔爆款，超高端定制羊毛呢大衣，版型超美，不挑身材，不挑年龄，上身非常漂亮哦，适合任何场合，这个秋冬MM必备款哦。几乎人手一件，美丽时尚的你怎么能少了这件呢，现秋冬预热加十一到来，只需99元包邮，只限今天，今天过后马上涨价，早买早划算哦~', '0', '2014-11-10 20:18:00', '3');
INSERT INTO `dm_product` VALUES ('31', '打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40001.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('32', '打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40002.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('33', '打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40003.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('34', '性感时尚 酷感黑色小圆领露肩修身长袖针织衫', '387', '186', 'products/1/cs40004.jpg', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('35', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40005.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '1', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('36', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40006.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('37', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40007.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('38', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40008.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('39', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40009.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('40', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40010.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '0', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('41', '韩版黑色打底衫加厚修身羊毛衫女装羊绒衫', '387', '186', 'products/1/cs40011.png', '本产品 不起球 不掉色 不缩水 是一款贴身必备的厚款羊绒衫 质量保证支持退换', '1', '2014-11-03 20:18:00', '4');
INSERT INTO `dm_product` VALUES ('42', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50001.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('43', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50002.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('44', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50003.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('45', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50004.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-12-07 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('46', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50005.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('47', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50006.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('48', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50007.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('49', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50008.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('50', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50009.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '0', '2014-11-03 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('51', '冬装外套棉衣立领修身商务大码男装潮牌上衣', '899', '358', 'products/1/cs50010.png', '【型男卖点简介】该款凭借其独特的设计、精选的面料和一致的时尚理念，以质感都市，充满时尚感的设计风格， 简约毛呢大衣，修身不变形，不起球，国际大牌一样的面料！面料成分：77.8%聚酯纤维+22.2%粘纤 秋冬简约修身防静电呢风衣外套', '1', '2014-12-07 20:18:00', '5');
INSERT INTO `dm_product` VALUES ('52', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60001.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('53', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60002.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('54', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60003.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('55', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60004.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('56', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60005.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('57', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60006.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-12-07 22:18:00', '6');
INSERT INTO `dm_product` VALUES ('58', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60007.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('59', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60008.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('60', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60009.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '1', '2014-12-02 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('61', '商务修身羊毛呢子风衣 中长款呢大衣外套', '997', '299', 'products/1/cs60010.png', '冬装新品首发！大牌做工，顶级羊毛呢面料，穿着舒适保暖，冬季潮男必备品！新品预售价299元，预计涨到398！不要拿市场上那些低劣的毛呢大衣相比较，一分价钱一分货哦！买到就是赚到，支持7天无理由退换货，尺码不对，可享受免费换货！', '0', '2014-11-03 20:18:00', '6');
INSERT INTO `dm_product` VALUES ('62', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70001.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('63', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70002.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('64', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70003.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '0', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('65', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70004.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('66', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70005.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '0', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('67', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70006.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('68', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70007.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-12-04 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('69', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70008.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('70', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70009.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '0', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('71', '韩版修身羽绒服加厚保暖可脱卸帽', '198', '83.16', 'products/1/cs70010.png', '羽绒棉服，保暖性比普通棉服高出3倍，价格合适，比羽绒服便宜3倍，超高性价比～～现亏本冲业绩，活动过后涨价为198元哦，亲们速抢～～！！', '1', '2014-11-03 20:18:00', '7');
INSERT INTO `dm_product` VALUES ('72', '冬季新款大码女装修身加厚棉打底连衣裙女', '200', '125', 'products/1/cs10011.jpg', 'upload', '1', '2014-12-15 00:00:00', '1');

-- ----------------------------
-- Table structure for dm_user
-- ----------------------------
DROP TABLE IF EXISTS `dm_user`;
CREATE TABLE `dm_user` (
  `id` int(11) NOT NULL auto_increment,
  `ename` varchar(20) default NULL COMMENT '英文名(账号)',
  `cname` varchar(20) default NULL COMMENT '中文名(昵称)',
  `password` varchar(64) default NULL,
  `email` varchar(40) default NULL COMMENT '邮箱',
  `phone` varchar(20) default NULL COMMENT '电话',
  `sex` varchar(10) default NULL COMMENT '性别',
  `state` int(11) default NULL COMMENT '状态',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dm_user
-- ----------------------------
INSERT INTO `dm_user` VALUES ('1', 'w', '悟空', 'a', 'song@foxmail.com', '13283718600', '男', '1', null);
INSERT INTO `dm_user` VALUES ('2', 'b', '八戒', 'a', 'song@shop.com', '13283710000', '男', '1', null);
INSERT INTO `dm_user` VALUES ('4', 'n', '哪吒', 'a', 'song@shop.com', '13283710000', '男', '1', null);
