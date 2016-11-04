$(function()
{
	$('#validateAdherent').click(function()
	{
		$('#modifyAdherent').removeClass('moins');
		$('#readOnly').removeClass('moins');
	})
	
	$('#cancelAdherent').click(function()
	{
		$('#modifyAdherent').removeClass('moins');
		$('#readOnly').removeClass('moins');
	})
			
	$('#modifyAdherentButton').click(function()
	{
		$('#modifyAdherent').addClass('moins');
		$('#readOnly').addClass('moins');
	})
})

$(function()
{		
	$('.glyphicon').click(function()
	{
		var id = $(this).attr('id');
			
		if(!$(this).hasClass('glyphicon-sort-by-alphabet')) {
			if(id == 'spanTriTitre')
			{
				$('#spanTriTitre').addClass('glyphicon-sort-by-alphabet')
				$('#spanTriDateEmprunt').addClass('glyphicon-sort');
				$('#spanTriDateRetour').addClass('glyphicon-sort');
	
				$('#spanTriTitre').removeClass('glyphicon-sort')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet-alt')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet-alt');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet-alt');
			}
			else if (id == 'spanTriDateEmprunt')
			{
	
				$('#spanTriTitre').addClass('glyphicon-sort');
				$('#spanTriDateEmprunt').addClass('glyphicon-sort-by-alphabet');
				$('#spanTriDateRetour').addClass('glyphicon-sort');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet-alt')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet-alt');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet-alt');
			}
			else
			{
	
				$('#spanTriTitre').addClass('glyphicon-sort');
				$('#spanTriDateEmprunt').addClass('glyphicon-sort');
				$('#spanTriDateRetour').addClass('glyphicon-sort-by-alphabet');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet');
				$('#spanTriDateRetour').removeClass('glyphicon-sort');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet-alt')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet-alt');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet-alt');
			}
		}
		else
		{
			if(id == 'spanTriTitre')
			{
				$('#spanTriTitre').addClass('glyphicon-sort-by-alphabet-alt')
				$('#spanTriDateEmprunt').addClass('glyphicon-sort');
				$('#spanTriDateRetour').addClass('glyphicon-sort');
	
				$('#spanTriTitre').removeClass('glyphicon-sort')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet-alt');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet-alt');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet');
			}
			else if (id == 'spanTriDateEmprunt')
			{
	
				$('#spanTriTitre').addClass('glyphicon-sort');
				$('#spanTriDateEmprunt').addClass('glyphicon-sort-by-alphabet-alt');
				$('#spanTriDateRetour').addClass('glyphicon-sort');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet-alt')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet-alt');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet');
			}
			else
			{
	
				$('#spanTriTitre').addClass('glyphicon-sort');
				$('#spanTriDateEmprunt').addClass('glyphicon-sort');
				$('#spanTriDateRetour').addClass('glyphicon-sort-by-alphabet-alt');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet-alt')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet-alt');
				$('#spanTriDateRetour').removeClass('glyphicon-sort');
	
				$('#spanTriTitre').removeClass('glyphicon-sort-by-alphabet')
				$('#spanTriDateEmprunt').removeClass('glyphicon-sort-by-alphabet');
				$('#spanTriDateRetour').removeClass('glyphicon-sort-by-alphabet');
			}
		}
	})
})