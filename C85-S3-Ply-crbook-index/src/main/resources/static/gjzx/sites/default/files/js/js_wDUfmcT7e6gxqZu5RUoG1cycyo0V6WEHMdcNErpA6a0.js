/**
 * @file
 * A JavaScript file for the theme.
 *
 * In order for this JavaScript to be loaded on pages, see the instructions in
 * the README.txt next to this file.
 */

// JavaScript should be made compatible with libraries other than jQuery by
// wrapping it with an "anonymous closure". See:
// - http://drupal.org/node/1446420
// - http://www.adequatelygood.com/2010/3/JavaScript-Module-Pattern-In-Depth

jQuery.noConflict();  //将变量$的控制权让渡给prototype.js
(function($) { 
$(function() {
	$('.front .view-uc-popular-products .item-list ul li').each(function(){
      $(this).hover(function(){
        //alert('12345678');
		$(this).addClass('views-row-first');
		$(this).siblings('li').removeClass('views-row-first');
      });		  
    });
	

	$("#all-categorys").hover(function () {　
	  $("#all-categorys").addClass('hover');
	},function(){
	  $("#all-categorys").removeClass('hover');
	});
	
	$("#all-categorys #bookstore-all-terms .item").hover(function () {　
	  $(this).addClass('hover');
	},function(){
	  $(this).removeClass('hover');
	});	
	
	$("#all-categorys #bookstore-all-terms .close").click(function (e) {　
	  $("#all-categorys").removeClass('hover');
	});
	
	$("#all-terms1 #bookstore-all-terms1 .item").hover(function () {　
	  $(this).addClass('hover');
	},function(){
	  $(this).removeClass('hover');
	});		
// Place your code here.
    $("#mininav_left .favorite a").click(function (e) {　　　　//$里面是链接的id   
    e.preventDefault(); // this will prevent the anchor tag from going the user off to the link
    var bookmarkUrl = this.href;
    var bookmarkTitle = this.title;
    var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd' : 'CTRL';  
    if (window.sidebar) { // For Mozilla Firefox Bookmark
	   try{
        window.sidebar.addPanel(bookmarkTitle, bookmarkUrl,"");
		}
		catch(e){
		   alert('添加失败\n您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~');  
		}
    } else if( window.external || document.all) { // For IE Favorite
        window.external.AddFavorite( bookmarkUrl, bookmarkTitle);
    } else if(window.opera) { // For Opera Browsers
        $("a.jQueryBookmark").attr("href",bookmarkUrl);
        $("a.jQueryBookmark").attr("title",bookmarkTitle);
        $("a.jQueryBookmark").attr("rel","sidebar");
    } else { // for other browsers which does not support
        alert('添加失败\n您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~');  
        return false;
    }		
    }); 

	$("#shopping-cart-block dl").hover(function () {　
	  $(this).addClass('hover');
	},function(){
	  $(this).removeClass('hover');
	});	
    $("#shopping-cart-block dd .p-detail a.delete").click(function (e) {	
	  var qrt = $(this).attr('qrt');
	  var sum = $(this).attr('sum');
	  var nid = $(this).attr('data-id');
	  //alert(Drupal.settings.base_path);
	  var shoppingamount =  $('#shopping-amount').html();
	  var shoppingsum = $('#shopping-sum').html();
	  shoppingamount = shoppingamount - qrt;
	  shoppingsum = shoppingsum - sum;
	  $('#shopping-amount').html(shoppingamount);
	  $('#shopping-sum').html(shoppingsum.toFixed(2));
	  $('#shopping-cart-block #cart-content .cart-content-summary b').html(shoppingamount);
      $.get(Drupal.settings.basePath + "cart/remove/" + nid, function( data ) {

      });  
	  $(this).parent().parent().remove();
	});	
	
	if($('.node-type-book .book_detail .float-nav-wrap').length > 0){
	  var otop = $('.node-type-book .book_detail .float-nav-wrap .mt').offset().top; //存储原来的距离顶部的距离
	}
	//var toolbar = $('#toolbar');
	//alert(toolbar);
	$(window).scroll(function () {
	  var st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
	  if (st > otop) {
	    $('.node-type-book .book_detail .float-nav-wrap .mt').addClass('top-fixed');
		$('.node-type-book .book_detail .float-nav-wrap .mt').css('top', '0px;');
		//var toolbar = $('#toolbar');
		if($('#toolbar').length > 0){
		  $('.node-type-book .book_detail .float-nav-wrap .mt').css('top', '30px');
		}
		//alert('success');
	  }else{
	    $('.node-type-book .book_detail .float-nav-wrap .top-fixed').removeClass('top-fixed');
		//$('.node-type-book .book_detail .float-nav-wrap .mt').css('top', 'auto');
	  }
	});
	
	$(".book_detail .book_desc .float-nav-wrap #nav-minicart").hover(function () {　
	  $(".book_detail .book_desc .float-nav-wrap #nav-minicart").addClass('hover');
	},function(){
	  $(".book_detail .book_desc .float-nav-wrap #nav-minicart").removeClass('hover');
	});
	
	$('.book_detail .book_desc .float-nav-wrap ul.tab li').click(function(){
        //alert('12345678');
		$(this).addClass('curr');
		$(this).siblings('li').removeClass('curr');	  
		//管理员看到toobar,需要减去30px
		if($('#toolbar').length > 0){
		  otop = otop -30;
		}
		$("html,body").animate({scrollTop:otop},100);
		if($(this).hasClass("fore")){
		  $('.book_detail .book_desc #product-detail-1').css('display', 'block');
		  $('.book_detail .book_desc #product-detail-2').css('display', 'none');
        }else{
		  $('.book_detail .book_desc #product-detail-1').css('display', 'none');
		  $('.book_detail .book_desc #product-detail-2').css('display', 'block');		
		}
    });	
/*	
	if($('.node-type-book .book_detail .float-nav-wrap').length > 0){
	  $("#content").height($('#content .panel-front .panel-col-last').height());
	}
*/	
});
})(jQuery);

(function ($) {
$(document).bind('flagGlobalAfterLinkUpdate', function(event, data) {
  if (data.flagName == 'want' && data.flagStatus == 'unflagged') {
    if ($(data.link).parents('.views-field-ops').size()) { // Are we inside the view?
      $(data.link).parents('td').hide('slow');
    }
  }
});
})(jQuery);

;
