$(function() {
	$('#tasklegend').appendTo('#_ProjectTasks_WAR_AdvancedTaskListportlet_advTasksSearchContainer_col-status');
	$helpicon = $('#tasklegend .helpicon');
	$menu = $('#tasklegend #legend');
	var mouseOverIcon = false;
	$helpicon.on('click', function() {
		if(!$menu.hasClass('open')) {
			$menu.addClass('open').show();
		} else {
			$menu.removeClass('open').hide();
		}
	});
	$helpicon.on('mouseenter', function() {
			mouseOverIcon = true;
	});
	$helpicon.on('mouseleave', function() {
			mouseOverIcon = false;
});
	$(document).on('click', function() {
		if(!mouseOverIcon) {
			$('#tasklegend .open').removeClass('open').hide();
		} 
	}); 
	
	
});