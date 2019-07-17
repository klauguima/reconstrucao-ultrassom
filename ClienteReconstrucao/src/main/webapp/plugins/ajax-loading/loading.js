var loading;
$(function() {
	loading = $.loading({
		ajax       : true,

		// CSS id for the AJAX loading animation
		id         : 'ajaxLoading',

		// CSS z-inde
		zIndex     : '1000',

		// background color
		background : 'rgba(0, 0, 0, 0.7)',

		// minimum duration
		minTime    : 200,

		// CSS styles
		radius     : '4px',
		width      : '100%',
		height     : '100%',

		// loading spinner
		imgPath    : 'plugins/ajax-loading/img/ajax-loading.gif',
		imgWidth   : '45px',
		imgHeight  : '45px',

		// loading text
		tip        : 'Processando...',
		fontSize   : '14px',
		fontColor  : '#fff'
	});
});