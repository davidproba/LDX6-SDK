function stickNavbar() {
	if($(".proNav").offset().top<2) {
		$(".proNav").addClass("fixedNav");
	} else {
		$(".proNav").removeClass("fixedNav");
	}
}

$(window).scroll(stickNavbar);

$(function() {
	$dest = $('.button-holder');
	$target = $('#actionswrapper');
	$ai = $('#actionItem');
	var mouseOverIcon = false;
	
	$ai.on('click', function() {
		if(!$target.hasClass('open')) {
			$target.addClass('open').show();
		} else {
			$target.removeClass('open').hide();
		}
	});
	$ai.on('mouseenter', function() {
			mouseOverIcon = true;
	});
	$ai.on('mouseleave', function() {
			mouseOverIcon = false;
	});
	$(document).on('click', function() {
		if(!mouseOverIcon) {
			$target.removeClass('open').hide();
		} 
	}); 

	$dest.on('DOMNodeInserted', function(e) {
		$ai.show().css({'display': 'inline-block'});
		$et = $(e.target);
		if($et.is("button")) {
			$tmp = $("<li></li>");
			$tmp.appendTo($target);	
			$et.appendTo($tmp);
		}
		if($et.is(".btn-group")) {
			$tmp = $("<li></li>");
			$tmp.appendTo($target);	
//			$et.appendTo($tmp);
			$et.children('button').each(function() {
				$tmp = $("<li></li>");
				$tmp.appendTo($target);	
				$(this).appendTo($tmp);
			});
		} 
	});
});

