/**
 * 
 */


$("input.addATag_add").live('click', function(){
	var $tr = $(this).closest('.addATag');
	var $clone = $tr.clone();
	$clone.find(':text').val('');
	$tr.after($clone);
});